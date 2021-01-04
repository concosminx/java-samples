package com.nimsoc.concurrent_collections_examples.handles;

import com.nimsoc.concurrent_collections_examples.Example;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class VariableHandlesExample implements Example {

  @Override
  public void demo() {
    Account account = new Account();

    Thread threadIncrementer = new Thread(new Incrementer(account));
    Thread threadDecrementer = new Thread(new Decrementer(account));

    threadIncrementer.start();
    threadDecrementer.start();

    try {
      threadIncrementer.join();
      threadDecrementer.join();
    } catch (InterruptedException ex) {
      Logger.getLogger(VariableHandlesExample.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.printf("Safe amount: %f\n", account.amount);
    System.out.printf("Unsafe amount: %f\n", account.unsafeAmount);
  }

}
