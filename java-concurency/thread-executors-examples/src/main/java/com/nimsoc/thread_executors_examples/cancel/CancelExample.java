package com.nimsoc.thread_executors_examples.cancel;

import com.nimsoc.thread_executors_examples.Example;
import com.nimsoc.thread_executors_examples.Main;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class CancelExample implements Example {

  @Override
  public void demo() {
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    CTask task = new CTask();

    System.out.printf("CancelExample -> Executing the task\n");
    Future<String> result = executor.submit(task);

    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.printf("CancelExample ->  Cancelling the task\n");
    result.cancel(true);

    System.out.printf("CancelExample ->  Cancelled: %s\n", result.isCancelled());
    System.out.printf("CancelExample ->  Done: %s\n", result.isDone());

    executor.shutdown();
    System.out.printf("CancelExample ->  The executor has finished\n");
  }

}
