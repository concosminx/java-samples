package com.nimsoc.java_algorithms.recursion.tests;

import com.nimsoc.java_algorithms.recursion.Hanoi;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HanoiTestNG {
  
  @Test
  public void solveHanoi3Disks() {
    Hanoi alg = new Hanoi();
    alg.solve(3, 'a', 'b', 'c');
    Assert.assertEquals(alg.getMoves(), Arrays.asList("a-c", "a-b", "c-b", "a-c", "b-a", "b-c", "a-c"));
  }
}
