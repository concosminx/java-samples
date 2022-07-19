package com.nimsoc.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractBaseTest extends AbstractTest {

  WebDriver driver;

  @BeforeTest
  public void setUp() throws Exception {
    driver = getDriver();
  }

  @AfterTest
  public void tearDown() {
    driver.close();
  }

}
