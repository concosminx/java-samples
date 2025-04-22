package com.nimsoc.playwright.components.inventory;

import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryList {

  private final Page page;

  public InventoryList(Page page) {
    this.page = page;
  }

  public List<String> getItemsInInventory() {
    return page.locator("[class='inventory_list'] [class='inventory_item_name']").allTextContents();
  }

  public Map<String, String> getItemsPrices(List<String> itemNames) {
    Map<String, String> itemsPrices = new HashMap<>();
    itemNames.forEach(
        item -> {
          var itemPrice = new InventoryItem(page, item).getItemPrice();
          itemsPrices.put(item, itemPrice);
        });

    return itemsPrices;
  }

  public void addItemsToCart(List<String> itemNames) {
    itemNames.forEach(itemName -> new InventoryItem(page, itemName).addToCart());
  }
}
