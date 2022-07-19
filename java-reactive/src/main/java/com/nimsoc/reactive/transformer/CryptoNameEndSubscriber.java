package com.nimsoc.reactive.transformer;

import com.google.common.annotations.VisibleForTesting;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;

public class CryptoNameEndSubscriber implements Subscriber<String> {

  private final AtomicInteger howMuchMessagesToConsume;
  private Subscription subscription;
  @VisibleForTesting
  public List<String> consumedElements = new LinkedList<>();

  public CryptoNameEndSubscriber(Integer howMuchMessagesToConsume) {
    this.howMuchMessagesToConsume = new AtomicInteger(howMuchMessagesToConsume);
  }

  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
    subscription.request(1);
  }

  @Override
  public void onNext(String item) {

    howMuchMessagesToConsume.decrementAndGet();
    System.out.println("Received : " + item);

    consumedElements.add(item);
    if (howMuchMessagesToConsume.get() > 0) {
      subscription.request(1);
    }

  }

  @Override
  public void onError(Throwable t) {
    System.out.println("error: " + t.getMessage());
    System.out.println("stop");
  }

  @Override
  public void onComplete() {
    System.out.println("Completed!");
  }
}
