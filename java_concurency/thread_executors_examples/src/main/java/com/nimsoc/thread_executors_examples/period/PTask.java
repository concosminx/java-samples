package com.nimsoc.thread_executors_examples.period;

import java.util.Date;

/**
 *
 * @author Cosminx
 */
public class PTask implements Runnable {

  private final String name;

  public PTask(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.printf("%s: Executed at: %s\n", name, new Date());
  }
}
