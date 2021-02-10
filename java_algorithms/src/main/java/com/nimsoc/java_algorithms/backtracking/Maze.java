package com.nimsoc.java_algorithms.backtracking;

/*
  A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and 
  destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach the destination. 
  The rat can move only in two directions: forward and down. 

  In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path 
  from source to destination. Note that this is a simple version of the typical Maze problem. 
  For example, a more complex version can be that the rat can move in 4 directions and a more complex version 
  can be with a limited number of moves.
 */
public class Maze {

  private final int[][] mazeTable;
  private final int[][] solutionTable;
  private final int mazeSize;

  public Maze(int[][] mazeTable) {
    this.mazeTable = mazeTable;
    this.mazeSize = mazeTable.length;
    this.solutionTable = new int[mazeSize][mazeSize];
  }

  public Result solve() {
    Result r = null;
    if (solveMaze(0, 0)) {
      r = new Result(true, mazeSize);
      for (int i = 0; i < mazeSize; i++) {
        for (int j = 0; j < mazeSize; j++) {
          if (solutionTable[i][j] == 1) {
            r.getMatrix()[i][j] = 'S';
          } else {
            r.getMatrix()[i][j] = '-';
          }
        }
      }
    } else {
      r = new Result(false, mazeSize);
    }
    return r;
  }

  private boolean solveMaze(int x, int y) {
    if (isFinished(x, y)) {
      return true;
    }

    if (isValid(x, y)) {
      solutionTable[x][y] = 1;

      if (solveMaze(x + 1, y)) {
        return true;
      }
      if (solveMaze(x, y + 1)) {
        return true;
      }
      //B
      solutionTable[x][y] = 0;
    }
    return false;
  }

  private boolean isFinished(int x, int y) {
    if (x == mazeSize - 1 && y == mazeSize - 1) {
      solutionTable[x][y] = 1;
      return true;
    }
    return false;
  }

  private boolean isValid(int x, int y) {
    if (x < 0 || x >= mazeSize) {
      return false;
    }
    if (y < 0 || y >= mazeSize) {
      return false;
    }
    if (mazeTable[x][y] != 1) {
      return false;
    }
    return true;
  }

  public static class Result {

    private final boolean solution;
    private final char[][] matrix;

    public Result(boolean solution, int mazeLength) {
      this.solution = solution;
      this.matrix = new char[mazeLength][mazeLength];
    }

    public boolean isSolution() {
      return solution;
    }

    public char[][] getMatrix() {
      return matrix;
    }
  }
}
