package com.nimsoc.fork_join_examples.productprice;

import com.nimsoc.fork_join_examples.Example;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 *
 * @author Cosminx
 */
public class ProductPriceUpdateExample implements Example {

  @Override
  public void demo() {
    /*generates a list o products*/
    ProductListGenerator generator = new ProductListGenerator();
    List<Product> products = generator.generate(10000);
    
    /*create and launch the task*/
    PriceUpdateTask task = new PriceUpdateTask(products, 0, products.size(), 0.30);
    ForkJoinPool pool = new ForkJoinPool();
    pool.execute(task);

    /* pool info */
    do {
      line();
      System.out.printf("ProductPriceUpdateExample: Parallelism: %d\n", pool.getParallelism());
      System.out.printf("ProductPriceUpdateExample: Active Threads: %d\n", pool.getActiveThreadCount());
      System.out.printf("ProductPriceUpdateExample: Task Count: %d\n", pool.getQueuedTaskCount());
      System.out.printf("ProductPriceUpdateExample: Steal Count: %d\n", pool.getStealCount());
      line();

      try {
        TimeUnit.MILLISECONDS.sleep(5);
      } catch (InterruptedException ex) {
        java.util.logging.Logger.getLogger(ProductPriceUpdateExample.class.getName()).log(Level.SEVERE, null, ex);
      }
      /*while this price update task is not completed*/
    } while (!task.isDone());

    pool.shutdown();

    /*check task completion*/
    if (task.isCompletedNormally()) {
      System.out.printf("ProductPriceUpdateExample: The process has completed normally.\n");
    }

    /*check the price*/
    for (int i = 0; i < products.size(); i++) {
      Product product = products.get(i);
      if (product.getPrice() != 13) {
        System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
      }
    }

    System.out.printf("ProductPriceUpdateExample: End of the Program.\n");
  }

}
