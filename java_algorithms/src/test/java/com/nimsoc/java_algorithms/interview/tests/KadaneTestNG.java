
package com.nimsoc.java_algorithms.interview.tests;

import com.nimsoc.java_algorithms.interview.Kadane;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KadaneTestNG {
  
  
  @Test 
  public void testPosNeg() {
    Assert.assertEquals(Kadane.solve(new int[] {1, -2, 3, 4, -5, 8}), 10);
  }
  
  @Test 
  public void testNeg() {
    Assert.assertEquals(Kadane.solve(new int[] {-10, -8, -3, -7, -2, -7, -3, -9}), -2);
  }
}
