package com.nimsoc.streams_examples.various;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class StringSupplier implements Supplier<String> {

  private final AtomicInteger counter;

  public StringSupplier() {
    counter = new AtomicInteger(0);
  }

  @Override
  public String get() {
    int value = counter.getAndAdd(1);
    return "String " + value;
  }

}
