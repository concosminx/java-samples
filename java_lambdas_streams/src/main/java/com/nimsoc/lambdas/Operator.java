package com.nimsoc.lambdas;

public class Operator {
  private interface IOperator {
    String operate(String s1, String s2);
  }
  
  private static void test(String s1, String s2, IOperator op) {
    System.out.println("Result: " + op.operate(s1, s2));
  }
  
  public static void main(String[] args) {
    test("Hello, ", "world!", (s1, s2) -> s1.concat(s2));
    test("All in ", "uppercase", (s1, s2) -> s1.toUpperCase() + s2.toUpperCase());
  }
}
