package com.nimsoc.playwright.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.time.Duration;
import java.util.Objects;

public class TextBox extends Element {

  public TextBox(Page page, String selector) {
    super(page, selector);
  }

  public void setText(String value) {
    setText(value, false);
  }

  public void setText(String value, boolean append) {
    if (!append) clearText();
    getLocator().fill(value);
  }

  public void type(String value, boolean append, Duration delayBetweenKeyPress) {
    if (!append) clearText();
    var options = new Locator.TypeOptions().setDelay(delayBetweenKeyPress.toMillis());
    getLocator().type(value, options);
  }

  public void clearText() {
    getLocator().selectText();
    getLocator().press("Delete");
  }

  public String inputValue() {
    return Objects.nonNull(getLocator().inputValue()) ? getLocator().inputValue() : getText();
  }

  public void pressKey(String key) {
    getLocator().press(key);
  }
}
