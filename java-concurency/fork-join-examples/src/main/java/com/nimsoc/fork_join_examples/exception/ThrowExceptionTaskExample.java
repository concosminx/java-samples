package com.nimsoc.fork_join_examples.exception;

import com.nimsoc.fork_join_examples.Example;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class ThrowExceptionTaskExample implements Example {

  @Override
  public void demo() {
    int array[] = new int[100];

    Task task = new Task(array, 0, 100);
    ForkJoinPool pool = new ForkJoinPool();
    pool.execute(task);
    
    pool.shutdown();

    try {
      pool.awaitTermination(1, TimeUnit.DAYS);
    } catch (InterruptedException ex) {
      Logger.getLogger(ThrowExceptionTaskExample.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    if (task.isCompletedAbnormally()) {
      System.out.printf("CancelTaskExample: An exception has ocurred\n");
      System.out.printf("CancelTaskExample: %s\n", task.getException());
    }

    System.out.printf("CancelTaskExample: Result: %d", task.join());
  }

}
