package com.nimsoc.java_algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;

/*
  The knapsack problem is a problem in combinatorial optimization: Given a set of items, each with a weight and a value, determine 
  the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total 
  value is as large as possible.
 */
public class Knapsack {

  private final int numOfItems;
  private final int capacityOfKnapsack;
  private final int[][] knapsackTable;
  private int totalBenefit;
  private final int[] weights;
  private final int[] values;

  public Knapsack(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
    this.numOfItems = numOfItems;
    this.capacityOfKnapsack = capacityOfKnapsack;
    this.weights = weights;
    this.values = values;
    this.knapsackTable = new int[numOfItems + 1][capacityOfKnapsack + 1];
  }

  public void solve() {
    for (int i = 1; i < numOfItems + 1; i++) {
      for (int w = 1; w < capacityOfKnapsack + 1; w++) {
        int notTakingItem = knapsackTable[i - 1][w]; //not taking item i
        int takingItem = 0;

        if (weights[i] <= w) {
          takingItem = values[i] + knapsackTable[i - 1][w - weights[i]];
        }

        knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
      }
    }

    totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];
  }

  public List<Integer> getResult() {
    List<Integer> result = new ArrayList<>();
    for (int n = numOfItems, w = capacityOfKnapsack; n > 0; n--) {
      if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n - 1][w]) {
        result.add(n);
        w = w - weights[n];
      }
    }
    return result;
  }
}
