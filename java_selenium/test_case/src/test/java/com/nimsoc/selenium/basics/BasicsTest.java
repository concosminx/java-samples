package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class BasicsTest extends AbstractTest {

  @Test
  public void basicMethods() {

    WebDriver driver = getDriver();

    //driver.get("https://github.com/join");
    //driver.findElement(By.linkText("Learn more")).click();
    //driver.navigate().back();
    //driver.findElement(By.id("user_login")).sendKeys("myusername-hue");
    //driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("myusername-hue"); //test this in console $x("//input[@id='user_login']")
    //driver.findElement(By.id("user_email")).sendKeys("myusername-hue@supadupa.com"); 
    //System.out.println(driver.getTitle());
    //System.out.println(driver.getCurrentUrl());
    //driver.get("http://yahoo.com");
    //driver.navigate().back();
    driver.get("https://login.salesforce.com/");
    driver.findElement(By.id("username")).sendKeys("test-user");
    driver.findElement(By.name("pw")).sendKeys("test-pass");
    driver.findElement(By.xpath("//*[@id='Login']")).click();

    System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());

//    driver.get("http://facebook.com");
//
//    ////tagName[@attribute='value']  - xpath
//    driver.findElement(By.xpath("//*[@type='email']")).sendKeys("myown xpath");
//    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("hello");
//    driver.findElement(By.xpath("//input[@value='Log In']")).click();
//    //tagName[v='value']  -CSS
//    driver.findElement(By.cssSelector("input[name='email']")).sendKeys("myowncss");
//    driver.findElement(By.cssSelector("[value='Log In']")).click();

    //driver.close();
  }

}
