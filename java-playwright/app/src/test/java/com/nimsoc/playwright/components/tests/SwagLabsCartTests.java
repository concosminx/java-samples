package com.nimsoc.playwright.components.tests;

import com.nimsoc.playwright.components.pages.CartPage;
import com.nimsoc.playwright.components.pages.LoginPage;
import com.nimsoc.playwright.components.pages.ProductsPage;
import com.nimsoc.playwright.testbases.WebTest;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class SwagLabsCartTests extends WebTest {

  @Test
  public void shouldValidateAddingItemsToCart()  {
    var items = List.of("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt");

    var pricesOfAddedCartItems =
        webPageInstance(LoginPage.class)
            .login("standard_user", "secret_sauce", ProductsPage.class)
            .addItemsToCart(items)
            .getItemPrices(items);

    var cartItemsAndPrices =
        webPageInstance(CartPage.class)
            //
            .navigateToCart()
            .getItemsInTheCartAndTheirPrices();

    Assertions.assertThat(cartItemsAndPrices)
        .usingRecursiveComparison()
        .isEqualTo(pricesOfAddedCartItems);
  }
}