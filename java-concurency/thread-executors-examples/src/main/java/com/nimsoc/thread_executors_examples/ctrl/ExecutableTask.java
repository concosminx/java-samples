package com.nimsoc.thread_executors_examples.ctrl;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Cosminx
 */
public class ExecutableTask implements Callable<String> {

  private final String name;

  public String getName() {
    return name;
  }

  public ExecutableTask(String name) {
    this.name = name;
  }

  @Override
  public String call() throws Exception {
    try {
      Long duration = (long) (Math.random() * 10);
      System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
      TimeUnit.SECONDS.sleep(duration);
    } catch (InterruptedException e) {
    }
    return "My name is: " + name;
  }
}
