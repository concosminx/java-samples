package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class BasicGetMethodsTest extends AbstractTest {

  @Test
  public void checkBasicGetMethods() {
    WebDriver driver = getDriver();
    driver.get("https://www.facebook.com/r.php");

    String att1 = driver.findElement(By.id("fullname_field")).getAttribute("class");
    String att3 = driver.findElement(By.id("fullname_field")).getTagName();
    String text = driver.findElement(By.cssSelector(".mbs")).getText();

    System.out.println(att1);

    System.out.println(att3);
    System.out.println(text);

    driver.quit();
  }

  @Test
  public void checkIfElementExists() {
    WebDriver driver = getDriver();
    driver.get("https://www.facebook.com/");
    try {
      driver.findElement(By.id("qwuyefjyg"));
      System.out.println("Pass: Element is Present");
    } catch (Exception e) {
      System.out.println("Fail: Element is Not Present");
    }
    driver.quit();
  }

  @Test
  public void checkIfElementIsVisibleAndEnabled() {
    WebDriver driver = getDriver();
    driver.get("https://www.facebook.com/");

    boolean isDisplayed = driver.findElement(By.id("u_0_u")).isDisplayed();
    boolean isEnabled = driver.findElement(By.id("u_0_u")).isEnabled();

    System.out.println(isDisplayed);
    System.out.println(isEnabled);

    driver.quit();
  }

  @Test
  public void checkIfElementIsSelected() {
    WebDriver driver = getDriver();
    driver.get("https://www.ebay.com/sch/ebayadvsearch");
    driver.manage().window().fullscreen();

    boolean rc1 = driver.findElement(By.xpath("//input[@id='LH_LPickup']")).isSelected();
    driver.findElement(By.xpath("//input[@id='LH_LPickup']")).click();
    boolean rc2 = driver.findElement(By.xpath("//input[@id='LH_LPickup']")).isSelected();
    System.out.println(rc1);
    System.out.println(rc2);

    boolean rc3 = driver.findElement(By.xpath("//input[@id='LH_PrefLocRadio']")).isSelected();
    driver.findElement(By.xpath("//input[@id='LH_PrefLocRadio']")).click();
    boolean rc4 = driver.findElement(By.xpath("//input[@id='LH_PrefLocRadio']")).isSelected();
    System.out.println(rc3);
    System.out.println(rc4);
    driver.quit();
  }
}
