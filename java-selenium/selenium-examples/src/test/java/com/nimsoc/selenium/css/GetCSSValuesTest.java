package com.nimsoc.selenium.css;

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
public class GetCSSValuesTest extends AbstractTest {

  @Test
  public void testCSSValues() throws InterruptedException {
    WebDriver driver = getDriver();

    driver.get("https://www.facebook.com/r.php");
    
    TimeUnit.SECONDS.sleep(1);

    WebElement element = driver.findElement(By.name("birthday_year"));

    String color = element.getCssValue("color");
    String bgColor = element.getCssValue("background-color");
    String font = element.getCssValue("font");
    String font_size = element.getCssValue("font-size");
    String foint_family = element.getCssValue("font-family");
    String height = element.getCssValue("height");
    String width = element.getCssValue("width");

    System.out.println("color:" + color);
    System.out.println("bgColor:" + bgColor);
    System.out.println("font:" + font);
    System.out.println("font_size:" + font_size);
    System.out.println("foint_family:" + foint_family);
    System.out.println("height:" + height);
    System.out.println("width:" + width);

    driver.quit();
  }
}
