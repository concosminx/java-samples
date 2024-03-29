package demotest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

  public WebDriver driver;

  private final By signin = By.cssSelector("a[href*='sign_in']");
  private final By title = By.cssSelector(".text-center>h2");
  private final By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
  private final By header = By.cssSelector("div[class*='video-banner'] h3");

  public LandingPage(WebDriver driver) {
    this.driver = driver;
  }

  public LoginPage getLogin() {
    driver.findElement(signin).click();
    LoginPage lp = new LoginPage(driver);
    return lp;
  }

  public WebElement getNavigationBar() {
    return driver.findElement(NavBar);
  }

  public WebElement getTitle() {
    return driver.findElement(title);
  }

  public WebElement getHeader() {
    return driver.findElement(header);
  }
}
