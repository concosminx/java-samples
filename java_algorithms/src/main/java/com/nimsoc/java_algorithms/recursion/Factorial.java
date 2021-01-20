package com.nimsoc.java_algorithms.recursion;

public class Factorial {
  public int calculate(int accm, int n) {
    return (n == 0 || n == 1) ? accm : calculate(accm * n, n - 1);
  }
}
