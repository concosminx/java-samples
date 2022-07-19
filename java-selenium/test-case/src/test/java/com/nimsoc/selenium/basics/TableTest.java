package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import static com.nimsoc.selenium.basics.Day1.gotoframe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class TableTest extends AbstractTest {

  @Test
  void tableTest1() throws InterruptedException {
    WebDriver driver = getDriver();

    int sum = 0;
    driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");

    WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
    int rowcount = table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
    int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

    for (int i = 0; i < count - 2; i++) {
      String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
      int valueinteger = Integer.parseInt(value);
      sum = sum + valueinteger;//103
    }
    //System.out.println(sum);

    String Extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
    int extrasValue = Integer.parseInt(Extras);
    int TotalSumValue = sum + extrasValue;
    System.out.println(TotalSumValue);

    String ActualTotal = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
    int ActualTotalVAlue = Integer.parseInt(ActualTotal);
    if (ActualTotalVAlue == TotalSumValue) {
      System.out.println("Count Matches");
    } else {
      System.out.println("count fails");
    }

    driver.close();
  }

  @Test
  void tableTest2() throws InterruptedException {
    WebDriver driver = getDriver();
    WebDriverWait wd = new WebDriverWait(driver, 7);

    driver.get("https://fantasycricket.dream11.com/IN/");

    driver.manage().window().maximize();

    int m = gotoframe(driver, By.xpath(".//*[@id='recaptcha-anchor']"));

    driver.switchTo().frame(m);

    driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();

    driver.switchTo().defaultContent();

    wd.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("I1_1441700500937")));

    int j = gotoframe(driver, By.xpath(".//*[@id='recaptcha-verify-button']"));

    if (j != -1) {

      driver.switchTo().frame(j);

//WebDriverWait wd=new WebDriverWait(driver,5);
//wd.until(ExpectedConditions.(By.xpath(".//*[@id='recaptcha-verify-button']")));
      driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click();

    } else {

      System.out.println("ops");

    }
    
    driver.close();
  }
  
}

class Day1 {

  public static int gotoframe(WebDriver driver1, By by) {
    driver1.switchTo().defaultContent();
    int i;
    int num = -1;
    int a = driver1.findElements(By.tagName("iframe")).size();
    for (i = 0; i < a; i++) {
      driver1.switchTo().defaultContent();
      driver1.switchTo().frame(i);
      int b = driver1.findElements(by).size();
      if (b > 0) {
        num = i;
        break;
      }
    }
    driver1.switchTo().defaultContent();
    return num;
  }
}
