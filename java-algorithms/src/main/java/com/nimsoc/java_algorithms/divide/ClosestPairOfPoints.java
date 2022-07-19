package com.nimsoc.java_algorithms.divide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
  The closest pair of points problem or closest pair problem is a problem of computational geometry: given n points in metric space, find a pair
  of points with the smallest distance between them. The closest pair problem for points in the Euclidean plane[1] 
  was among the first geometric problems that were treated at the origins of the systematic study of the computational complexity of 
  geometric algorithms. 
 */
public class ClosestPairOfPoints {

  public static class Algorithm {
    private final List<Point> points;
    
    public Algorithm(List<Point> points) {
      this.points = points;
    }

    public double solve() {
      List<Point> sortedXPoints = new ArrayList<>();
      List<Point> yPoints = new ArrayList<>();
      
      sortedXPoints.addAll(points);
      yPoints.addAll(points);
      
      Collections.sort(sortedXPoints, (o1, o2) -> Double.compare(o1.getX(), o2.getX()));
      
      return findClosestPoints(sortedXPoints, yPoints, sortedXPoints.size());
    }

    private double findClosestPoints(List<Point> pointsSortedX, List<Point> pointsY, int numOfPoints) {
      if (numOfPoints <= 3) {
        return bruteForceApproach(pointsSortedX);
      }
      int middleIndex = numOfPoints / 2;

      Point middlePoint = pointsSortedX.get(middleIndex);

      List<Point> leftSubPointsY = new ArrayList<>();
      List<Point> leftSubPointsSortedX = new ArrayList<>();
      List<Point> rightSubPointsY = new ArrayList<>();
      List<Point> rightSubPointsSortedX = new ArrayList<>();
      
      for (int index = 0; index < numOfPoints; index++) {
        if (pointsY.get(index).getX() <= middlePoint.getX()) {
          leftSubPointsY.add(pointsY.get(index));
          leftSubPointsSortedX.add(pointsSortedX.get(index));
        } else {
          rightSubPointsY.add(pointsY.get(index));
          rightSubPointsSortedX.add(pointsSortedX.get(index));
        }
      }
      
      double sigmaLeft = findClosestPoints(leftSubPointsSortedX, leftSubPointsY, numOfPoints - middleIndex);
      double sigmaRight = findClosestPoints(rightSubPointsSortedX, rightSubPointsY, middleIndex);
      double sigma = Math.min(sigmaLeft, sigmaRight);

      List<Point> pointsInStrip = new ArrayList<>();

      for (int index = 0; index < numOfPoints; index++) {
        if (Math.abs(pointsY.get(index).getX() - middlePoint.getX()) < sigma) {
          pointsInStrip.add(pointsY.get(index));
        }
      }

      double minDistanceStrip = findMinimumDistanceInStrip(pointsInStrip, sigma);

      return Math.min(sigma, minDistanceStrip);
    }

    private double bruteForceApproach(List<Point> points) {
      double minDistance = Double.MAX_VALUE;
      for (int i = 0; i < points.size(); i++) {
        for (int j = i + 1; j < points.size(); j++) {
          if (distance(points.get(i), points.get(j)) < minDistance) {
            minDistance = distance(points.get(i), points.get(j));
          }
        }
      }
      return minDistance;
    }

    private double distance(Point p1, Point p2) {
      double xDistance = Math.abs(p1.getX() - p2.getX());
      double yDistance = Math.abs(p1.getY() - p2.getY());
      return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    private double findMinimumDistanceInStrip(List<Point> pointsInStrip, double sigma) {
      double minDistance = sigma;
      for (int i = 0; i < pointsInStrip.size(); i++) {
        for (int j = i + 1; j < pointsInStrip.size() && (pointsInStrip.get(j).getY() - pointsInStrip.get(i).getY()) < minDistance; j++) {
          if (distance(pointsInStrip.get(i), pointsInStrip.get(j)) < minDistance) {
            minDistance = distance(pointsInStrip.get(i), pointsInStrip.get(j));
          }
        }
      }
      return minDistance;
    }
  }

  public static class Point {
    private final double x;
    private final double y;
    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
    public double getX() {
      return x;
    }
    public double getY() {
      return y;
    }

    @Override
    public String toString() {
      return "Point{" + "x=" + x + ", y=" + y + '}';
    }
  }
}
