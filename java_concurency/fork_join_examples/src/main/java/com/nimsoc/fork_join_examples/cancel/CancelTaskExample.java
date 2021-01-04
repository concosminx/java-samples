package com.nimsoc.fork_join_examples.cancel;

import com.nimsoc.fork_join_examples.Example;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class CancelTaskExample implements Example {

  @Override
  public void demo() {

    /*generate 1000 ints*/
    ArrayGenerator generator = new ArrayGenerator();
    int array[] = generator.generateArray(1000);

    TaskManager manager = new TaskManager();

    ForkJoinPool pool = new ForkJoinPool();
    SearchNumberTask task = new SearchNumberTask(array, /*start*/0, /*end*/1000, /*number*/5, manager);

    pool.execute(task);
    pool.shutdown();

    try {
      pool.awaitTermination(1, TimeUnit.DAYS);
    } catch (InterruptedException ex) {
      Logger.getLogger(CancelTaskExample.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    System.out.printf("CancelTaskExample: The program has finished\n");

  }

}
