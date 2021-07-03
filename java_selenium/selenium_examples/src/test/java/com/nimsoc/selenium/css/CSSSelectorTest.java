package com.nimsoc.selenium.css;

import com.nimsoc.selenium.AbstractTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Cosminx
 */
@Test
public class CSSSelectorTest extends AbstractTest {

  @Test
  public void cssSelectors() throws Exception {
    
    WebDriver driver = getDriver();
    
    /*
    CSS Selector Using Attributes ****
    TagName[Att1=Value]
    In case Att1 is 'id' or 'class' then we can use following symbols:
    id => # (hash)
    class => . (dot)
    Examples: 1. div#u123   2. span.layerParent
    */
    driver.get("https://www.amazon.com/");
    driver.findElement(By.cssSelector("i.hm-icon")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.partialLinkText("Echo & Alexa")).click();
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.partialLinkText("Echo Dot")).click();
    TimeUnit.SECONDS.sleep(1);
    String title = driver.findElement(By.cssSelector("span#productTitle")).getText();
    System.out.println(title);
    if (title.contains("Echo Dot")) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }
    driver.close();

    /*
    Creating CSS Selectors for Dynamic Elements
    
    Using partial value of attribute (Symbol - *)
    Example: TagName[Att1*='Partial Value']
    
    Using starting value of attribute (Symbol ^)
    Example: TagName[Att1^='Starting Value']
    
    Using ending value of attribute (Symbol $)
    Example: TagName[Att1$='Ending Value']
    
    Creating CSS with Multiple Attributes
	
    ANDING the Attributes (No Symbol Required)
    Syntax: TagName[Att1=Value][Att2=Value]
    
    ORING the Attributes (',' will work as 'OR')
    Syntax: TagName[Att1=Value], TagName[Att2=Value]
    
    Advanced CSS Selectors
    Using only TagName and Attribute Name
    
    Node1,Node2 => Matches all Node1s and Node2s
    
    Node1 Node2 => Matches all Node2s which are descendant of Node1
    
    Node1>Node2 => Matches all Node2s which are children of Node1
    
    Node1+Node2 => Matches sibling Node2 placed immediately after Node1
    
    Node1~Node2 => Matches all sibling Node2s placed after Node1
    
    CSS using Node Child Numbering
    
    Node1:first-child
    => Selects all Node1s who are first child of their parent
    
    Node1:last-child
    => Selects all Node1s who are last child of their parent
    
    Node1:nth-child(n)
    => Selects all Node1s who are nth child of their parent
    */
    
    driver.quit();
  }
  
}
