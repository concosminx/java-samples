package com.nimsoc.fork_join_examples.folder;

import com.nimsoc.fork_join_examples.Example;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class FolderScanExample implements Example {

  @Override
  public void demo() {

    ForkJoinPool pool = new ForkJoinPool();

    FolderProcessor system = new FolderProcessor("C:\\Windows", "txt");
    FolderProcessor apps = new FolderProcessor("C:\\Program Files", "txt");
    FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings", "txt");

    pool.execute(system);
    pool.execute(apps);
    pool.execute(documents);

    /*stats*/
    do {
      line();
      System.out.printf("FolderScanExample: Parallelism: %d\n", pool.getParallelism());
      System.out.printf("FolderScanExample: Active Threads: %d\n", pool.getActiveThreadCount());
      System.out.printf("FolderScanExample: Task Count: %d\n", pool.getQueuedTaskCount());
      System.out.printf("FolderScanExample: Steal Count: %d\n", pool.getStealCount());
      System.out.printf("FolderScanExample: %b - %b - %b\n", system.isDone(), apps.isDone(), documents.isDone());
      System.out.printf("FolderScanExample: %d - %d - %d\n", system.getPendingCount(), apps.getPendingCount(), documents.getPendingCount());
      line();
      
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException ex) {
        Logger.getLogger(FolderScanExample.class.getName()).log(Level.SEVERE, null, ex);
      }
      
    } while ((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));

    pool.shutdown();

    List<String> results;

    results = system.getResultList();
    System.out.printf("System: %d files found.\n", results.size());

    results = apps.getResultList();
    System.out.printf("Apps: %d files found.\n", results.size());

    results = documents.getResultList();
    System.out.printf("Documents: %d files found.\n", results.size());
  }

}
