package com.nimsoc.java_algorithms.selection.tests;

import com.nimsoc.java_algorithms.selection.QuickSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuickSelectTestNG {
  
  @Test
  public void testQuickSelect() {
    int a[] = {1, 5, 4, 8, -2};
    QuickSelect alg = new QuickSelect(a);
    
    Assert.assertEquals(5, alg.select(2));
    Assert.assertEquals(8, alg.select(1));

  }
}

