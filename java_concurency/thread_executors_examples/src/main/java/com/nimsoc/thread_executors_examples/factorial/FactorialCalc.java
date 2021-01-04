package com.nimsoc.thread_executors_examples.factorial;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Cosminx
 */
public class FactorialCalc implements Callable<Integer> {
  
  private final Integer number;

  public FactorialCalc(Integer number) {
    this.number = number;
  }

  @Override
  public Integer call() throws Exception {
    /* https://en.wikipedia.org/wiki/Factorial */
    int result = 1;
    if ((number == 0) || (number == 1)) {
      result = 1;
    } else {
      for (int i = 2; i <= number; i++) {
        result *= i;
        TimeUnit.MILLISECONDS.sleep(20);
      }
    }
    System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);

    return result;
  }

}
