package com.nimsoc.fork_join_examples.productprice;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class PriceUpdateTask extends RecursiveAction {

  private final List<Product> products;

  private final int first;
  private final int last;

  private final double increment;

  public PriceUpdateTask(List<Product> products, int first, int last, double increment) {
    this.products = products;
    this.first = first;
    this.last = last;
    this.increment = increment;
  }

  @Override
  protected void compute() {
    if (last - first < 10) {
      /*less than 10 items --> update the prices*/
      updatePrices();
    } else {
      int middle = (last + first) / 2;
      /* the number of tasks that have been forked by the current worker thread but not yet executed */
      System.out.printf("PriceUpdateTask: Pending tasks: %s\n", getQueuedTaskCount()); 
      PriceUpdateTask t1 = new PriceUpdateTask(products, first, middle + 1, increment);
      PriceUpdateTask t2 = new PriceUpdateTask(products, middle + 1, last, increment);
      /*forks t1 and t2*/
      invokeAll(t1, t2);
    }
  }

  /*dummy update prices*/
  private void updatePrices() {
    for (int i = first; i < last; i++) {
      Product product = products.get(i);
      product.setPrice(product.getPrice() * (1 + increment));
    }
  }

}
