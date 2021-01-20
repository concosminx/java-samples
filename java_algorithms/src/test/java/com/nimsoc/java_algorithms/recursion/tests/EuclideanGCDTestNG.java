package com.nimsoc.java_algorithms.recursion.tests;

import com.nimsoc.java_algorithms.recursion.EuclideanGCD;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EuclideanGCDTestNG {
  
  @Test
  public void testGCM() {
    EuclideanGCD alg = new EuclideanGCD();
    
    Assert.assertEquals(1, alg.calculate(5, 7));
    Assert.assertEquals(5, alg.calculate(15, 20));
    
  }
}
