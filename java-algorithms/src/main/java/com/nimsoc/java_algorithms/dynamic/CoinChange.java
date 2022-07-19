package com.nimsoc.java_algorithms.dynamic;


/*
  Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
  how many ways can we make the change? The order of coins doesn’t matter.

  For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. 
  For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
*/
public class CoinChange {

  public int naiveCoinChange(int S, int[] values, int idx) {
    if (S < 0) {
      return 0;
    }
    if (S == 0) {
      return 1;
    }
    if (values.length == idx) {
      return 0;
    }
    return naiveCoinChange(S - values[idx], values, idx) + naiveCoinChange(S, values, idx + 1);
  }

  public int dpCoinChange(int[] values, int S) {
    int[][] table = new int[values.length + 1][S + 1];
    for (int i = 0; i <= values.length; i++) {
      table[i][0] = 1;
    }
    for (int i = 1; i <= S; i++) {
      table[0][i] = 0;
    }
    for (int i = 1; i <= values.length; i++) {
      for (int j = 0; j <= S; j++) {
        if (values[i - 1] <= j) {
          table[i][j] = table[i - 1][j] + table[i][j - values[i - 1]];
        } else {
          table[i][j] = table[i - 1][j];
        }
      }
    }

    return table[values.length][S];
  }
}
