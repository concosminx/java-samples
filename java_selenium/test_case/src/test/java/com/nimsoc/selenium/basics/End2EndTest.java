package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class End2EndTest extends AbstractTest {

  @Test
  void simpleTest1() throws InterruptedException {
    WebDriver driver = getDriver();

    //1. Give me the count of links on the page.
    //2. Count of footer section-
    System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
    driver.get("http://qaclickacademy.com/practice.php");
    System.out.println(driver.findElements(By.tagName("a")).size());
    WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
    System.out.println(footerdriver.findElements(By.tagName("a")).size());

    //3-
    WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
    System.out.println(coloumndriver.findElements(By.tagName("a")).size());
    //4- click on each link in the coloumn and check if the pages are opening-
    for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {
      String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
      coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
      Thread.sleep(5000L);

    }// opens all the tabs
    Set<String> abc = driver.getWindowHandles();//4
    Iterator<String> it = abc.iterator();

    while (it.hasNext()) {

      driver.switchTo().window(it.next());
      System.out.println(driver.getTitle());

    }

    driver.close();
  }

  @Test
  void simpleTest2() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.path2usa.com/travel-companions");
//April 23
    driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

    while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May")) {
      driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
    }

    List<WebElement> dates = driver.findElements(By.className("day"));
//Grab common attribute//Put into list and iterate
    int count = driver.findElements(By.className("day")).size();

    for (int i = 0; i < count; i++) {
      String text = driver.findElements(By.className("day")).get(i).getText();
      if (text.equalsIgnoreCase("21")) {
        driver.findElements(By.className("day")).get(i).click();
        break;
      }

    }
    driver.close();
  }

}
