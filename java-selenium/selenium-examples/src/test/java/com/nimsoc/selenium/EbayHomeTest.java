package com.nimsoc.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 *
 * @author Cosminx
 */
public class EbayHomeTest extends AbstractBaseTest {

  @Test
  public void empty_search_test() throws Exception {

    String expectedURL = "https://www.ebay.com/n/all-categories";
    String expectedTitle = "Shop by Category | eBay";

    Assert.assertTrue(driver.findElement(By.cssSelector("input#gh-btn")).isEnabled(), "Verify Search Button Enabled");

    driver.findElement(By.cssSelector("input#gh-btn")).click();
    Thread.sleep(2000);
    String newUrl = driver.getCurrentUrl();
    String newTitle = driver.getTitle();
    System.out.println(newUrl);
    System.out.println(newTitle);

    Assert.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
    Assert.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");

  }

  @Test
  public void empty_search_test_softassert() throws Exception {

    SoftAssert sa = new SoftAssert();

    String expectedURL = "https://www.ebay.com/n/all-categories";
    String expectedTitle = "Shop by Category | eBay";

    sa.assertTrue(driver.findElement(By.cssSelector("input#gh-btn")).isEnabled(), "Verify Search Button Enabled");

    driver.findElement(By.cssSelector("input#gh-btn")).click();
    Thread.sleep(2000);
    String newUrl = driver.getCurrentUrl();
    String newTitle = driver.getTitle();
    System.out.println(newUrl);
    System.out.println(newTitle);

    sa.assertEquals(newUrl, expectedURL, "Verify URL of the new page");
    sa.assertEquals(newTitle, expectedTitle, "Verify Title of the new page");

    sa.assertAll();
  }
}
