package com.nimsoc.selenium.grid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Cosmin
 */
@Test
public class SeleniumGrid {
  /*
  Commands in Hub Machine
  
  1.Setting Up Hub:
  java -jar selenium-server-standalone-2.44.0.jar -role hub
  2.Validating Hub started 
  http://localhost:4444/grid/console
  
  Commands in Node Machine
  3.Accessing Hub from Node Machine
  http://iporhostnameofHub:4444/grid/console 
  4.Registering Node with Hub
  java –jar selenium-server-standalone-2.44.0.jar –role webdriver –hub http://iporhostnameofHub:4444/grid/register -port 5566
  */

  @Test void simpleTest() throws MalformedURLException {
    //Automated- chrome,firefox,ie,safari
    DesiredCapabilities dc= new DesiredCapabilities();
    dc.setBrowserName("chrome");
    dc.setPlatform(Platform.WINDOWS);
    WebDriver driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
    driver.get("http://rediff.com");
  }
}
