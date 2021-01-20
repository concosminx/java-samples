package com.nimsoc.java_algorithms.recursion.tests;

import com.nimsoc.java_algorithms.recursion.Hanoi;
import org.testng.annotations.Test;

public class HanoiTestNG {
  
  @Test
  public void solveHanoi() {
    Hanoi alg = new Hanoi();
    alg.solve(3, 'a', 'b', 'c');
  }
}
