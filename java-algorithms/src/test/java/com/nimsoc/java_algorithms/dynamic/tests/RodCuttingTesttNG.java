package com.nimsoc.java_algorithms.dynamic.tests;

import com.nimsoc.java_algorithms.dynamic.RodCutting;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RodCuttingTesttNG {

  @Test
  public void testCutting() {
    RodCutting alg = new RodCutting(5, new int[]{0, 2, 5, 7, 3});
    alg.solve();
    RodCutting.Result result = alg.getResult();

    Assert.assertEquals(result.getProfit(), 12);
    Assert.assertEquals(result.getCuts(), Arrays.asList(3, 2));
  }
}
