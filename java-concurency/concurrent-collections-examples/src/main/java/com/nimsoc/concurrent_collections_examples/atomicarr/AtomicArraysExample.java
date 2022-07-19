package com.nimsoc.concurrent_collections_examples.atomicarr;

import com.nimsoc.concurrent_collections_examples.Example;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class AtomicArraysExample implements Example {

  @Override
  public void demo() {

    final int NO_OF_THREADS = 100;
    AtomicIntegerArray vector = new AtomicIntegerArray(1000);

    Incrementer incrementer = new Incrementer(vector);
    Decrementer decrementer = new Decrementer(vector);

    Thread threadIncrementer[] = new Thread[NO_OF_THREADS];
    Thread threadDecrementer[] = new Thread[NO_OF_THREADS];

    for (int i = 0; i < NO_OF_THREADS; i++) {
      threadIncrementer[i] = new Thread(incrementer);
      threadDecrementer[i] = new Thread(decrementer);

      threadIncrementer[i].start();
      threadDecrementer[i].start();
    }

    for (int i = 0; i < NO_OF_THREADS; i++) {
      try {
        threadIncrementer[i].join();
        threadDecrementer[i].join();
      } catch (InterruptedException ex) {
        Logger.getLogger(AtomicArraysExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    int errors = 0;
    for (int i = 0; i < vector.length(); i++) {
      if (vector.get(i) != 0) {
        System.out.println("Vector[" + i + "] : " + vector.get(i));
        errors++;
      }
    }

    if (errors == 0) {
      System.out.printf("No errors found\n");
    }

    System.out.println("AtomicArraysExample: End of the example");
  }

}
