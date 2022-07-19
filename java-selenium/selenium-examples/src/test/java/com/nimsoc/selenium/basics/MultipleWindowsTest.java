package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class MultipleWindowsTest extends AbstractTest {

  @Test
  public void checkMultipleWindows() {
    WebDriver driver = getDriver();
    driver.get("https://www.dezlearn.com/multiple-browser-windows/");

    driver.findElement(By.id("u_7_8")).click();

    Set<String> windows = driver.getWindowHandles();

    for (String window : windows) {
      System.out.println(window);
      driver.switchTo().window(window);
      System.out.println(driver.getCurrentUrl());
      System.out.println(driver.getTitle());
      System.out.println("-------------------");
      if (driver.getCurrentUrl().equals("https://www.facebook.com/")) {
        break;
      }
    }

    //do something on this window
    driver.quit();
  }

  @Test
  public void closePopups() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.dezlearn.com/multiple-browser-windows/");

    driver.findElement(By.id("u_7_8")).click();
    TimeUnit.SECONDS.sleep(3);

    String parentWindow = driver.getWindowHandle();

    Set<String> windows = driver.getWindowHandles();

    for (String window : windows) {
      if (!window.equals(parentWindow)) {
        driver.switchTo().window(window);
        driver.close();
        TimeUnit.SECONDS.sleep(1);
      }
    }

    driver.switchTo().window(parentWindow);
  }

}
