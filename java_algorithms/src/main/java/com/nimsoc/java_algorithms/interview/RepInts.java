package com.nimsoc.java_algorithms.interview;

import java.util.ArrayList;
import java.util.List;

/*
   The problem is that we want to find duplicates in a one-dimensional array of integers where the integer values are  smaller than the length of the array.
*/

public class RepInts {
  
  private final List<Integer> reps = new ArrayList<>();

  public void solve(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[Math.abs(array[i])] > 0) {
        array[Math.abs(array[i])] = -array[Math.abs(array[i])];
      } else {
        reps.add(Integer.valueOf(Math.abs(array[i])));
      }
    }
  }

  public List<Integer> getReps() {
    return reps;
  }

}
