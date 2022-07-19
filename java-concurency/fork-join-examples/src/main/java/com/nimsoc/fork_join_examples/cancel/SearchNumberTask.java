package com.nimsoc.fork_join_examples.cancel;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchNumberTask extends RecursiveTask<Integer> {

  private final int numbers[];

  private final int start;
  private final int end;

  private final int number;

  private final TaskManager manager;

  private final static int NOT_FOUND = -1;

  public SearchNumberTask(int numbers[], int start, int end, int number, TaskManager manager) {
    this.numbers = numbers;
    this.start = start;
    this.end = end;
    this.number = number;
    this.manager = manager;
  }

  @Override
  protected Integer compute() {
    System.out.println("Task: " + start + ":" + end);
    int ret;
    if (end - start > 10) {
      ret = launchTasks();
    } else {
      ret = lookForNumber();
    }
    return ret;
  }

  private int lookForNumber() {
    for (int i = start; i < end; i++) {
      if (numbers[i] == number) {
        System.out.printf("Task: Number %d found in position %d\n", number, i);
        /*cancel the other tasks*/
        manager.cancelTasks(this);
        return i;
      }

      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException ex) {
        Logger.getLogger(SearchNumberTask.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
    return NOT_FOUND;
  }

  private int launchTasks() {
    int mid = (start + end) / 2;

    SearchNumberTask task1 = new SearchNumberTask(numbers, start, mid, number, manager);
    SearchNumberTask task2 = new SearchNumberTask(numbers, mid, end, number, manager);

    manager.addTask(task1);
    manager.addTask(task2);

    task1.fork();
    task2.fork();

    int returnValue;
    returnValue = task1.join();
    if (returnValue != -1) {
      return returnValue;
    }

    returnValue = task2.join();
    return returnValue;
  }

  public void logCancelMessage() {
    System.out.printf("Task: Canceled task from %d to %d\n", start, end);
  }

}
