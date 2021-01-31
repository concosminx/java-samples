package com.nimsoc.java_algorithms.dynamic.tests;

import com.nimsoc.java_algorithms.dynamic.SubsetSum;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubsetSumTestNG {

  @Test
  public void testSum() {
    int[] numbers = {5, 2, 3, 1};
    int sum = 9;

    SubsetSum alg = new SubsetSum(numbers, sum);
    alg.solve();
    SubsetSum.Result result = alg.getResult();

    Assert.assertEquals(result.getSolution(), true);
    Assert.assertEquals(result.getElements(), Arrays.asList(1, 3, 5));
  }
}
