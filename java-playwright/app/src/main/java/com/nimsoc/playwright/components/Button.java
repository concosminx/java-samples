package com.nimsoc.playwright.components;

import com.microsoft.playwright.Page;

import java.util.function.Function;

public class Button extends Element {

  private static final Function<String, String> buttonSelector =
      (buttonText) -> String.format("button:has-text('%1$s')", buttonText);

  public Button(Page page, String buttonText) {
    super(page, buttonSelector.apply(buttonText));
  }

  public void click() {
    super.click(false);
  }

  public void click(boolean waitForNavigation) {
    super.click(waitForNavigation);
  }
}
