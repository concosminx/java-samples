package com.nimsoc.fork_join_examples.document;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LineTask extends RecursiveTask<Integer> {

  private final String line[];
  private final int start;
  private final int end;
  private final String word;

  public LineTask(String line[], int start, int end, String word) {
    this.line = line;
    this.start = start;
    this.end = end;
    this.word = word;
  }

  @Override
  protected Integer compute() {
    Integer result = null;
    if (end - start < 100) {
      result = count(line, start, end, word);
    } else {
      int mid = (start + end) / 2;
      LineTask task1 = new LineTask(line, start, mid, word);
      LineTask task2 = new LineTask(line, mid, end, word);
      invokeAll(task1, task2);

      try {
        result = groupResults(task1.get(), task2.get());
      } catch (InterruptedException | ExecutionException ex) {
        Logger.getLogger(LineTask.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return result;
  }

  private Integer count(String[] line, int start, int end, String word) {
    int counter;
    counter = 0;
    for (int i = start; i < end; i++) {
      if (line[i].equals(word)) {
        counter++;
      }
    }
    try {
      TimeUnit.MILLISECONDS.sleep(10);
    } catch (InterruptedException ex) {
      Logger.getLogger(LineTask.class.getName()).log(Level.SEVERE, null, ex);
    }
    return counter;
  }

  private Integer groupResults(Integer number1, Integer number2) {
    Integer result;
    result = number1 + number2;
    return result;
  }

}
