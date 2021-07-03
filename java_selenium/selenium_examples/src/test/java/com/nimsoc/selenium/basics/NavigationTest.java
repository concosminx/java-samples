package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class NavigationTest extends AbstractTest {
  
  
  @Test
  public void navigate() {
    WebDriver driver = getDriver();
    
    driver.navigate().to("https://www.facebook.com/");
    System.out.println(driver.getTitle());
    
    driver.navigate().back();
    System.out.println(driver.getTitle());
    
    driver.navigate().forward();
    System.out.println(driver.getTitle());
    
    driver.navigate().refresh();
    
    driver.quit();
    
  }
}
