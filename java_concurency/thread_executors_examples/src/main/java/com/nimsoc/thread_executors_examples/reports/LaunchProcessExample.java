package com.nimsoc.thread_executors_examples.reports;

import com.nimsoc.thread_executors_examples.Example;
import com.nimsoc.thread_executors_examples.Main;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class LaunchProcessExample implements Example {

  @Override
  public void demo() {
    ExecutorService executor = Executors.newCachedThreadPool();

    CompletionService<String> service = new ExecutorCompletionService<>(executor);

    ReportRequest faceRequest = new ReportRequest("Face", service);
    ReportRequest onlineRequest = new ReportRequest("Online", service);
    Thread faceThread = new Thread(faceRequest);
    Thread onlineThread = new Thread(onlineRequest);

    ReportProcessor processor = new ReportProcessor(service);
    Thread senderThread = new Thread(processor);

    System.out.printf("LaunchProcessExample -> Starting the Threads\n");
    faceThread.start();
    onlineThread.start();
    senderThread.start();

    System.out.printf("LaunchProcessExample -> Waiting for the report generators.\n");
    try {
      faceThread.join();
      onlineThread.join();
    } catch (InterruptedException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.printf("LaunchProcessExample -> Shuting down the executor.\n");
    executor.shutdown();
    try {
      executor.awaitTermination(1, TimeUnit.DAYS);
    } catch (InterruptedException e) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
    }

    processor.stopProcessing();
    System.out.printf("LaunchProcessExample -> Ends");
  }

}
