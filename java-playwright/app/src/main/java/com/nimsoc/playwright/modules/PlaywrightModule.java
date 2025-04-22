package com.nimsoc.playwright.modules;

import com.google.inject.AbstractModule;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.nimsoc.playwright.providers.BrowserContextProvider;
import com.nimsoc.playwright.providers.BrowserProvider;
import com.nimsoc.playwright.providers.PlaywrightPageProvider;
import com.nimsoc.playwright.providers.PlaywrightProvider;


public class PlaywrightModule extends AbstractModule {

  @Override
  public void configure() {
    bind(Playwright.class).toProvider(PlaywrightProvider.class).asEagerSingleton();
    bind(Browser.class).toProvider(BrowserProvider.class).asEagerSingleton();
    bind(BrowserContext.class).toProvider(BrowserContextProvider.class).asEagerSingleton();
    bind(Page.class).toProvider(PlaywrightPageProvider.class).asEagerSingleton();
  }
}
