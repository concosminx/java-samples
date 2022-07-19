package com.nimsoc.java_algorithms.backtracking.tests;

import com.nimsoc.java_algorithms.backtracking.NQuens;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NQueensTestNG {

  @Test
  public void testQueensOk() {

    NQuens alg = new NQuens(4);
    NQuens.Result result = alg.solve();

    Assert.assertTrue(result.isSolution());

    Assert.assertEquals(result.getMatrix()[0], new char[] {'-','-','*','-',});
    Assert.assertEquals(result.getMatrix()[3], new char[] {'-','*','-','-',});
    
    /*
    -   -  *  -
     *  -  -  -
    -   -  -  *
    -   *  -  -
     */
  }
  
  
  @Test
  public void testQueensNotOk() {

    NQuens alg = new NQuens(3);
    NQuens.Result result = alg.solve();

    Assert.assertTrue(!result.isSolution());

  }
}
