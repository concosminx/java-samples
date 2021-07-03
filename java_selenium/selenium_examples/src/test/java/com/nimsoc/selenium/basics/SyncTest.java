package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.concurrent.TimeUnit;
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
public class SyncTest extends AbstractTest {

  @Test
  public void sync() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.dezlearn.com/test-sync-example/");

    driver.findElement(By.xpath("//input[@id='ninja_forms_field_97']")).sendKeys("De Zinnia");
    driver.findElement(By.xpath("//input[@id='ninja_forms_field_98']")).sendKeys("Institutes");
    driver.findElement(By.xpath("//input[@id='ninja_forms_field_100']")).sendKeys("dezinnia@dezlearn.com");

    driver.findElement(By.id("u_5_6")).click();
    TimeUnit.SECONDS.sleep(10);
    driver.findElement(By.linkText("Go to Next Page")).click();
  }

  @Test
  public void implicitWait() {
    WebDriver driver = getDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.dezlearn.com/test-sync-example/");

    driver.findElement(By.xpath("//input[@id='ninja_forms_field_97']")).sendKeys("De Zinnia");
    driver.findElement(By.xpath("//input[@id='ninja_forms_field_98']")).sendKeys("Institutes");
    driver.findElement(By.xpath("//input[@id='ninja_forms_field_100']")).sendKeys("dezinnia@dezlearn.com");

    driver.findElement(By.id("u_5_6")).click();

    driver.findElement(By.linkText("Go to Next Page")).click();
  }

  @Test
  public void explicitWait() {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.get("https://www.dezlearn.com/explicit-wait-example/");
    driver.findElement(By.xpath("//input[@id='ninja_forms_field_97']")).sendKeys("De Zinnia");
    driver.findElement(By.xpath("//input[@id='ninja_forms_field_98']")).sendKeys("Institutes");
    driver.findElement(By.xpath("//input[@id='ninja_forms_field_100']")).sendKeys("dezinnia@dezlearn.com");

    driver.findElement(By.id("u_5_6")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("u_5_7"))).click();
  }

}
