package com.nimsoc.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {

  static {
    System.setProperty("webdriver.gecko.driver", "D:\\Projects\\GIT\\java-samples\\java_selenium\\webdriver_binaries\\geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", "D:\\Projects\\GIT\\java-samples\\java_selenium\\webdriver_binaries\\chromedriver.exe");
  }

  public static WebDriver getSeleniumDriver(DriverType type) {
    WebDriver driver = null;

    switch (type) {
      case CHROME:
        driver = new ChromeDriver();
        break;
      case FIREFOX:
        driver = new FirefoxDriver();
        break;
      default:
        throw new IllegalArgumentException("Driver type not implemented");
    }

    return driver;
  }

  public enum DriverType {
    CHROME,
    FIREFOX
  }

}
