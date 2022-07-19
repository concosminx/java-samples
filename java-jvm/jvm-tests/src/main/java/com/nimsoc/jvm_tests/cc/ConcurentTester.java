package com.nimsoc.jvm_tests.cc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcurentTester {

  private final int executeTimes = 10;
  private final int threadCount = Runtime.getRuntime().availableProcessors() * 100;
  private CountDownLatch latch = null;

  public void runTest() throws InterruptedException {
    TaskHandler task = new TaskHandler();
    long beginTime = System.currentTimeMillis();
    
    for (int i = 0; i < executeTimes; i++) {
      Logger.getLogger(ConcurentTester.class.getName()).log(Level.INFO, "Round: {0}", new Object[] {(i + 1)});
      latch = new CountDownLatch((threadCount));
      for (int j = 0; j < threadCount; j++) {
        new Thread(task).start();
      }
      latch.await();
    }

    long endTime = System.currentTimeMillis();
    
    Logger.getLogger(ConcurentTester.class.getName()).log(Level.INFO, "Execute summary: Round( {0} ) Thread Per Round( {1} ) Execute Time ( {2} ) ms", new Object[]{executeTimes, threadCount, endTime - beginTime});
    
  }

  class TaskHandler implements Runnable {
    private final Random random = new Random();
    @Override
    public void run() {
      Handler1.getInstance().handle(random.nextInt(10000));
      latch.countDown();
    }
  }

  static class Handler1 {

    private static final Handler1 INSTANCE = new Handler1();
    private final Random random = new Random();
    private final Lock lock = new ReentrantLock();

    private Handler1() {
    }

    public static Handler1 getInstance() {
      return INSTANCE;
    }

    public void handle(int id) {
      try {
        lock.lock();
        //do something here
        try {
          Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ex) {
          Logger.getLogger(ConcurentTester.class.getName()).log(Level.SEVERE, null, ex);
        }
      } finally {
        lock.unlock();
      }

    }
  }

  public static void main(String[] args) throws InterruptedException {
    new ConcurentTester().runTest();
  }
}
