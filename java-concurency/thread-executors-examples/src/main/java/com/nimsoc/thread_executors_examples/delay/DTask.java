package com.nimsoc.thread_executors_examples.delay;

import java.util.concurrent.Callable;

/**
 *
 * @author Cosminx
 */
public class DTask implements Callable<String> {

  private final String name;

  public DTask(String name) {
    this.name = name;
  }

  @Override
  public String call() throws Exception {
    System.out.printf("%s: Starting at : %s\n", name, new java.util.Date());
    return "Hello, world";
  }
}
