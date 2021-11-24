package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class AutoSugestiveTest extends AbstractTest {

  @Test
  void selectNew() throws InterruptedException {
    WebDriver driver = getDriver();

    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    driver.findElement(By.id("autosuggest")).sendKeys("ind");

    Thread.sleep(3000);

    List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
    for (WebElement option : options) {
      if (option.getText().equalsIgnoreCase("India")) {
        option.click();
        break;
      }
    }

    driver.close();
  }

  @Test
  void simpleTest() throws InterruptedException {
    WebDriver driver = getDriver();

    driver.get("https://www.ksrtc.in");
    driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
    Thread.sleep(2000);

    driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

    System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());

  //Javascript DOM can extract hidden elements
  //because selenium cannot identify hidden elements - (Ajax implementation)
  //investigate the properties of object if it have any hidden text
  //JavascriptExecutor
    JavascriptExecutor js = (JavascriptExecutor) driver;

    String script = "return document.getElementById(\"fromPlaceName\").value;";
    String text = (String) js.executeScript(script);
    System.out.println(text);
    int i = 0;
//BENGALURU INTERNATION AIPORT
    while (!text.equalsIgnoreCase("BENGALURU INTATION AIPORT")) {
      i++;
      driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

      text = (String) js.executeScript(script);
      System.out.println(text);
      if (i > 10) {
        break;
      }

    }

    if (i > 10) {
      System.out.println("Element not found");
    } else {
      System.out.println("Element  found");
    }

    driver.close();
  }
}
