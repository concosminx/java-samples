package com.nimsoc.java_algorithms.dynamic;

import java.util.HashMap;
import java.util.Map;


/*
  In mathematics, the Fibonacci numbers, commonly denoted Fn, form a sequence, called the Fibonacci sequence, such that each number is the sum of the two
  preceding ones, starting from 0 and 1.
*/
public class Fibonacci {

  public int naiveFibonacci(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return naiveFibonacci(n - 1) + naiveFibonacci(n - 2);
  }
  
  private Map<Integer, Integer> memoizeTable;
  
  public Fibonacci() {
    this.memoizeTable = new HashMap<>();
    this.memoizeTable.put(Integer.valueOf(0),Integer.valueOf(0));
    this.memoizeTable.put(Integer.valueOf(1),Integer.valueOf(1));
  }
  
  public int fibonacciDP(int n) {
    if (memoizeTable.containsKey(Integer.valueOf(n))) {
      return memoizeTable.get(Integer.valueOf(n)).intValue();
    }
    memoizeTable.put(n-1, fibonacciDP(n-1));
    memoizeTable.put(n-2, fibonacciDP(n-2));
    
    int result = memoizeTable.get(n-1) + memoizeTable.get(n-2);
    
    memoizeTable.put(n, result);
    
    return result;
  }
}
