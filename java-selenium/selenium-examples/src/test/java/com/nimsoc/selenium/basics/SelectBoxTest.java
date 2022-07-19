package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class SelectBoxTest extends AbstractTest {

  @Test
  public void selectBoxTest() {
    WebDriver driver = getDriver();

    driver.get("https://www.facebook.com/r.php");

    String x = driver.findElement(By.id("month")).getAttribute("value");
    String y = driver.findElement(By.id("day")).getAttribute("value");
    String z = driver.findElement(By.id("year")).getAttribute("value");

    System.out.println(x);
    System.out.println(y);
    System.out.println(z);

    List<WebElement> m = driver.findElements(By.cssSelector("select#month>option"));

    for (WebElement month : m) {
      if (month.getText().trim().equals("ian.")) {
        month.click();
        break;
      }
    }

    driver.quit();
  }

  @Test(enabled = false)
  public void multSelectBoxTest() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.linkedin.com ... ");

    driver.findElement(By.xpath("//button[contains(text(),'Experience Level')]")).click();
    TimeUnit.SECONDS.sleep(1);

    List<WebElement> options = driver.findElements(By.cssSelector("#EXPERIENCE-dropdown li"));

    for (WebElement option : options) {
      if (option.getText().contains("Associate")
              || option.getText().contains("Director")) {
        option.click();
      }
    }
    driver.quit();
  }
}
