package com.nimsoc.reactive.transformer;

import com.nimsoc.reactive.crypto.Crypto;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class CryptoTransformProcessor<R> extends SubmissionPublisher<R> implements Flow.Processor<Crypto, R> {

  private final Function<Crypto, R> function;
  private Flow.Subscription subscription;

  public CryptoTransformProcessor(Function<Crypto, R> function) {
    super();
    this.function = function;
  }

  @Override
  public void onSubscribe(Flow.Subscription subscription) {
    this.subscription = subscription;
    subscription.request(1);
  }

  @Override
  public void onNext(Crypto item) {
    submit(function.apply(item));
    subscription.request(1);
  }

  @Override
  public void onError(Throwable t) {
    t.printStackTrace();
  }

  @Override
  public void onComplete() {
    close();
  }
}
