package com.nimsoc.selenium.pages;

import com.nimsoc.selenium.elements.Ebay_Home_Page_Elements;
import org.openqa.selenium.WebDriver;


public class Ebay_Home_Page {

  String pageUrl = "https://www.ebay.com/";
  WebDriver driver;
  Ebay_Home_Page_Elements hopmePageElements;

  public Ebay_Home_Page(WebDriver driver) {
    this.driver = driver;
    hopmePageElements = new Ebay_Home_Page_Elements(driver);
  }

  /**
   * Click on search button
   */
  public void clickSearchButton() {
    hopmePageElements.searchBtn.click();
  }

  /**
   * Is Search button enabled
   */
  public boolean isSearchButtonEnabled() {
    return hopmePageElements.searchBtn.isEnabled();
  }

  /**
   * Get Page Url
   */
  public String getPageUrl() {
    return pageUrl;
  }

}
