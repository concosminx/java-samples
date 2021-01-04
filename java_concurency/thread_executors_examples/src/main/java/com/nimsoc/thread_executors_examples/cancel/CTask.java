package com.nimsoc.thread_executors_examples.cancel;

import java.util.concurrent.Callable;

/**
 *
 * @author Cosminx
 */
public class CTask implements Callable<String> {
  @Override
  public String call() throws Exception {
    while (true) {
      System.out.printf("Task: Test\n");
      Thread.sleep(100);
    }
  }
}
