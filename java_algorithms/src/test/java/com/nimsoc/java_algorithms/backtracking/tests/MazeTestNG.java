package com.nimsoc.java_algorithms.backtracking.tests;

import com.nimsoc.java_algorithms.backtracking.Maze;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MazeTestNG {

  @Test
  public void testMaze() {
    int[][] maze = {
      {1, 1, 1, 1, 1},
      {1, 1, 0, 1, 0},
      {0, 0, 0, 1, 0},
      {1, 1, 1, 1, 1},
      {1, 1, 1, 0, 1},};

    Maze alg = new Maze(maze);
    Maze.Result result = alg.solve();
    
    Assert.assertTrue(result.isSolution());
    
    Assert.assertEquals(result.getMatrix()[0], new char[] {'S','S','S','S','-'});
    Assert.assertEquals(result.getMatrix()[4], new char[] {'-','-','-','-','S'});
    
    /*
    S  S  S  S  -
    -  -  -  S  -
    -  -  -  S  -
    -  -  -  S  S
    -  -  -  -  S 
    */
  }
}
