package com.nimsoc.java_algorithms.dynamic.tests;

import com.nimsoc.java_algorithms.dynamic.CoinChange;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoinChangeTestNG {
  
  @Test 
  public void testNaiveApproach() {
    CoinChange alg = new CoinChange();
    Assert.assertEquals(alg.naiveCoinChange(4, new int[] {1,2,3}, 0), 4);
  }
  
  
  @Test 
  public void testDPApproach() {
    CoinChange alg = new CoinChange();
    Assert.assertEquals(alg.dpCoinChange(new int[] {1,2,3}, 4), 4);
  }
  
}
