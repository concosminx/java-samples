package com.nimsoc.java_algorithms.backtracking;

/*
  The N Queen is the problem of placing N chess queens on an NxN chessboard so that no two queens attack each other.
 */
public class NQuens {

  private final int[][] chessTable;
  private final int numOfQueens;

  public NQuens(int numOfQueens) {
    this.chessTable = new int[numOfQueens][numOfQueens];
    this.numOfQueens = numOfQueens;
  }

  public Result solve() {
    Result r;
    if (setQueens(0)) {
      r = new Result(true, chessTable.length);
      for (int i = 0; i < chessTable.length; i++) {
        for (int j = 0; j < chessTable.length; j++) {
          if (chessTable[i][j] == 1) {
            r.getMatrix()[i][j] = '*';
          } else {
            r.getMatrix()[i][j] = '-';
          }
        }
      }
    } else {
      r = new Result(false, chessTable.length);
    }
    return r;
  }

  private boolean setQueens(int colIndex) {
    if (colIndex == numOfQueens) {
      return true;
    }

    for (int rowIndex = 0; rowIndex < numOfQueens; ++rowIndex) {
      if (isPlaceValid(rowIndex, colIndex)) {
        chessTable[rowIndex][colIndex] = 1;
        if (setQueens(colIndex + 1)) {
          return true;
        }
        //B
        chessTable[rowIndex][colIndex] = 0;
      }
    }

    return false;
  }

  private boolean isPlaceValid(int rowIndex, int colIndex) {
    for (int i = 0; i < colIndex; i++) {
      if (chessTable[rowIndex][i] == 1) {
        return false;
      }
    }
    int i = rowIndex;
    int j = colIndex;
    while (i >= 0 && j >= 0) {
      if (chessTable[i][j] == 1) {
        return false;
      }
      i--;
      j--;
    }

    i = rowIndex;
    j = colIndex;
    while (i < chessTable.length && j >= 0) {
      if (chessTable[i][j] == 1) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  public static class Result {

    private final boolean solution;
    private final char[][] matrix;

    public Result(boolean solution, int tableSize) {
      this.solution = solution;
      this.matrix = new char[tableSize][tableSize];
    }

    public boolean isSolution() {
      return solution;
    }

    public char[][] getMatrix() {
      return matrix;
    }
  }

}
