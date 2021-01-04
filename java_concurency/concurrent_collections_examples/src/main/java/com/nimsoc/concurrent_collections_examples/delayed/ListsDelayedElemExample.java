package com.nimsoc.concurrent_collections_examples.delayed;

import com.nimsoc.concurrent_collections_examples.Example;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class ListsDelayedElemExample implements Example {

  @Override
  public void demo() {
    DelayQueue<Event> queue = new DelayQueue<>();

    Thread threads[] = new Thread[5];

    for (int i = 0; i < threads.length; i++) {
      Task task = new Task(i + 1, queue);
      threads[i] = new Thread(task);
    }

    for (Thread thread : threads) {
      thread.start();
    }

    for (Thread thread : threads) {
      try {
        thread.join();
      }catch (InterruptedException ex) {
        Logger.getLogger(ListsDelayedElemExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    do {
      int counter = 0;
      Event event;
      do {
        event = queue.poll();
        if (event != null) {
          counter++;
        }
      } while (event != null);
      System.out.printf("At %s you have read %d events\n", new Date(), counter);
      try {
        TimeUnit.MILLISECONDS.sleep(500);
      } catch (InterruptedException ex) {
        Logger.getLogger(ListsDelayedElemExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    } while (queue.size() > 0);

  }

}
