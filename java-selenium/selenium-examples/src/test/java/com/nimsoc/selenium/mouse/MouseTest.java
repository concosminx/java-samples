package com.nimsoc.selenium.mouse;

import com.nimsoc.selenium.AbstractTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class MouseTest extends AbstractTest {

  @Test
  public void mouseHoover() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://www.actitime.com/");

    Actions action = new Actions(driver);
    WebElement clients = driver.findElement(By.linkText("Clients"));
    action.moveToElement(clients).perform();
    TimeUnit.SECONDS.sleep(2);
    driver.findElement(By.linkText("IT")).click();
    TimeUnit.SECONDS.sleep(2);
    System.out.println(driver.getCurrentUrl());
  }

  @Test
  public void rightClickTest() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

    WebElement btn = driver.findElement(By.xpath("//span[text()='right click me']"));
    Actions action = new Actions(driver);
    action.contextClick(btn).perform();

    TimeUnit.SECONDS.sleep(2);
    action.sendKeys(Keys.ARROW_DOWN).perform();
    TimeUnit.SECONDS.sleep(1);
    action.sendKeys(Keys.ARROW_DOWN).perform();
    TimeUnit.SECONDS.sleep(1);
    action.sendKeys(Keys.ARROW_DOWN).perform();
    TimeUnit.SECONDS.sleep(1);

    action.sendKeys(Keys.RETURN).perform();
  }

  @Test
  public void dragNDrop() {
    WebDriver driver = getDriver();
    driver.get("https://jqueryui.com/droppable/");

    driver.switchTo().frame(0);

    WebElement source = driver.findElement(By.id("draggable"));
    WebElement target = driver.findElement(By.id("droppable"));

    Actions action = new Actions(driver);

    //action.dragAndDrop(source, target).perform();
    action.clickAndHold(source).moveToElement(target).release(source).build().perform();
  }

  @Test
  public void resize() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://jqueryui.com/resizable/");

    driver.switchTo().frame(0);

    WebElement source = driver.findElement(By.cssSelector("div.ui-icon-gripsmall-diagonal-se"));

    Actions action = new Actions(driver);

    TimeUnit.SECONDS.sleep(2);

    action.clickAndHold(source).moveByOffset(30, 20).build().perform();
  }

  @Test
  public void slider() throws InterruptedException {
    WebDriver driver = getDriver();
    driver.get("https://jqueryui.com/slider/#colorpicker");

    driver.switchTo().frame(0);

    WebElement red = driver.findElement(By.cssSelector("div#red>span"));
    WebElement green = driver.findElement(By.cssSelector("div#green>span"));
    WebElement blue = driver.findElement(By.cssSelector("div#blue>span"));

    Actions action = new Actions(driver);

    action.clickAndHold(red).moveByOffset(-20, 0).release(red).build().perform();
    TimeUnit.SECONDS.sleep(1);
    action.clickAndHold(green).moveByOffset(20, 0).release(green).build().perform();
    TimeUnit.SECONDS.sleep(1);
    action.clickAndHold(blue).moveByOffset(10, 0).release(blue).build().perform();
  }

  @Test
  public void multiKeyOps() {
    WebDriver driver = getDriver();
    driver.get("https://jqueryui.com/selectable/");

    driver.switchTo().frame(0);

    WebElement first = driver.findElement(By.cssSelector("ol#selectable>li:nth-child(1)"));
    WebElement third = driver.findElement(By.cssSelector("ol#selectable>li:nth-child(3)"));
    WebElement fifth = driver.findElement(By.cssSelector("ol#selectable>li:nth-child(5)"));

    Actions action = new Actions(driver);

    action.keyDown(Keys.COMMAND).perform();
    action.click(first);
    action.click(third);
    action.click(fifth);
    action.keyUp(Keys.COMMAND).perform();
  }

}
