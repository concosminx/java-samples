package com.nimsoc.selenium.drivers;

import com.nimsoc.selenium.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


@Test
public class SeleniumDriverTest {
  
  @Test
  public void testMozillaDriver() {
    WebDriver driver = DriverProvider.getSeleniumDriver(DriverProvider.DriverType.FIREFOX);
    
    driver.get("https://www.google.com");
    System.out.println(driver.getTitle());
    driver.quit();
  }
  
  
  @Test
  public void testChromeDriver() {
    WebDriver driver = DriverProvider.getSeleniumDriver(DriverProvider.DriverType.CHROME);
    
    driver.get("https://www.google.com");
    System.out.println(driver.getTitle());
    driver.quit();
  }
  
}
