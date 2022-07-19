package com.nimsoc.selenium;

import org.openqa.selenium.WebDriver;

public abstract class AbstractTest {

  protected WebDriver getDriver() {
    return DriverProvider.getSeleniumDriver(DriverProvider.DriverType.CHROME);
  }

}
