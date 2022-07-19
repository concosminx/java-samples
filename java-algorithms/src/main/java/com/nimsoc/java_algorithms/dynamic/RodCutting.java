package com.nimsoc.java_algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;

/*
  Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by 
  cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given
  as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
*/
public class RodCutting {

  private final int[][] dpTable;
  private final int lengthOfRod;
  private final int[] prices;

  public RodCutting(int lengthOfRod, int[] prices) {
    this.lengthOfRod = lengthOfRod;
    this.prices = prices;
    this.dpTable = new int[prices.length + 1][lengthOfRod + 1];
  }

  public void solve() {
    for (int i = 1; i < prices.length; i++) {
      for (int j = 1; j <= lengthOfRod; j++) {
        if (i <= j) {
          dpTable[i][j] = Math.max(dpTable[i - 1][j], prices[i] + dpTable[i - 1][j - i]);
        } else {
          dpTable[i][j] = dpTable[i - 1][j];
        }
      }
    }
  }
  
  public Result getResult() {
    Result r = new Result(dpTable[prices.length - 1][lengthOfRod]);
    for (int n = prices.length -1, w = lengthOfRod; n > 0;) {
      if (dpTable[n][w] != 0 && dpTable[n][w] != dpTable[n-1][w]) {
        r.getCuts().add(n);
        w = w - n;
      } else {
        n--;
      }
    }
    return r;
  }
  
  public static class Result {
    int profit; 
    List<Integer> cuts;

    public int getProfit() {
      return profit;
    }

    public List<Integer> getCuts() {
      return cuts;
    }

    public Result(int profit) {
      this.profit = profit;
      this.cuts = new ArrayList<>();
    }
  }

}
