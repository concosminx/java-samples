package com.nimsoc.thread_executors_examples.factorial;

import com.nimsoc.thread_executors_examples.Example;
import com.nimsoc.thread_executors_examples.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
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
public class ReturningResultExample implements Example {

  @Override
  public void demo() {
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    List<Future<Integer>> resultList = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < 10; i++) {
      Integer number = random.nextInt(10);
      FactorialCalc calculator = new FactorialCalc(number);
      Future<Integer> result = executor.submit(calculator);
      resultList.add(result);
    }

    /*display result status; check tasks every 50 miliseconds*/
    do {
      System.out.printf("ReturningResultExample -> Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());
      for (int i = 0; i < resultList.size(); i++) {
        Future<Integer> result = resultList.get(i);
        System.out.printf("ReturningResultExample -> Task %d: %s\n", i, result.isDone());
      }
      try {
        TimeUnit.MILLISECONDS.sleep(50);
      } catch (InterruptedException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
    } while (executor.getCompletedTaskCount() < resultList.size());

    /* display results */
    System.out.printf("ReturningResultExample -> Results\n");
    for (int i = 0; i < resultList.size(); i++) {
      Future<Integer> result = resultList.get(i);
      Integer number = null;
      try {
        number = result.get();
      } catch (InterruptedException | ExecutionException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.printf("ReturningResultExample -> : Task %d: %d\n", i, number);
    }
    executor.shutdown();
  }

}
