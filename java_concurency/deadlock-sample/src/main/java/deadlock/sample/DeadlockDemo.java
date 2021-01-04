package deadlock.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeadlockDemo {

  private static final int NUM_ACCOUNTS = 10;
  private static final int NUM_THREADS = 20;
  private static final int NUM_ITERATIONS = 100000;
  private static final int MAX_COLUMNS = 60;

  static final Random rnd = new Random();
  List<Account> accounts = new ArrayList<>();

  public static void main(String args[]) {
    DeadlockDemo demo = new DeadlockDemo();
    demo.setUp();
    demo.run();
  }

  void setUp() {
    for (int i = 0; i < NUM_ACCOUNTS; i++) {
      Account account = new Account(i, rnd.nextInt(1000));
      accounts.add(account);
    }
  }

  void run() {
    for (int i = 0; i < NUM_THREADS; i++) {
      new BadTransferOperation(i).start();
    }
  }

  class BadTransferOperation extends Thread {
    int threadNum;
    BadTransferOperation(int threadNum) {
      this.threadNum = threadNum;
    }

    @Override
    public void run() {
      for (int i = 0; i < NUM_ITERATIONS; i++) {
        Account toAccount = accounts.get(rnd.nextInt(NUM_ACCOUNTS));
        Account fromAccount = accounts.get(rnd.nextInt(NUM_ACCOUNTS));
        int amount = rnd.nextInt(1000);
        if (!toAccount.equals(fromAccount)) {
          try {
            transfer(fromAccount, toAccount, amount);
            System.out.print(".");
          } catch (OverdrawnException e) {
            System.out.print("-");
          }

          printNewLine(i);
        }
      }
      // This will never get to here...
      System.out.println("Thread Complete: " + threadNum);
    }

    private void printNewLine(int columnNumber) {
      if (columnNumber % MAX_COLUMNS == 0) {
        System.out.print("\n");
      }
    }

    /*Deadlock here !!!!*/
    /**
     * The clue to spotting deadlocks is in the nested locking - synchronized
     * keywords. Note that the locks DON'T have to be next to each other to be
     * nested.
     */
    /*private void transfer(Account fromAccount, Account toAccount, int transferAmount) throws OverdrawnException {
      synchronized (fromAccount) {
        synchronized (toAccount) {
          fromAccount.withdraw(transferAmount);
          toAccount.deposit(transferAmount);
        }
      }
    }*/

    /*No Deadlock here !!!!*/
    /**
     * This is the crucial point here. The idea is that to avoid deadlock you
     * need to ensure that threads can't try to lock the same two accounts in
     * the same order
     */
    private void transfer(Account fromAccount, Account toAccount, int transferAmount) throws OverdrawnException {
      if (fromAccount.getNumber() > toAccount.getNumber()) {
        synchronized (fromAccount) {
          synchronized (toAccount) {
            fromAccount.withdraw(transferAmount);
            toAccount.deposit(transferAmount);
          }
        }
      } else {
        synchronized (toAccount) {
          synchronized (fromAccount) {
            fromAccount.withdraw(transferAmount);
            toAccount.deposit(transferAmount);
          }
        }
      }
    }

  }
}
