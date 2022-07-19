package com.nimsoc.java_algorithms.recursion.tests;

import com.nimsoc.java_algorithms.recursion.FirstNNumbers;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstNNumbersTestNG {

  @Test()
  @Parameters({"nmb"})
  public void testRecursiveSum(int n) {
    FirstNNumbers alg = new FirstNNumbers();
    
    Assert.assertEquals(1, alg.calculate(1));
    Assert.assertEquals(15, alg.calculate(5));
    
    Assert.assertEquals((n * (n+1)) / 2, alg.calculate(n));
  }
  
  @Test(expectedExceptions = {IllegalArgumentException.class})
  public void testRecursiveSumExc() {
    int s = new FirstNNumbers().calculate(0);
  }
}
