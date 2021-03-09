package com.nimsoc.reactive.test.streampublisher;


import org.junit.Test;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import com.nimsoc.reactive.crypto.CryptoEndSubscriber;
import com.nimsoc.reactive.streampublisher.OverProducingPublisher;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class BackPressureHotPublisherTest {

  @Test
  public void whenNotUsingBackPressureSubscriberWillBeFloodedWithData() throws InterruptedException {
    //given
    OverProducingPublisher publisher = new OverProducingPublisher();
    CryptoEndSubscriber subscriber = CryptoEndSubscriber.createUnbounded();

    //when
    publisher.subscribe(subscriber);
    new Thread(() -> {
      publisher.start();
      publisher.close();
    }).start();

    //then
    await().atMost(1000, TimeUnit.MILLISECONDS).until(
        () -> assertThat(subscriber.consumedElements.size()).isGreaterThan(100)
    );
  }


  @Test
  public void shouldApplyBackPressureOnOverProducingPublisher() throws InterruptedException {
    //given
    OverProducingPublisher publisher = new OverProducingPublisher();
    CryptoEndSubscriber subscriber = new CryptoEndSubscriber(3);

    //when
    publisher.subscribe(subscriber);
    new Thread(() -> {
      publisher.start();
      publisher.close();
    }).start();

    //then
    await().atMost(1000, TimeUnit.MILLISECONDS).until(
        () -> assertThat(subscriber.consumedElements.size()).isEqualTo(3)
    );
  }

}
