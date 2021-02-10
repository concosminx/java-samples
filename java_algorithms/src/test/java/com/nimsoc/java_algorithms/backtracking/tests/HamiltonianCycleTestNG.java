package com.nimsoc.java_algorithms.backtracking.tests;

import com.nimsoc.java_algorithms.backtracking.HamiltonianCycle;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HamiltonianCycleTestNG {

  @Test
  public void testCycle() {

    int[][] matrix = {
      {0, 1, 1, 1, 0, 0},
      {1, 0, 1, 0, 1, 0},
      {1, 1, 1, 1, 0, 1},
      {1, 0, 1, 0, 0, 1},
      {0, 1, 0, 0, 0, 1},
      {0, 1, 1, 1, 1, 1}
    };

    HamiltonianCycle alg = new HamiltonianCycle(matrix);
    HamiltonianCycle.Result result = alg.solve();

    Assert.assertEquals(result.isSolution(), true);

    Assert.assertEquals(result.getCycle(), Arrays.asList(0,1,4,5,2,3,0));

  }
}
