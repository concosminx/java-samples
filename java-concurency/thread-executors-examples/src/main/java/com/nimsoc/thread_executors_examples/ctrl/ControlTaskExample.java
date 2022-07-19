package com.nimsoc.thread_executors_examples.ctrl;

import com.nimsoc.thread_executors_examples.Example;
import com.nimsoc.thread_executors_examples.Main;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class ControlTaskExample implements Example {

  @Override
  public void demo() {
    ExecutorService executor = Executors.newCachedThreadPool();

    ResultTask resultTasks[] = new ResultTask[5];

    for (int i = 0; i < 5; i++) {
      ExecutableTask executableTask = new ExecutableTask("Task " + i);
      resultTasks[i] = new ResultTask(executableTask);
      executor.submit(resultTasks[i]);
    }

    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    for (ResultTask resultTask : resultTasks) {
      resultTask.cancel(true);
    }

    for (ResultTask resultTask : resultTasks) {
      try {
        if (!resultTask.isCancelled()) {
          System.out.printf("%s\n", resultTask.get());
        }
      } catch (InterruptedException | ExecutionException e) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
      }
    }

    executor.shutdown();
  }

}
