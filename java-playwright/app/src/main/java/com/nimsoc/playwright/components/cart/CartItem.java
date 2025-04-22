package com.nimsoc.playwright.components.cart;

import com.microsoft.playwright.Page;
import com.nimsoc.playwright.components.Element;

import java.util.function.Function;

public class CartItem {

  private final Function<String, String> buildSelector =
      (itemName) -> String.format("[class*='cart_item']:has-text('%s')", itemName);

  private final Page page;
  private final String selector;

  public CartItem(Page page, String itemName) {
    this.page = page;
    this.selector = buildSelector.apply(itemName);
  }

  public String getItemPrice() {
    return new Element(page, selector)
        //
        .getLocator()
        .locator(".inventory_item_price")
        .textContent();
  }

  public void removeFromCart() {
    new Element(page, selector)
        //
        .getLocator()
        .locator("button:has-text('Remove')")
        .click();
  }
}
