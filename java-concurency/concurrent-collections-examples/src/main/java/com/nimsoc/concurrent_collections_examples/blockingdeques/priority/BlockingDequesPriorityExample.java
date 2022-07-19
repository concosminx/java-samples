package com.nimsoc.concurrent_collections_examples.blockingdeques.priority;

import com.nimsoc.concurrent_collections_examples.Example;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class BlockingDequesPriorityExample implements Example {

  @Override
  public void demo() {

    PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
    Thread taskThreads[] = new Thread[5];

    for (int i = 0; i < taskThreads.length; i++) {
      Task task = new Task(i, queue);
      taskThreads[i] = new Thread(task);
    }

    for (Thread taskThread : taskThreads) {
      taskThread.start();
    }

    for (Thread taskThread : taskThreads) {
      try {
        taskThread.join();
      } catch (InterruptedException ex) {
        Logger.getLogger(BlockingDequesPriorityExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    System.out.printf("BlockingDequesPriorityExample: Queue Size: %d\n", queue.size());
    
    for (int i = 0; i < taskThreads.length * 1000; i++) {
      Event event = queue.poll();
      System.out.printf("Thread %s: Priority %d\n", event.getThread(), event.getPriority());
    }
    System.out.printf("BlockingDequesPriorityExample: Queue Size: %d\n", queue.size());
    System.out.printf("BlockingDequesPriorityExample: End of the program\n");
  }

}
