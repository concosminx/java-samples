package com.nimsoc.gs;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class AppTest {

  @Test
  public void appHasAGreeting() {
    App classUnderTest = new App();
    assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
  }
}