package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class AlertTest extends AbstractTest {

  @Test
  void newTest() throws InterruptedException {
    WebDriver driver = getDriver();

    String text = "MyName";
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    driver.findElement(By.id("name")).sendKeys(text);
    driver.findElement(By.cssSelector("[id='alertbtn']")).click();
    System.out.println(driver.switchTo().alert().getText());
    driver.switchTo().alert().accept();
    driver.findElement(By.id("confirmbtn")).click();
    System.out.println(driver.switchTo().alert().getText());
    driver.switchTo().alert().dismiss();

    driver.close();
  }

}
