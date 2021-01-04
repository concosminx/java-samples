package com.nimsoc.concurrent_collections_examples.vol;

import java.util.Date;

public class VolatileTask implements Runnable {
  private final VolatileFlag flag;

  public VolatileTask(VolatileFlag flag) {
    this.flag = flag;
  }

  @Override
  public void run() {
    int i = 0;
    while (flag.flag) {
      i++;
    }
    System.out.printf("Task: %d - %s\n", i, new Date());
  }

}
