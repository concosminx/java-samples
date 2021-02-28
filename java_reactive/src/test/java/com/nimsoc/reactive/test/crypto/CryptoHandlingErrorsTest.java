package com.nimsoc.reactive.test.crypto;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import com.nimsoc.reactive.crypto.Crypto;
import com.nimsoc.reactive.crypto.CryptoEndSubscriber;
import com.nimsoc.reactive.crypto.CryptoPublisher;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CryptoHandlingErrorsTest {
  @Test
  public void shouldContinueProcessingInCaseOfAnErrorWhenFailSilently() throws InterruptedException {
    CryptoEndSubscriber subscriber;
    //given
    try (CryptoPublisher publisher = new CryptoPublisher()) {
      subscriber = new CryptoEndSubscriber(2, true);
      publisher.subscribe(subscriber);
      List<Crypto> items = List.of(new Crypto("Bitcoin", 47125.41F), new Crypto("Dash", 12.4F));
      //when
      assertThat(publisher.getNumberOfSubscribers()).isEqualTo(1);
      items.forEach(publisher::submit);
    }

    //then
    await().atMost(1000, TimeUnit.MILLISECONDS).until(() -> assertThat(subscriber.consumedElements).containsExactlyElementsOf(List.of(new Crypto("Dash", 12.4F)))
    );
  }

  @Test
  public void shouldNotProcessAnyEventIfInFailFastMode() throws InterruptedException {
    CryptoEndSubscriber subscriber;
    //given
    try (CryptoPublisher publisher = new CryptoPublisher()) {
      subscriber = new CryptoEndSubscriber(2, false);
      publisher.subscribe(subscriber);
      List<Crypto> items = List.of(new Crypto("Bitcoin", 47125.41F), new Crypto("Dash", 12.4F));
      //when
      assertThat(publisher.getNumberOfSubscribers()).isEqualTo(1);
      items.forEach(publisher::submit);
    }

    //then
    await().atMost(1000, TimeUnit.MILLISECONDS).until(
        () -> assertThat(subscriber.consumedElements)
            .containsExactlyElementsOf(List.of())
    );
  }

}
