package com.nimsoc.thread_executors_examples.delay;

import com.nimsoc.thread_executors_examples.Example;
import com.nimsoc.thread_executors_examples.Main;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class DelayExample implements Example {

  @Override
  public void demo() {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    System.out.printf("DelayExample -> Starting at: %s\n", new Date());

    /*send the tasks to the executor with +1 second delay*/
    for (int i = 0; i < 5; i++) {
      DTask task = new DTask("Task " + i);
      executor.schedule(task, i + 1, TimeUnit.SECONDS);
    }

    executor.shutdown();

    try {
      /*blocks until all tasks have completed execution*/
      executor.awaitTermination(1, TimeUnit.DAYS);
    } catch (InterruptedException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.printf("DelayExample -> Ends at: %s\n", new Date());
  }

}
