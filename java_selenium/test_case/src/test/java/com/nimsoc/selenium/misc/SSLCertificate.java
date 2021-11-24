package com.nimsoc.selenium.misc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

@Test
public class SSLCertificate {

  @Test
  public void createWebDriver() {
    //see http://learn-automation.com/handle-untrusted-certificate-selenium/

    //Desired capabilities=
    //general chrome profile
    //DesiredCapabilities ch = DesiredCapabilities.chrome();
    
    //ch.acceptInsecureCerts();
    //ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
    //ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

    //Belows to your local browser
//    ChromeOptions c = new ChromeOptions();
//    c.merge(ch);
//    System.setProperty("webdriver.chrome.driver", "local path");
//    WebDriver driver = new ChromeDriver(c);
//    driver.close();

  }

}
