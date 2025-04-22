package com.nimsoc.playwright.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.awaitility.Awaitility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementCollection {
  private final String selector;
  private final Page page;

  public ElementCollection(Page page, String selector) {
    this.selector = selector;
    this.page = page;
  }

  public List<String> getTextContents() {
    return new ArrayList<>(getLocator().allTextContents());
  }

  public List<String> getAttributeValues(String attribute) {
    var locator = getLocator();
    var count = locator.count();

    List<String> attributeValues = new ArrayList<>();

    for (int counter = 0; counter < count; counter++) {
      var attributeValue = locator.nth(counter).getAttribute(attribute);
      attributeValues.add(attributeValue);
    }

    return attributeValues;
  }

  public <T> List<T> getElements(Class<T> tClass) {
    try {
      var locator = getLocator();
      List<T> elementCollection = new ArrayList<>();

      int count = locator.count();
      for (int counter = 0; counter < count; counter++) {
        var elementSelector =
            selector.startsWith("xpath=") || selector.startsWith("//")
                ? String.format("(%s)[%s])", selector, counter + 1)
                : String.format("%s >> nth=%s", selector, counter);

        T element =
            tClass
                .getDeclaredConstructor(Page.class, String.class)
                .newInstance(page, elementSelector);
        elementCollection.add(element);
      }
      return elementCollection;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public int count() {
    return getLocator().count();
  }

  public void waitUntilPresent(Duration duration) {
    Awaitility.await().ignoreExceptions().atMost(duration).until(() -> getLocator().count() > 0);
  }

  protected Locator getLocator() {
    return page.locator(selector);
  }
}