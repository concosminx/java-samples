package com.nimsoc.java_algorithms.backtracking;

public class Sudoku {

  private static final int BOARD_SIZE = 9;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 9;
  private static final int BOX_SIZE = 3;

  private final int[][] sudokuTable;

  public Sudoku(int[][] sudokuTable) {
    this.sudokuTable = sudokuTable;
  }

  public Result solve() {
    Result r = null;
    if (solveSudoku(0, 0)) {
      r = new Result(true, BOARD_SIZE);
      for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++) {
          r.getMatrix()[i][j] = sudokuTable[i][j];
        }
      }
    } else {
      r = new Result(false, BOARD_SIZE);
    }
    return r;
  }

  private boolean solveSudoku(int rowIndex, int colIndex) {
    if (rowIndex == BOARD_SIZE && ++colIndex == BOARD_SIZE) {
      return true;
    }

    if (rowIndex == BOARD_SIZE) {
      rowIndex = 0;
    }

    if (sudokuTable[rowIndex][colIndex] != 0) {
      return solveSudoku(rowIndex + 1, colIndex);
    }

    for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
      if (valid(rowIndex, colIndex, number)) {
        sudokuTable[rowIndex][colIndex] = number;

        if (solveSudoku(rowIndex + 1, colIndex)) {
          return true;
        }

        //backtrack
        sudokuTable[rowIndex][colIndex] = 0;
      }
    }

    return false;
  }

  private boolean valid(int colIndex, int rowIndex, int actualNumber) {
    //if the given number is allready on the row: the number cannot be part of solution
    for (int i = 0; i < BOARD_SIZE; i++) {
      if (sudokuTable[i][rowIndex] == actualNumber) {
        return false;
      }
    }

    //if the given number is allready on the column: the number cannot be part of solution
    for (int k = 0; k < BOARD_SIZE; k++) {
      if (sudokuTable[colIndex][k] == actualNumber) {
        return false;
      }
    }

    //if the given number is already in the box: the number cannot be part of solution
    int boxRowOffset = (colIndex / 3) * BOX_SIZE;
    int boxColOffset = (rowIndex / 3) * BOX_SIZE;

    for (int i = 0; i < BOX_SIZE; i++) {
      for (int j = 0; j < BOX_SIZE; j++) {
        if (actualNumber == sudokuTable[boxRowOffset + i][boxColOffset + j]) {
          return false;
        }
      }
    }

    return true;
  }

  public static class Result {

    private final boolean solution;
    private final int[][] matrix;

    public Result(boolean solution, int size) {
      this.solution = solution;
      matrix = new int[size][size];
    }

    public boolean isSolution() {
      return solution;
    }

    public int[][] getMatrix() {
      return matrix;
    }
  }
}
