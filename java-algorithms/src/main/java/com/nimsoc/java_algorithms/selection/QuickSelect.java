package com.nimsoc.java_algorithms.selection;

public class QuickSelect {

  private int[] arr;

  public QuickSelect(int[] arr) {
    this.arr = arr;
  }

  public int select(int k) {
    return select(0, arr.length - 1, k - 1);
  }

  private int select(int start, int end, int k) {
    int pivot = partition(start, end);
    if (pivot > k) {
      return select(start, pivot - 1, k);
    } else if (pivot < k) {
      return select(pivot + 1, end, k);
    }
    return arr[k];
  }

  private void swap(int i, int j) {
    int aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
  }

  private int partition(int start, int end) {
    int pivot = new java.util.Random().nextInt(end - start + 1) + start;

    swap(end, pivot);

    for (int i = start; i < end; i++) {
      if (arr[i] > arr[end]) {
        swap(i, start);
        start++;
      }

    }
    swap(start, end);
    return start;
  }

}
