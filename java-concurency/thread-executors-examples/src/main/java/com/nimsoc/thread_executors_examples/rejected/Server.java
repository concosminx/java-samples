package com.nimsoc.thread_executors_examples.rejected;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

  private final ThreadPoolExecutor executor;

  public Server() {
    /*1 thread / processor*/
    executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    executor.setRejectedExecutionHandler(new RejectedTaskController());
  }

  public void executeTask(RejectedTask task) {
    System.out.printf("Server: A new task has arrived\n");
    /* 
      Executes the given task sometime in the future. If the task cannot be submitted for execution, either because this 
      executor has been shutdown or because its capacity has been reached, the task is handled by the current RejectedExecutionHandler
    */
    executor.execute(task);
    System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
    System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
    System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
    System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
  }

  public void endServer() {
    executor.shutdown();
  }

}
