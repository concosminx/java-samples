package com.nimsoc.java_algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. 
  A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in the graph) 
  from the last vertex to the first vertex of the Hamiltonian Path. Determine whether a given graph contains 
  Hamiltonian Cycle or not. If it contains, then prints the path. Following are the input and output of the required function.
 */
public class HamiltonianCycle {

  private final int numOfVertexes;
  private final int[] hamiltonianPath;
  private final int[][] adjMatrix;

  public HamiltonianCycle(int[][] adjMatrix) {
    this.adjMatrix = adjMatrix;
    numOfVertexes = adjMatrix.length;
    this.hamiltonianPath = new int[adjMatrix.length];
    hamiltonianPath[0] = 0;
  }

  private boolean findFeasableSolution(int position) {
    if (position == numOfVertexes) {
      if (adjMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
        return true;
      } else {
        return false;
      }
    }
    for (int vertexIndex = 1; vertexIndex < numOfVertexes; ++vertexIndex) {
      if (isFeasable(vertexIndex, position)) {
        hamiltonianPath[position] = vertexIndex;
        if (findFeasableSolution(position + 1)) {
          return true;
        }
        //B
      }
    }
    return false;
  }

  private boolean isFeasable(int vertexIndex, int actualPosition) {
    if (adjMatrix[hamiltonianPath[actualPosition - 1]][vertexIndex] == 0) {
      return false;
    }
    for (int i = 0; i < actualPosition; i++) {
      if (hamiltonianPath[i] == vertexIndex) {
        return false;
      }
    }
    return true;
  }

  public Result solve() {
    Result r = null;
    if (findFeasableSolution(1)) {
      r = new Result(true);
      Arrays.stream(hamiltonianPath).forEach(r.getCycle()::add);
      r.cycle.add(this.hamiltonianPath[0]);
    } else {
      r = new Result(false);
    }
    return r;
  }

  public static class Result {
    private final boolean solution;
    private final List<Integer> cycle;

    public Result(boolean solution) {
      this.cycle = new ArrayList<>();
      this.solution = solution;
    }

    public boolean isSolution() {
      return solution;
    }

    public List<Integer> getCycle() {
      return cycle;
    }

  }
}
