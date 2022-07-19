package com.nimsoc.java_algorithms.divide.tests;

import com.nimsoc.java_algorithms.divide.ClosestPairOfPoints;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClosestPairOfPointsTestNG {
  @Test
  public void testExample1() {
    List<ClosestPairOfPoints.Point> points = Arrays.asList(
            new ClosestPairOfPoints.Point(1, 1),
            new ClosestPairOfPoints.Point(1, 2),
            new ClosestPairOfPoints.Point(2, 1),
            new ClosestPairOfPoints.Point(2, 2),
            new ClosestPairOfPoints.Point(2, 3),
            new ClosestPairOfPoints.Point(3, 3)
    );
    ClosestPairOfPoints.Algorithm alg = new ClosestPairOfPoints.Algorithm(points);
    Assert.assertEquals(alg.solve(), 1d);
  }
  
  
  @Test
  public void testExample2() {
    List<ClosestPairOfPoints.Point> points = Arrays.asList(
            new ClosestPairOfPoints.Point(-2, 2),
            new ClosestPairOfPoints.Point(-2, 0),
            new ClosestPairOfPoints.Point(0, 0),
            new ClosestPairOfPoints.Point(1, 1),
            new ClosestPairOfPoints.Point(3, 3),
            new ClosestPairOfPoints.Point(5, 2),
            new ClosestPairOfPoints.Point(4, 0)
    );
    ClosestPairOfPoints.Algorithm alg = new ClosestPairOfPoints.Algorithm(points);
    Assert.assertEquals(alg.solve(), 1.4142135623730951d);
  }
}
