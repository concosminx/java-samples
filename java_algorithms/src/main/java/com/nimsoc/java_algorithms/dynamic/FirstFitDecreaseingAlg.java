package com.nimsoc.java_algorithms.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
   Given n items of different weights and bins each of capacity c, assign each item to a bin such that number of total used bins is minimized.
   It may be assumed that all items have weights smaller than bin capacity.
 */
public class FirstFitDecreaseingAlg {

  private final List<Bin> bins = new ArrayList<>();
  private final List<Integer> items;
  private final int binCapacity;
  private int binCounter;

  public FirstFitDecreaseingAlg(List<Integer> items, int binCapacity) {
    this.binCounter = 1;
    this.items = items;
    this.binCapacity = binCapacity;
  }

  public void solve() {
    Collections.sort(items, Collections.reverseOrder());

    if (this.items.get(0) > this.binCapacity) {
      return;
    }

    this.bins.add(new Bin(binCapacity, binCounter));

    items.forEach((currentItem) -> {
      boolean isOk = false;

      int currentBin = 0;

      while (!isOk) {
        if (currentBin == this.bins.size()) {
          Bin newBin = new Bin(binCapacity, ++binCounter);
          newBin.put(currentItem);
          this.bins.add(newBin);
          isOk = true;
        } else if (this.bins.get(currentBin).put(currentItem)) {
          isOk = true;
        } else {
          currentBin++;
        }
      }
    });
  }

  public List<Bin> getBins() {
    return Collections.unmodifiableList(bins);
  }

}

class Bin {

  private final int id;
  private final int capacity;
  private int currentSize;
  private final List<Integer> items;

  public Bin(int capacity, int id) {
    this.id = id;
    this.capacity = capacity;
    this.items = new ArrayList<>();
  }

  public boolean put(Integer item) {
    if (this.currentSize + item > this.capacity) {
      return false;
    }
    this.items.add(item);
    this.currentSize += item;

    return true;
  }

  /*
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Items in bin #").append(this.id).append(": ");
    this.items.forEach((item) -> {
      sb.append(item).append(" ");
    });
    return sb.toString();
  }
  */

}
