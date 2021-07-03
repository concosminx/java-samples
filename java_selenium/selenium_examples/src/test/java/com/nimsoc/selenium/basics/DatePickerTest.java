package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class DatePickerTest extends AbstractTest {

  @Test
  public void checkDatePickerElement() throws InterruptedException {
    WebDriver driver = getDriver();
    String expMonth = "August 2021";
    String expDate = "15";

    driver.get("https://www.trivago.com/");

    driver.findElement(By.xpath("//button[@data-qa='calendar-checkin']")).click();
    String currMonth = driver.findElement(By.cssSelector("th.cal-heading-month")).getText();
    int c = 0;
    while (!currMonth.contains(expMonth)) {
      driver.findElement(By.cssSelector("button.cal-btn-next")).click();
      c++;
      TimeUnit.SECONDS.sleep(1);
      currMonth = driver.findElement(By.cssSelector("th.cal-heading-month")).getText();
      if (c == 12) {
        break;
      }
    }

    List<WebElement> dates = driver.findElements(By.cssSelector("table.cal-month td"));

    for (WebElement date : dates) {
      String x = date.getText().trim();
      if (x.equals(expDate)) {
        date.click();
        break;
      }
    }

    driver.quit();
  }

}
