package com.nimsoc.selenium.basics;

import com.nimsoc.selenium.AbstractTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class ScreenshotTest extends AbstractTest {

  @Test
  void newTest() throws Exception {
    WebDriver driver = getDriver();

    driver.manage().window().maximize();
    //driver.manage().deleteAllCookies();
    //	driver.manage().deleteCookieNamed("sessionKey");
    
    driver.get("http://google.com");
			
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	Files.copy(src.toPath(),new File("D:\\screenshot.png").toPath());
    driver.close();
  }

}
