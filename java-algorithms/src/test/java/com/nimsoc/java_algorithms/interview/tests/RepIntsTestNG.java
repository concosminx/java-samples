package com.nimsoc.java_algorithms.interview.tests;

import com.nimsoc.java_algorithms.interview.RepInts;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepIntsTestNG {
  
  @Test
  public void testReps() {
    int[] array = {2, 3, 1, 2, 4, 3};
    RepInts alg = new RepInts();
    alg.solve(array);
    List<Integer> reps = alg.getReps();
    
    Assert.assertEquals(reps.contains(3), true);
    Assert.assertEquals(reps.contains(2), true);
    Assert.assertEquals(reps.contains(1), false);
    Assert.assertEquals(reps.size(), 2);
  }
  
  
}
