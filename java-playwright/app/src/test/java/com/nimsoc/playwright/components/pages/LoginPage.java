package com.nimsoc.playwright.components.pages;

import com.microsoft.playwright.Page;
import com.nimsoc.playwright.testbases.WebPage;

public class LoginPage extends WebPage {

  private final String userNameSelector = "#user-name";
  private final String passwordSelector = "#password";
  private final String loginButtonSelector = "#login-button";

  public LoginPage(Page page) {
    super(page);
  }

  public <T extends WebPage> T login(String userName, String password, Class<T> nextPage) {
    textBox(userNameSelector).setText(userName);
    textBox(passwordSelector).setText(password);
    element(loginButtonSelector).click(true);
    return createWebPageInstance(nextPage);
  }

  public String getErrorMessage() {
    return element("[data-test='error']").getText();
  }
}
