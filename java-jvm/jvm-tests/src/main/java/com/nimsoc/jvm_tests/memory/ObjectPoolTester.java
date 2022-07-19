package com.nimsoc.jvm_tests.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ObjectPoolTester {

  private static final int EXECUTE_TIMES = 10;
  private static final int MAX_FACTOR = 10;
  private static final int THREAD_COUNT = 100;
  private static final int NOTUSE_OBJECTPOOL = 1;
  private static final int USE_OBJECTPOOL = 2;

  private static final int RUNMODE = USE_OBJECTPOOL;

  private static CountDownLatch latch = null;

  public static void main(String[] args) throws Exception {
    Task task = new Task();
    
    long beginTime = System.currentTimeMillis();
    
    for (int i = 0; i < EXECUTE_TIMES; i++) {
      System.out.println("" + (i + 1));
      latch = new CountDownLatch(THREAD_COUNT);
      for (int j = 0; j < THREAD_COUNT; j++) {
        new Thread(task).start();
      }
      latch.await();
    }
    long endTime = System.currentTimeMillis();
    System.out.println("( " + EXECUTE_TIMES + " ) Thread ( " + THREAD_COUNT + " ) Factor ( " + MAX_FACTOR + " ) Time ( " + (endTime - beginTime) + " ) ms");

  }

  static class Task implements Runnable {

    @Override
    public void run() {
      for (int j = 0; j < MAX_FACTOR; j++) {
        if (RUNMODE == USE_OBJECTPOOL) {
          BigObjectPool.getInstance().getBigObject(j);
        } else {
          new BigObject(j);
        }
      }
      latch.countDown();
    }
  }

  static class BigObjectPool {

    private static final BigObjectPool INSTANCE = new BigObjectPool();
    private final Map<Integer, BigObject> cacheObjects = new HashMap<>();

    private BigObjectPool() {
    }

    public static BigObjectPool getInstance() {
      return INSTANCE;
    }

    public BigObject getBigObject(int factor) {
      if (cacheObjects.containsKey(factor)) {
        return cacheObjects.get(factor);
      } else {
        BigObject object = new BigObject(factor);
        cacheObjects.put(factor, object);
        return object;
      }
    }

  }

  static class BigObject {
    private byte[] bytes = null;

    public BigObject(int factor) {
      bytes = new byte[(factor + 1) * 1024 * 1024];
    }

    public byte[] getBytes() {
      return bytes;
    }
  }
}
