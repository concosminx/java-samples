package com.nimsoc.java_algorithms.interview;

/*
   The following is a description of the instance of this famous puzzle involving 2 eggs and a building with 100 floors.
  
   Suppose that we wish to know which stories in a 100-story building are safe to drop eggs from, and which will cause the eggs to 
   break on landing. What strategy should be used to drop eggs such that total number of drops in worst case is minimized and we
   find the required floor.

   We may make a few assumptions:

   An egg that survives a fall can be used again.
   A broken egg must be discarded.
   The effect of a fall is the same for all eggs.
   If an egg breaks when dropped, then it would break if dropped from a higher floor.
   If an egg survives a fall then it would survive a shorter fall.

   x + (x-1) + (x-2) + (x-3) + .... + 1  = 100
   x(x+1)/2  = 100 
   x = 13.651 ~ 14
   
 */
public class Eggs {
  
  private final int numOfEggs;
  private final int numOfFloors;
  private final int[][] table;

  public Eggs(int numOfEggs, int numOfFloors) {
    this.numOfEggs = numOfEggs;
    this.numOfFloors = numOfFloors;
    this.table = new int[numOfEggs + 1][numOfFloors + 1];
  }

  public int solve() {
    table[0][0] = 1;
    table[1][0] = 1;

    for (int i = 0; i <= numOfFloors; i++) {
      table[1][i] = i;
    }

    for (int n = 2; n <= numOfEggs; n++) {
      for (int m = 1; m <= numOfFloors; m++) {
        table[n][m] = Integer.MAX_VALUE;
        for (int x = 1; x <= m; x++) {
          int maxDrops = 1 + Math.max(table[n - 1][x - 1], table[n][m - x]);
          if (maxDrops < table[n][m]) {
            table[n][m] = maxDrops;
          }
        }
      }
    }
    return table[numOfEggs][numOfFloors];
  }
}
