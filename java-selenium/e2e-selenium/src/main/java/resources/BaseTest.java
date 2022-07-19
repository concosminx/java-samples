package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

  public Properties prop;

  public WebDriver initializeDriver() throws IOException {
    WebDriver driver = null;
  
    prop = new Properties();
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
    prop.load(fis);
    
    String browserName = prop.getProperty("browser");
    System.out.println(browserName);

    if (browserName.contains("chrome")) {
      System.setProperty("webdriver.chrome.driver", "D:\\Projects\\GIT\\java-samples\\java_selenium\\webdriver-binaries\\chromedriver.exe");
      ChromeOptions options = new ChromeOptions();
      if (browserName.contains("headless")) {
        options.addArguments("headless");
      }
      driver = new ChromeDriver(options);
    } else if (browserName.equals("firefox")) {
      System.setProperty("webdriver.gecko.driver", "D:\\Projects\\GIT\\java-samples\\java_selenium\\webdriver-binaries\\geckodriver.exe");
      driver = new FirefoxDriver();
    } 

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
  }

  public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
    FileUtils.copyFile(source, new File(destinationFile));
    return destinationFile;
  }
}
