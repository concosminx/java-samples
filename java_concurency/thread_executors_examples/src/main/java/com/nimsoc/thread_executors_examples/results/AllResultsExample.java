package com.nimsoc.thread_executors_examples.results;

import com.nimsoc.thread_executors_examples.Example;
import com.nimsoc.thread_executors_examples.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class AllResultsExample implements Example {

  @Override
  public void demo() {
    ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();

    List<ImTask> taskList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      ImTask task = new ImTask("Task-" + i);
      taskList.add(task);
    }

    List<Future<ImResult>> resultList = null;
    try {
      resultList = executor.invokeAll(taskList);
    } catch (InterruptedException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    executor.shutdown();

    System.out.printf("AllResultsExample -> Printing the results\n");
    for (int i = 0; i < resultList.size(); i++) {
      Future<ImResult> future = resultList.get(i);
      try {
        ImResult result = future.get();
        System.out.printf("%s: %s\n", result.getName(), result.getValue());
      } catch (InterruptedException | ExecutionException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
  }
  
}
