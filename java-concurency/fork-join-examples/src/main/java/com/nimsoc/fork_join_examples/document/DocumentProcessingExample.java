package com.nimsoc.fork_join_examples.document;

import com.nimsoc.fork_join_examples.Example;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class DocumentProcessingExample implements Example {

  @Override
  public void demo() {

    DocumentGenerator mock = new DocumentGenerator();
    String[][] document = mock.generateDocument(100, 1000, "strategy");

    DocumentTask task = new DocumentTask(document, 0, 100, "strategy");

    ForkJoinPool commonPool = ForkJoinPool.commonPool();
    commonPool.execute(task);

    /*stats, until the task is done*/
    do {
      line();
      System.out.printf("DocumentProcessingExample: Parallelism: %d\n", commonPool.getParallelism());
      System.out.printf("DocumentProcessingExample: Active Threads: %d\n", commonPool.getActiveThreadCount());
      System.out.printf("DocumentProcessingExample: Task Count: %d\n", commonPool.getQueuedTaskCount());
      System.out.printf("DocumentProcessingExample: Steal Count: %d\n", commonPool.getStealCount());
      line();

      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException ex) {
        Logger.getLogger(DocumentProcessingExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    } while (!task.isDone());

    commonPool.shutdown();

    try {
      /*blocks until all tasks have completed execution after a shutdown request*/
      commonPool.awaitTermination(1, TimeUnit.DAYS);
    } catch (InterruptedException ex) {
      Logger.getLogger(DocumentProcessingExample.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    try {
      System.out.printf("DocumentProcessingExample: The word appears %d in the document", task.get());
    } catch (InterruptedException | ExecutionException ex) {
      Logger.getLogger(DocumentProcessingExample.class.getName()).log(Level.SEVERE, null, ex);
    }
    

  }

}
