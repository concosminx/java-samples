package com.nimsoc.java_algorithms.recursion.tests;

import com.nimsoc.java_algorithms.recursion.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FactorialTestNG {
  
  @Test
  public void testFactorial() {
    Factorial alg = new Factorial();
    
    Assert.assertEquals(1, alg.calculate(1, 0));
    Assert.assertEquals(1, alg.calculate(1, 1));
    Assert.assertEquals(720, alg.calculate(1, 6));
  }
}
