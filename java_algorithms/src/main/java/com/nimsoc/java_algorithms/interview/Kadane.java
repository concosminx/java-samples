package com.nimsoc.java_algorithms.interview;

/*
   In computer science, the maximum sum subarray problem is the task of finding a contiguous subarray with the largest sum, within a given 
   one-dimensional array A[1...n] of numbers. 
*/


public class Kadane {
  
  public int solve(int[] nums) {
    int maxEndHere = nums[0];
    int maxSoFar = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxEndHere = Math.max(nums[i], maxEndHere + nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }

}
