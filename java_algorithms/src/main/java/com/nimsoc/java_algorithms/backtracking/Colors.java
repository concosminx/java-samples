package com.nimsoc.java_algorithms.backtracking;

import java.util.HashMap;
import java.util.Map;

/*
   Given an undirected graph and a number m, determine if the graph can be coloured with at most m colours 
   such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph
   means the assignment of colors to all vertices. 
 */
public class Colors {

  private final int numOfVertex;
  private final int numOfColors;
  private final int[] colors;
  private final int[][] adjMatrix;

  public Colors(int numOfColors, int[][] adjMatrix) {
    this.numOfColors = numOfColors;
    this.adjMatrix = adjMatrix;
    this.numOfVertex = adjMatrix.length;
    this.colors = new int[numOfVertex];
  }

  public Result solve() {
    Result r;
    if (solveProblem(0)) {
      r = new Result(true);
      for (int i = 0; i < numOfVertex; i++) {
        r.getNodesAndColors().put((i + 1), colors[i]);
      }
    } else {
      r = new Result(false);
    }
    return r;
  }

  private boolean solveProblem(int nodeIndex) {
    if (nodeIndex == numOfVertex) {
      return true;
    }
    for (int colorIndex = 1; colorIndex <= numOfColors; colorIndex++) {
      if (isColorValid(nodeIndex, colorIndex)) {
        colors[nodeIndex] = colorIndex;
        if (solveProblem(nodeIndex + 1)) {
          return true;
        }
        //B
      }
    }
    return false;
  }

  private boolean isColorValid(int nodeIndex, int colorIndex) {
    for (int i = 0; i < numOfVertex; i++) {
      if (adjMatrix[nodeIndex][i] == 1 && colorIndex == colors[i]) {
        return false;
      }
    }
    return true;
  }

  public static class Result {

    boolean solution;
    Map<Integer, Integer> nodesAndColors = new HashMap<>();

    public Result(boolean solution) {
      this.solution = solution;
    }

    public boolean isSolution() {
      return solution;
    }

    public Map<Integer, Integer> getNodesAndColors() {
      return nodesAndColors;
    }
  }

}
