package com.nimsoc.selenium.lib;

import com.nimsoc.selenium.pages.Ebay_Advanced_Search_Page;
import com.nimsoc.selenium.pages.Ebay_Home_Page;
import com.nimsoc.selenium.pages.Ebay_Search_Results_Page;
import org.openqa.selenium.WebDriver;

public class PageLib {

  private WebDriver driver;
  private Ebay_Home_Page homePage;
  private Ebay_Advanced_Search_Page advSearchPage;
  private Ebay_Search_Results_Page srcResultPage;

  public PageLib(WebDriver driver) {
    this.driver = driver;
    homePage = new Ebay_Home_Page(this.driver);
    advSearchPage = new Ebay_Advanced_Search_Page(this.driver);
    srcResultPage = new Ebay_Search_Results_Page(this.driver);
  }

  public Ebay_Home_Page HomePage() {
    return homePage;
  }

  public Ebay_Advanced_Search_Page AdvancedSearchPage() {
    return advSearchPage;
  }

  public Ebay_Search_Results_Page SearchResultsPage() {
    return srcResultPage;
  }

}
