package com.nimsoc.selenium.css;

import com.nimsoc.selenium.AbstractTest;
import java.util.List;
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
public class WebElementsTest extends AbstractTest {

  @Test
  public void collectElementsWithType() {
    WebDriver driver = getDriver();

    driver.get("https://www.actitime.com/");

    List<WebElement> links = driver.findElements(By.cssSelector("a.footer-menu__link"));

    for (WebElement link : links) {
      String text = link.getText();
      if (!text.trim().isEmpty()) {
        System.out.println(link.getText());
        System.out.println(link.getAttribute("class"));
        System.out.println("-------------------");
      }
    }

    driver.close();
  }

  @Test
  public void checkVisibleElements() {
    WebDriver driver = getDriver();

    driver.get("https://www.goodreads.com/");

    List<WebElement> books = driver.findElements(By.cssSelector("img[src$='.jpg']"));

    System.out.println(books.size());

    for (WebElement book : books) {
      if (book.isDisplayed()) {
        System.out.println(book.isDisplayed());
        System.out.println(book.getAttribute("alt"));
        System.out.println("---------------------");
      }
    }

    driver.close();
  }

  @Test
  public void listBooks() {
    WebDriver driver = getDriver();

    driver.get("https://www.goodreads.com/");

    List<WebElement> books = driver.findElements(By.cssSelector("img[src$='.jpg']"));

    System.out.println(books.size());

    for (WebElement book : books) {
      System.out.println(book.getAttribute("alt"));
      System.out.println("---------------------");
    }

    driver.close();
  }

  @Test
  public void getPriceFromWallmart() throws InterruptedException {
    WebDriver driver = getDriver();

    driver.get("https://www.walmart.com");

    driver.findElement(By.id("global-search-input")).click();

    driver.findElement(By.id("global-search-input")).sendKeys("Mens Shoes");

    driver.findElement(By.id("global-search-submit")).click();

    TimeUnit.SECONDS.sleep(5);

    List<WebElement> items = driver.findElements(By.cssSelector("div.search-result-gridview-item-wrapper"));

    //div.search-result-gridview-item-wrapper span.price-main:first-child
    for (WebElement item : items) {
      String itmPz = item.findElement(By.cssSelector("span.price-main:first-child")).getText().trim();
      String itmPz2 = itmPz.replace("$", "").replace(" ", "");
      double itmPz3 = Double.parseDouble(itmPz2);
      if (itmPz3 < 20.0 || itmPz3 > 50.00) {
        WebElement productTitle = item.findElement(By.cssSelector("a.product-title-link"));
        System.out.println(productTitle.getText());
        System.out.println(productTitle.getAttribute("href"));
        System.out.println(itmPz);
        System.out.println("-------------------------");
      }
    }

    driver.quit();
  }
}
