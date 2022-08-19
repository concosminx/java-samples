package com.nimsoc.concurrent_collections_examples.atomicvars;

import com.nimsoc.concurrent_collections_examples.Example;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class AtomicVarsExample implements Example {

  public static void main(String[] args) {
    new AtomicVarsExample().demo();
  }

  @Override
  public void demo() {

    Account account = new Account();
    account.setBalance(1000);

    Company company = new Company(account);
    Thread companyThread = new Thread(company);

    Bank bank = new Bank(account);
    Thread bankThread = new Thread(bank);

    System.out.printf("Account : Initial Balance: %d\n", account.getBalance());

    companyThread.start();
    bankThread.start();

    try {
      companyThread.join();
      bankThread.join();
      
      System.out.printf("Account : Final Balance: %d\n", account.getBalance());
      System.out.printf("Account : Number of Operations: %d\n", account.getOperations());
      System.out.printf("Account : Accumulated commisions: %f\n", account.getCommission());
      
    } catch (InterruptedException ex) {
      Logger.getLogger(AtomicVarsExample.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
