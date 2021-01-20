package com.nimsoc.java_algorithms.recursion;

public class BinarySearch {

  private int[] arr;

  public BinarySearch(int[] arr) {
    this.arr = arr;
  }

  public int search(int startIndex, int endIndex, int item) {
    if (endIndex < startIndex) {
      return -1;
    } else {
      int newIndex = (startIndex + endIndex) / 2;
      if (item == arr[newIndex]) {
        return newIndex;
      } else if (item < arr[newIndex]) {
        return search(startIndex, newIndex - 1, item);
      } else {
        return search(newIndex + 1, endIndex, item);
      }
    }
  }

}
