package com.nimsoc.selenium.misc;

import com.nimsoc.selenium.AbstractTest;
import static java.lang.Math.log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class ActionsTest extends AbstractTest {

  @Test
  public void testActions() {
    WebDriver driver = getDriver();
    driver.manage().window().maximize();
    driver.get("https://www.amazon.com/");
    Actions a = new Actions(driver);
    /* a.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))) .click().keyDown(Keys.SHIFT).sendKeys("capitalletters").doubleClick().build().perform();
    a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
    a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build().perform();*/
    driver.get("http://jqueryui.com/demos/droppable/");
    System.out.println(driver.findElements(By.tagName("iframe")).size());
    try {
      driver.switchTo().frame(0);
      //log.info("Successfully switched to frame");
    } catch (Exception e) {
      //log.error("Cannot identify the frame");
    }
    //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
    //log.debug("Identifying Draggable objects");
    WebElement draggable = driver.findElement(By.id("draggable"));
    WebElement droppable = driver.findElement(By.id("droppable"));
    new Actions(driver).dragAndDrop(draggable, droppable).build().perform();
    //log.info("Drag and drop success");
  }

}
