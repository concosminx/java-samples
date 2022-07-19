
package com.nimsoc.java_algorithms.interview.tests;

import com.nimsoc.java_algorithms.interview.Eggs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EggsTestNG {
  
  @Test
  public void testEggs() {
     Eggs alg = new Eggs(2, 36);
     Assert.assertEquals(alg.solve(), 8);
     
     
     Eggs alg2 = new Eggs(1, 1);
     Assert.assertEquals(alg2.solve(), 1);
     
     
     Eggs alg3 = new Eggs(2, 100);
     Assert.assertEquals(alg3.solve(), 14);
  }
}
