package com.nimsoc.fork_join_examples.exception;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task extends RecursiveTask<Integer> {

  private final int array[];

  private final int start;
  private final int end;

  public Task(int array[], int start, int end) {
    this.array = array;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Integer compute() {
    System.out.printf("Task: Start from %d to %d\n", start, end);

    if (end - start < 10) {
      if ((3 > start) && (3 < end)) {
        throw new RuntimeException("This task throws an Exception: Task from  " + start + " to " + end);
      }

      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException ex) {
        Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
      }
      
    } else {
      int mid = (end + start) / 2;
      Task task1 = new Task(array, start, mid);
      Task task2 = new Task(array, mid, end);
      invokeAll(task1, task2);
      System.out.printf("Task: Result form %d to %d: %d\n", start, mid, task1.join());
      System.out.printf("Task: Result form %d to %d: %d\n", mid, end, task2.join());
    }
    System.out.printf("Task: End form %d to %d\n", start, end);
    return 0;
  }

}
