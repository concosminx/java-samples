package com.nimsoc.reactive.test.transformer;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import com.nimsoc.reactive.crypto.Crypto;
import com.nimsoc.reactive.crypto.CryptoPublisher;
import com.nimsoc.reactive.transformer.CryptoNameEndSubscriber;
import com.nimsoc.reactive.transformer.CryptoTransformProcessor;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CryptoTransformProcessorTest {

  @Test
  public void givenPublisher_whenSubscribeAndTransformElements_thenShouldConsumeAllElements() throws InterruptedException {
    CryptoNameEndSubscriber subscriber;
    List<String> expectedResult;
    //given
    try (CryptoPublisher publisher = new CryptoPublisher()) {
      CryptoTransformProcessor<String> transformProcessor
              = new CryptoTransformProcessor<>(Crypto::getName);
      subscriber = new CryptoNameEndSubscriber(3);
      List<Crypto> items = List.of(new Crypto("Ethereum", 1795.99F), new Crypto("Litecoin", 208.66F));
      expectedResult = List.of("Ethereum", "Litecoin");

      //when
      publisher.subscribe(transformProcessor);
      transformProcessor.subscribe(subscriber);
      items.forEach(publisher::submit);
    }

    //then
    await().atMost(1000, TimeUnit.MILLISECONDS).until(
            () -> assertThat(subscriber.consumedElements)
                    .containsExactlyElementsOf(expectedResult)
    );
  }

}
