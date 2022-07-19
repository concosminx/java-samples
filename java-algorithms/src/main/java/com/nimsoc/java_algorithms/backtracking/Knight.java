package com.nimsoc.java_algorithms.backtracking;

/*
  Given a N*N board with the Knight placed on the first block of an empty board. Moving according to 
  the rules of chess knight must visit each square exactly once. Print the order of each the cell 
  in which they are visited.
 */
public class Knight {

  public static final int BOARD_SIZE = 8;
  public static final int NUM_OF_MOVES = 8;

  private final int[][] solutionMatrix;
  private final int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
  private final int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

  public Knight() {
    this.solutionMatrix = new int[BOARD_SIZE][BOARD_SIZE];
    initializeBoard();
  }

  private void initializeBoard() {
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        solutionMatrix[i][j] = Integer.MIN_VALUE;
      }
    }
  }

  public Result solve() {
    Result r = null;
    solutionMatrix[0][0] = 1;
    if (getSolution(2, 0, 0)) {
      r = new Result(true);
      for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++) {
          r.getMatrix()[i][j] = solutionMatrix[i][j];
        }
      }
    } else {
      r = new Result(false);
    }
    return r;
  }

  private boolean getSolution(int stepCount, int x, int y) {
    if (stepCount == BOARD_SIZE * BOARD_SIZE + 1) {
      return true;
    }
    for (int i = 0; i < NUM_OF_MOVES; i++) {
      int nextX = x + xMoves[i];
      int nextY = y + yMoves[i];

      if (isStepValid(nextX, nextY)) {
        solutionMatrix[nextX][nextY] = stepCount;
        if (getSolution(stepCount + 1, nextX, nextY)) {
          return true;
        }
        //B
        solutionMatrix[nextX][nextY] = Integer.MIN_VALUE;
      }
    }
    return false;
  }

  private boolean isStepValid(int x, int y) {
    if (x < 0 || x >= BOARD_SIZE) {
      return false;
    }
    if (y < 0 || y >= BOARD_SIZE) {
      return false;
    }
    if (solutionMatrix[x][y] != Integer.MIN_VALUE) {
      return false;
    }
    return true;
  }

  public static class Result {

    private final boolean solution;
    private final int[][] matrix;

    public Result(boolean solution) {
      this.solution = solution;
      this.matrix = new int[BOARD_SIZE][BOARD_SIZE];
    }

    public boolean isSolution() {
      return solution;
    }

    public int[][] getMatrix() {
      return matrix;
    }
  }
}
