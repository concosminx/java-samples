package demotest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demotest.pageobjects.ForgotPassword;
import demotest.pageobjects.LandingPage;
import demotest.pageobjects.LoginPage;
import org.testng.annotations.AfterClass;
import resources.BaseTest;

public class HomePage extends BaseTest {

  public WebDriver driver;

  public static Logger log = LogManager.getLogger(BaseTest.class.getName());

  @BeforeTest
  public void initialize() throws IOException {
    driver = initializeDriver();
  }

  @Test(dataProvider = "getData")
  public void basePageNavigation(String Username, String Password, String text) throws IOException {
    driver.get(prop.getProperty("url"));
    LandingPage l = new LandingPage(driver);
    LoginPage lp = l.getLogin(); 
    lp.getEmail().sendKeys(Username);
    lp.getPassword().sendKeys(Password);

    log.info(text);

    lp.getLogin().click();
    ForgotPassword fp = lp.forgotPassword();
    fp.getEmail().sendKeys("xxx");
    fp.sendMeInstructions().click();

  }

  @AfterTest
  public void teardown() {
    //driver.close();
  }

  @DataProvider
  public Object[][] getData() {
    Object[][] data = new Object[2][3];
    //0th row
    data[0][0] = "nonrestricteduser@qw.com";
    data[0][1] = "123456";
    data[0][2] = "Restricted User";
    //1st row
    data[1][0] = "restricteduser@qw.com";
    data[1][1] = "456788";
    data[1][2] = "Non restricted user";
    return data;
  }
  
  @AfterClass
  public void quitDriver() {
    driver.quit();
  }

}
