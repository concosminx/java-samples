package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class FindElementsByNameAndCSSTest extends AbstractTest {

  @Test
  public void elementsByNameAndCSS() throws Exception {

    WebDriver driver = getDriver();

    driver.get("https://www.amazon.com/");

    driver.findElement(By.name("field-keywords")).sendKeys("ps5");

    driver.findElement(By.className("nav-input")).click();

    TimeUnit.SECONDS.sleep(1);

    /*
    //not working
    driver.findElement(By.partialLinkText("5 Side Shell Faceplate - Matte Black")).click(); 

    TimeUnit.SECONDS.sleep(2);

    String productTitle = driver.findElement(By.id("productTitle")).getText();
    String productPrice = driver.findElement(By.id("priceblock_ourprice")).getText();

    System.out.println(productTitle + ": " + productPrice);
    */

    driver.quit();
  }

}
