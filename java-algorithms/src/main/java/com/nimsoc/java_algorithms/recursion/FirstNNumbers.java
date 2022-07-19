package com.nimsoc.java_algorithms.recursion;

public class FirstNNumbers {
  public int calculate(int n) {
    if (n < 1) throw new IllegalArgumentException();
    
    return n == 1 ? 1 : n + calculate((n - 1));
  }
}
