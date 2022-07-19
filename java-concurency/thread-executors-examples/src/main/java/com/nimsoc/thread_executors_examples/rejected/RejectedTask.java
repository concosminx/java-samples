package com.nimsoc.thread_executors_examples.rejected;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class RejectedTask implements Runnable {

  private final Date initDate;
  private final String name;

  public RejectedTask(String name) {
    initDate = new Date();
    this.name = name;
  }

  @Override
  public void run() {
    System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
    System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());

    Long duration = (long) (Math.random() * 1000);

    System.out.printf("%s: Task %s: Doing a task during %d miliseconds\n", Thread.currentThread().getName(), name, duration);

    try {
      /*work simulation*/
      TimeUnit.MILLISECONDS.sleep(duration);
    } catch (InterruptedException ex) {
      Logger.getLogger(RejectedTask.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), new Date(), name);
  }
}
