package com.nimsoc.selenium.iframes;

import com.nimsoc.selenium.AbstractTest;
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
public class IframesTest extends AbstractTest {

  @Test
  public void iframeTest() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.dezlearn.com/iframe-example/");
    TimeUnit.SECONDS.sleep(2);

    WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='iframe2']"));

    //driver.switchTo().frame(1); //Using Index
    //driver.switchTo().frame("iframe1"); //Using ID
    //driver.switchTo().frame("demo_frame2"); //Using Name
    driver.switchTo().frame(frame1); //Using WebElement

    driver.findElement(By.id("u_5_6")).click();

    driver.switchTo().defaultContent();
  }

  @Test
  public void nestedIframeTest() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.dezlearn.com/nested-iframes/");
    TimeUnit.SECONDS.sleep(2);

    driver.switchTo().frame("demo_parent_iframe");

    driver.switchTo().frame("demo_frame1");

    driver.findElement(By.id("u_5_6")).click();

    TimeUnit.SECONDS.sleep(2);

    driver.switchTo().parentFrame();

    driver.findElement(By.id("u_5_5")).click();

    driver.switchTo().defaultContent();
  }

}
