package com.nimsoc.reactive.test.publisher;

import org.junit.Test;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static com.jayway.awaitility.Awaitility.await;
import static org.assertj.core.api.Java6Assertions.assertThat;

/*
  Cold Publisher:
  Publishers by default do not produce any value unless at least 1 observer subscribes to it. 
  Publishers create new data producers for each new subscription
*/
public class ColdPublisher {

  @Test
  public void shouldUsePublisherToSendEvents() {
    
    //given
    AtomicInteger counter = new AtomicInteger();
    try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>()) {
      Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
        @Override
        public void onSubscribe(Flow.Subscription subscription) {
          System.out.println("subscriber.onSubscribe: " + subscription);
          subscription.request(1); /*request events from publisher*/
        }

        @Override
        public void onNext(String item) {
          System.out.println("subscriber.onNext: " + item);
          counter.incrementAndGet();
        }

        @Override
        public void onError(Throwable throwable) {
          System.out.println("subscriber.onError: " + throwable.getMessage());
        }

        @Override
        public void onComplete() {
          System.out.println("subscriber.onComplete");
        }
      };
      
      Stream<String> songsProducer = Stream.of("Bad Guy", "Circles", "Rain on Me", "Watermelon Sugar", "Life Goes On", "Rockstar");
      
      //when
      publisher.subscribe(subscriber); /*subscribe to publisher*/
      songsProducer.forEach(publisher::submit);
    }

    //then will fail
    await().atMost(1000, TimeUnit.MILLISECONDS).until(
            () -> assertThat(counter.get()).isEqualTo(1)
    );
  }
}
