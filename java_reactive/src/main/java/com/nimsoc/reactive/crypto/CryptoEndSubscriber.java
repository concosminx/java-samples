package com.nimsoc.reactive.crypto;

import com.google.common.annotations.VisibleForTesting;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;

public class CryptoEndSubscriber implements Subscriber<Crypto> {
  private final AtomicInteger howMuchMessagesToConsume;
  private boolean failSilently;
  private Subscription subscription;
  
  @VisibleForTesting
  public List<Crypto> consumedElements = new LinkedList<>();

  public static CryptoEndSubscriber createUnbounded() {
    return new CryptoEndSubscriber(Integer.MAX_VALUE);
  }

  public CryptoEndSubscriber(Integer howMuchMessagesToConsume) {
    this(howMuchMessagesToConsume, false);
  }

  public CryptoEndSubscriber(Integer howMuchMessagesToConsume, boolean failSilently) {
    this.howMuchMessagesToConsume = new AtomicInteger(howMuchMessagesToConsume);
    this.failSilently = failSilently;
  }

  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
    subscription.request(1);
  }

  @Override
  public void onNext(Crypto item) {
    
    int toIncrement = howMuchMessagesToConsume.decrementAndGet();
    
    System.out.println("Received : " + item);
    
    if (isForbiddenCoin(item.getName())) {
      if (!failSilently) {
        throw new IllegalArgumentException("Cannot sell this : " + item);
      }
      System.out.println("fail ... : " + item);
    } else {
      consumedElements.add(item);
    }

    if (howMuchMessagesToConsume.get() > 0) {
      subscription.request(1);
    }

  }

  private boolean isForbiddenCoin(String name) {
    return name.contains("Bitcoin");
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