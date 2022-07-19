package com.nimsoc.java_algorithms.backtracking.tests;

import com.nimsoc.java_algorithms.backtracking.Colors;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ColorsTestNG {

  @Test
  public void testColors() {
    int[][] matrix = {
      {0, 1, 0, 1, 0},
      {1, 0, 1, 1, 0},
      {0, 1, 0, 1, 0},
      {1, 1, 1, 0, 0},
      {0, 0, 0, 1, 0},};

    Colors alg = new Colors(3, matrix);
    Colors.Result result = alg.solve();
    
    Assert.assertEquals(result.isSolution(), true);
    Map<Integer, Integer> expected = new HashMap<>();
    expected.put(1, 1);
    expected.put(2, 2);
    expected.put(3, 1);
    expected.put(4, 3);
    expected.put(5, 1);
    
    Assert.assertEquals(result.getNodesAndColors(), expected);
  }
}
