package com.nimsoc.playwright.components.cart;

import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItemsList {

  private final Page page;

  public CartItemsList(Page page) {
    this.page = page;
  }

  public List<String> getItemsInTheCart() {
    return page.locator("[class='cart_list'] [class='inventory_item_name']").allTextContents();
  }

  public Map<String, String> getItemsAndPrices() {
    var itemNames = getItemsInTheCart();
    Map<String, String> itemsPrices = new HashMap<>();
    itemNames.forEach(
        item -> {
          var itemPrice = new CartItem(page, item).getItemPrice();
          itemsPrices.put(item, itemPrice);
        });

    return itemsPrices;
  }
}
