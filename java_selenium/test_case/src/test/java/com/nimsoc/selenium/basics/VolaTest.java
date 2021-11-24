package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class VolaTest extends AbstractTest {

  @Test
  void selectNew() throws InterruptedException {
    WebDriver driver = getDriver();

    driver.get("https://www.vola.ro/");
    TimeUnit.SECONDS.sleep(2);
    WebElement e1 = driver.findElement(By.xpath("//span[@class='fix-ch-home']/input"));
    //e1.clear();
    e1.click();
    e1.sendKeys("Otopeni");

    TimeUnit.SECONDS.sleep(1);
    WebElement e2 = driver.findElement(By.xpath("//strong[contains(text(),'Otopeni')]"));
    
    //e2.sendKeys("DEL");
    //e2.sendKeys(Keys.ARROW_DOWN);
	//e2.sendKeys(Keys.ENTER);
    
    e2.click();

    driver.close();
  }

}
