package com.nimsoc.concurrent_collections_examples.nonbdeques;

import com.nimsoc.concurrent_collections_examples.Example;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class NonBlockingDequesExample implements Example {

  @Override
  public void demo() {
    ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
    Thread threads[] = new Thread[100];

    /*create 100 threads*/
    for (int i = 0; i < threads.length; i++) {
      AddTask task = new AddTask(list);
      threads[i] = new Thread(task);
      threads[i].start();
    }

    System.out.printf("NonBlockingDequesExample: %d AddTask threads have been launched\n", threads.length);

    /*waits for this thread to die*/
    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException ex) {
        Logger.getLogger(NonBlockingDequesExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    System.out.printf("NonBlockingDequesExample: Size of the List: %d\n", list.size());

    /* create 100 PollTask objects and execute them as threads */
    for (int i = 0; i < threads.length; i++) {
      PollTask task = new PollTask(list);
      threads[i] = new Thread(task);
      threads[i].start();
    }

    System.out.printf("NonBlockingDequesExample: %d PollTask threads have been launched\n", threads.length);

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException ex) {
        Logger.getLogger(NonBlockingDequesExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    System.out.printf("NonBlockingDequesExample: Size of the List: %d\n", list.size());
  }

}
