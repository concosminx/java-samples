package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class SwitchToTabTest extends AbstractTest {

  @Test(enabled = false)
  public void testSwitch() {
    WebDriver driver = getDriver();
    
    driver.get("https://www.facebook.com/r.php");

    driver.findElement(By.linkText("Data Policy")).click();

    String parentWindow = driver.getWindowHandle();

    Set<String> windows = driver.getWindowHandles();

    for (String window : windows) {
      if (!window.equals(parentWindow)) {
        driver.switchTo().window(window);
      }
    }

    driver.findElement(By.cssSelector("a.signup_btn")).click();

    driver.switchTo().window(parentWindow);
    
    driver.quit();
  }

}
