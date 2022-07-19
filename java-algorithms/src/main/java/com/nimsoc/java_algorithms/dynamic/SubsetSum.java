package com.nimsoc.java_algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;

/*
  The subset sum problem is a decision problem in computer science. In its most general formulation, there is a multiset S of integers and a 
  target sum T, and the question is to decide whether any subset of the integers sum to precisely T
 */
public class SubsetSum {

  private final boolean[][] dpTable;
  private final int[] s;
  private final int sum;

  public SubsetSum(int[] s, int sum) {
    this.s = s;
    this.sum = sum;
    this.dpTable = new boolean[s.length + 1][sum + 1];
  }

  public void solve() {
    for (int i = 0; i < s.length + 1; i++) {
      dpTable[i][0] = true;
    }
    for (int rowIndex = 1; rowIndex < s.length + 1; rowIndex++) {
      for (int columnIndex = 1; columnIndex < sum + 1; columnIndex++) {
        if (columnIndex < s[rowIndex - 1]) {
          dpTable[rowIndex][columnIndex] = dpTable[rowIndex - 1][columnIndex];
        } else {
          if (dpTable[rowIndex - 1][columnIndex] == true) {
            dpTable[rowIndex][columnIndex] = dpTable[rowIndex - 1][columnIndex];
          } else {
            dpTable[rowIndex][columnIndex] = dpTable[rowIndex - 1][columnIndex - s[rowIndex - 1]];
          }
        }
      }
    }
  }

  public Result getResult() {

    Result r = new Result(dpTable[s.length][sum]);

    int columnIndex = sum;
    int rowIndex = s.length;
    while (columnIndex > 0 || rowIndex > 0) {
      if (dpTable[rowIndex][columnIndex] == dpTable[rowIndex - 1][columnIndex]) {
        rowIndex--;
      } else {
        r.getElements().add(s[rowIndex - 1]);
        columnIndex = columnIndex - s[rowIndex - 1];
        rowIndex--;
      }
    }

    return r;
  }

  public static class Result {

    private boolean solution;
    private List<Integer> elements;

    public Result(boolean solution) {
      this.solution = solution;
      this.elements = new ArrayList<>();
    }

    public boolean getSolution() {
      return solution;
    }

    public List<Integer> getElements() {
      return elements;
    }
  }
}
