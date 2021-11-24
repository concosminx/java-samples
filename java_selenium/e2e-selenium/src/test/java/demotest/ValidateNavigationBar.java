package demotest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demotest.pageobjects.LandingPage;
import org.testng.annotations.AfterClass;
import resources.BaseTest;

public class ValidateNavigationBar extends BaseTest {

  public WebDriver driver;

  public static Logger log = LogManager.getLogger(BaseTest.class.getName());

  @BeforeTest
  public void initialize() throws IOException {
    driver = initializeDriver();
    driver.get(prop.getProperty("url"));
  }

  @Test
  public void validateAppNavBar() throws IOException {
    LandingPage l = new LandingPage(driver);
    Assert.assertTrue(l.getNavigationBar().isDisplayed());
    log.info("Navigation Bar is displayed");
    System.out.println("Test completed");
  }

  @AfterTest
  public void teardown() {
    //driver.close();
  }
  
  @AfterClass
  public void quitDriver() {
    driver.quit();
  }
}
