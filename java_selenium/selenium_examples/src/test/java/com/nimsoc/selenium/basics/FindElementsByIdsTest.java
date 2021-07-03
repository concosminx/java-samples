package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class FindElementsByIdsTest extends AbstractTest {
  
  @Test
  public void getElementsByIds() {
    WebDriver driver = getDriver();
    
    driver.get("https://www.actitime.com/");
    
    driver.findElement(By.linkText("Start Using actiTIME")).click();
    
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.urlToBe("https://www.actitime.com/free-online-trial"));
    
    driver.findElement(By.id("first-name")).sendKeys("John");
    
    driver.findElement(By.id("last-name")).sendKeys("Doe");
    
    driver.findElement(By.id("email")).sendKeys("johndoe@nomail.org");
    
    driver.findElement(By.id("company")).sendKeys("HUBA DUBA ORG.");
    
    driver.quit();
  }

}
