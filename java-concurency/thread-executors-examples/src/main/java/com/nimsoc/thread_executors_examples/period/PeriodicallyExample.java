/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nimsoc.thread_executors_examples.period;

import com.nimsoc.thread_executors_examples.Example;
import com.nimsoc.thread_executors_examples.Main;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class PeriodicallyExample implements Example {

  @Override
  public void demo() {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    System.out.printf("PeriodicallyExample-> Starting at: %s\n", new Date());

    PTask task = new PTask("Task");
    ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, /*initial delay*/ 1, /*period*/ 2, TimeUnit.SECONDS);

    for (int i = 0; i < 10; i++) {
      System.out.printf("PeriodicallyExample-> Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
      /*remaining delay associated with this object*/
      try {
        TimeUnit.MILLISECONDS.sleep(500);
      } catch (InterruptedException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    executor.shutdown();

    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.printf("PeriodicallyExample-> Finished at: %s\n", new Date());
  }
  
}
