package com.nimsoc.concurrent_collections_examples.handles;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Incrementer implements Runnable {

  private final Account account;

  public Incrementer(Account account) {
    this.account = account;
  }

  @Override
  public void run() {
    try {
      VarHandle handler;
      
      handler = MethodHandles.lookup().in(Account.class).findVarHandle(Account.class, "amount", double.class);
      for (int i = 0; i < 10000; i++) {
        handler.getAndAdd(account, 100);
        account.unsafeAmount += 100;
      }
    } catch (NoSuchFieldException | IllegalAccessException ex) {
      Logger.getLogger(Incrementer.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
