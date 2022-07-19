package com.nimsoc.java_algorithms.recursion.tests;

import com.nimsoc.java_algorithms.recursion.BinarySearch;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BinarySearchTestNG {

  @Test
  @Parameters({"dim"})
  public void testBinarySearch(int dim) {
    Random r = new Random();
    int[] arr = IntStream.range(1, dim)
            .map((i) -> r.nextInt())
            .toArray();

    int nr = arr[0];
        
    Arrays.sort(arr); 
    
    BinarySearch alg = new BinarySearch(arr);
    Assert.assertTrue(alg.search(0, dim-1, nr) == Arrays.binarySearch(arr, nr));
    
    Assert.assertTrue(alg.search(0, dim-1, dim+1) == -1);
  }

}
