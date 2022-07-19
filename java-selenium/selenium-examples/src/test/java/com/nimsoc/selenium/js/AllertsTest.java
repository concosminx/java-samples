package com.nimsoc.selenium.js;

import com.nimsoc.selenium.AbstractTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class AllertsTest extends AbstractTest {

  @Test
  public void alertTest() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.dezlearn.com/javascript-alerts/");

    driver.findElement(By.id("s_alert1")).click();
    TimeUnit.SECONDS.sleep(3);
    Alert a = driver.switchTo().alert();
    System.out.println(a.getText());
    a.accept();
    driver.close();
  }

  @Test
  public void confirmationTest() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.dezlearn.com/javascript-alerts/");

    driver.findElement(By.id("c_alert2")).click();
    Thread.sleep(3000);
    Alert a = driver.switchTo().alert();
    System.out.println(a.getText());
    a.dismiss();
    driver.close();
  }

  @Test
  public void promptTest() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.dezlearn.com/javascript-alerts/");

    driver.findElement(By.id("p_alert3")).click();
    Thread.sleep(3000);

    Alert a = driver.switchTo().alert();

    a.sendKeys("Mumbai");
    Thread.sleep(1000);
    System.out.println(a.getText());
    a.accept();
    driver.close();
  }

}
