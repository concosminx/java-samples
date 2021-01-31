package com.nimsoc.java_algorithms.dynamic.tests;

import com.nimsoc.java_algorithms.dynamic.FirstFitDecreaseingAlg;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstFitDecreaseingAlgTestNG {

  @Test
  public void testBins() {
    FirstFitDecreaseingAlg alg = new FirstFitDecreaseingAlg(Arrays.asList(10, 5, 2, 4, 1), 10);
    alg.solve();
    Assert.assertEquals(alg.getBins().size(), 3);
  }
}
