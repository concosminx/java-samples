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

public class ValidateTitle extends BaseTest {

  public WebDriver driver;
  LandingPage l;
  public static Logger log = LogManager.getLogger(BaseTest.class.getName());

  @BeforeTest
  public void initialize() throws IOException {

    driver = initializeDriver();
    log.info("Driver is initialized");

    driver.get(prop.getProperty("url"));
    log.info("Navigated to Home page");
  }

  @Test

  public void validateAppTitle() throws IOException {
    l = new LandingPage(driver);
    //Error..
    Assert.assertEquals(l.getTitle().getText(), "FEATURED CO123URSES");
    log.info("Successfully validated Text message");
    System.out.println("Test completed");
  }

  @Test
  public void validateHeader() throws IOException {
    System.out.println("am i going inside it");
    Assert.assertEquals(l.getHeader().getText(), "An Academy to learn Everything about Testing");
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
