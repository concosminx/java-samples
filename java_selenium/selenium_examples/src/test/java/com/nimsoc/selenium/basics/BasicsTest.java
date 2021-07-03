package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class BasicsTest extends AbstractTest {

  @Test
  public void basicMethods() {
    
    WebDriver driver = getDriver();
    
    driver.get("https://www.amazon.com/");

    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
    System.out.println(driver.getPageSource());
    System.out.println(driver.getWindowHandle());

    driver.quit();
  }

}
