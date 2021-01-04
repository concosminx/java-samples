package com.cic.testng.expected;

import org.testng.annotations.Test;

public class TestRuntime {

  @Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
  public void divisionWithException() {
    int i = 1 / 0;
  }

}
