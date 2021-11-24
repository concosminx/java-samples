package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class SelectTest extends AbstractTest {

//  @Test
//  public void select() {
//
//    WebDriver driver = getDriver();
//    
//    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//    
//    Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
//    
//    select.selectByIndex(2);
//
//    select.selectByVisibleText("Option3");
//    
//    driver.close();
//  }
  
}


/*
Working with Iframe and page content
IFrame Is another web element and you can not locate Its element directly In selenium webdriver. To work with IFrame element In selenium webdriver, first of all you need to select that IFrame using syntax like bellow.

//switch to frame1. frame1 Is ID of frame.
driver.switchTo().frame("frame1");

Now you can work with any element which Is Inside frame1. Now supposing you wants to switch back to page content then you need to use syntax like bellow.
//Switch back to page content.
driver.switchTo().defaultContent();

After above syntax execution, You can work with page elements.

Working with multiple frames on same page
If there are multiple Iframes on single page then you can not directly navigate from Iframe1 to IFrame2. For that, You need to select page In between as bellow.
//switch to frame1
driver.switchTo().frame("frame1");
driver.findElement(By.xpath("//td[contains(text(),'Cow')]/preceding-sibling::td/input[@type='checkbox']")).click();
  
//Switch back to page content.
driver.switchTo().defaultContent();
  
//switch to frame2
driver.switchTo().frame("frame2");
driver.findElement(By.xpath("//input[@value='Boat']")).click();
*/