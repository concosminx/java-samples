package com.nimsoc.reactive.test.publisher;

import org.junit.Test;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static com.jayway.awaitility.Awaitility.await;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Ignore;

/*
  Hot Publishers do not create new data producer for each new subscription (as the Cold Publisher does). 
  Instead there will be only one data producer and all the observers listen to the data produced by the single data producer. 
  So all the observers get the same data.
 */
public class HotPublisher {

  @Ignore(value = "infinity ... ")
  @Test
  public void shouldUsePublisherToSendEvents() {
    //given
    AtomicInteger counter = new AtomicInteger();
    try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {
      Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<>() {
        @Override
        public void onSubscribe(Flow.Subscription subscription) {
          System.out.println("subscriber.onSubscribe: " + subscription);
          subscription.request(Integer.MAX_VALUE);
          /*rquests all*/
        }

        @Override
        public void onNext(Integer item) {
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

      Stream<Integer> infiniteProducerX5 = Stream.iterate(0, i -> i + 3);
      //when

      publisher.subscribe(subscriber); /*subscribe to publisher*/
      infiniteProducerX5.forEach(publisher::submit);
    }

    //then will fail
    await().atMost(10_000, TimeUnit.MILLISECONDS).until(
            () -> assertThat(counter.get()).isEqualTo(1000)
    );
  }
}
