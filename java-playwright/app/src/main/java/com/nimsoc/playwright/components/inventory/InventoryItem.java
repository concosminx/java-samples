package com.nimsoc.playwright.components.inventory;

import com.microsoft.playwright.Page;
import com.nimsoc.playwright.components.Element;


import java.util.function.Function;

public class InventoryItem {

  private final Function<String, String> buildSelector =
      (itemTitle) -> String.format("[class*='inventory_item']:has-text('%s')", itemTitle);

  private final String addToCartSelector = "button:has-text('Add to cart')";

  private final String selector;
  private final Page page;

  public InventoryItem(Page page, String itemTitle) {
    this.page = page;
    this.selector = buildSelector.apply(itemTitle);
  }

  public String getItemPrice() {
    return new Element(page, selector)
        //
        .getLocator()
        .locator(".inventory_item_price")
        .textContent();
  }

  public void addToCart() {
    var inventoryItem = new Element(page, selector).getLocator();
    var addToCartButton = inventoryItem.locator(addToCartSelector);
    addToCartButton.click();
  }
}
