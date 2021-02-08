package com.nimsoc.java_algorithms.dynamic.tests;

import com.nimsoc.java_algorithms.dynamic.Fibonacci;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FibonacciTestNG {
  
  @Test
  public void testFib() {
    
    Assert.assertEquals(new Fibonacci().fibonacciDP(0), 0);
    Assert.assertEquals(new Fibonacci().fibonacciDP(1), 1);
    Assert.assertEquals(new Fibonacci().fibonacciDP(6), 8);
    
    Assert.assertEquals(new Fibonacci().fibonacciDP(8), new Fibonacci().naiveFibonacci(8));
    
  }
  
}
