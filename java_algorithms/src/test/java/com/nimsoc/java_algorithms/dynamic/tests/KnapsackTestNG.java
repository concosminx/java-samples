
package com.nimsoc.java_algorithms.dynamic.tests;

import com.nimsoc.java_algorithms.dynamic.Knapsack;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;


public class KnapsackTestNG {
  
  
  @Test
  public void testKnapsack() {
    int numOfItems = 3;
    int capacityOfKnapsack = 5;
    
    int[] weightOfItems = new int[numOfItems + 1];
    weightOfItems[1] = 4;
    weightOfItems[2] = 2;
    weightOfItems[3] = 3;
    
    int[] profitOfItems = new int[numOfItems + 1];
    profitOfItems[1] = 10;
    profitOfItems[2] = 4;
    profitOfItems[3] = 7;
    
    Knapsack alg = new Knapsack(numOfItems, capacityOfKnapsack, weightOfItems, profitOfItems);
    alg.solve();
    
    Assert.assertEquals(alg.getResult(), Arrays.asList(3,2));
    
  }
}
