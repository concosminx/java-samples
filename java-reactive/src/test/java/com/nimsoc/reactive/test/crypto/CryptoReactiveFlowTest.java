package com.nimsoc.reactive.test.crypto;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import com.nimsoc.reactive.crypto.Crypto;
import com.nimsoc.reactive.crypto.CryptoEndSubscriber;
import com.nimsoc.reactive.crypto.CryptoPublisher;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CryptoReactiveFlowTest {

  @Test
  public void givenPublisher_whenSubscribeToIt_thenShouldConsumeAllElements() throws InterruptedException {
    CryptoEndSubscriber subscriber;
    List<Crypto> items;
    //given
    try (CryptoPublisher publisher = new CryptoPublisher()) {
      subscriber = new CryptoEndSubscriber(2, true);
      publisher.subscribe(subscriber);
      items = List.of(new Crypto("Ethereum", 1795.99F), new Crypto("Litecoin", 208.66F));
      
      //when
      assertThat(publisher.getNumberOfSubscribers()).isEqualTo(1);
      items.forEach(publisher::submit);
    }

    //then
    await().atMost(1000, TimeUnit.MILLISECONDS).until(
            () -> assertThat(subscriber.consumedElements)
                    .containsExactlyElementsOf(items)
    );
  }

}
