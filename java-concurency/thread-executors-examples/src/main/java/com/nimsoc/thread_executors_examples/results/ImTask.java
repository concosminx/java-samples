package com.nimsoc.thread_executors_examples.results;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Cosminx
 */
public class ImTask implements Callable<ImResult> {

  private final String name;

  public ImTask(String name) {
    this.name = name;
  }

  @Override
  public ImResult call() throws Exception {
    System.out.printf("%s: Staring\n", this.name);

    // Waits during a random period of time
    Long duration = (long) (Math.random() * 10);
    System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
    TimeUnit.SECONDS.sleep(duration);

    /* sum o 5 random ints */
    int value = 0;
    for (int i = 0; i < 5; i++) {
      value += (int) (Math.random() * 100);

    }
    ImResult result = new ImResult(this.name, value);
    System.out.printf("%s: Ends\n", this.name);

    return result;
  }

}
