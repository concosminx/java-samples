package com.nimsoc.java_algorithms.recursion;

public class EuclideanGCD {
  public int calculate(int a, int b) {
    return b == 0 ? a : calculate(b, a % b);
  }
}
