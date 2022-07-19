package com.nimsoc.selenium.xpath;

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
public class XPathSelectorsTest extends AbstractTest {

  @Test
  public void xpathSelectors() throws InterruptedException {
    WebDriver driver = getDriver();

    //A query language which is used to find a node or set of nodes in XML/HTML document
    //Relative XPath Using Node Attributes
    //Syntax: //ElementName[@Attribute Name="Attribute Value"]
    driver.get("https://www.facebook.com/r.php");
    TimeUnit.SECONDS.sleep(3);

    driver.findElement(By.xpath("//input[@aria-label='Prenume']")).sendKeys("john");

    driver.findElement(By.xpath("//input[@aria-label='Nume de familie']")).sendKeys("doe");

    //Relative XPath Using Text
    //Syntax: //ElementName[text()="Text"]
    driver.findElement(By.xpath("//label[contains(text(),'Feminin')]")).click();

    driver.quit();
  }

  /* Using 'and' Operator
       
      //ElementName[@Att1='Value1' and @Att2='Value2']   
      //ElementName[@Att='Value' and Text()='Value']
    
      Using 'or' Operator
    
      //ElementName[@Att1='Value1' or @Att2='Value2']
      //ElementName[@Att='Value' or Text()='Value']
    
      Using 'contains'
    
      //ElementName[contains(@Att,'Partial Value')]
      //ElementName[contains(text(),'Partial Value')]

      Using 'starts-with' 
       
      //ElementName[starts-with(@Att,'Starting Value')]
      //ElementName[starts-with(text(),'Starting Value')]
    
      Hybrid
    
      //ElementName[contains(@Att1,'Partial Value') and starts-with(text(),'Starting Value')]  
      //ElementName[@Att1='Value' or starts-with(@Att2,'Starting Value')]
      //*[@Att='Value']
    
      XPath Axes: Parent and Child Relation
       
      //Node1/child::*
      //Node1/parent::*
    
      XPath Axes: Ancestor and Descendant Relationship
      
      //Node1/ancestor::*
      //Node1/descendant::*
    
      XPath Axes: Preceding and Following
    
      //Node1/preceding::*
      //Node1/preceding-sibling::*
      //Node1/following::*
      //Node1/following-sibling::*
    
      Absolute XPath: Uses the complete path starting from root (/html) to desired element
      Syntax: /html/body/div[2]/div/...
      Combination of Relative and Absolute XPath
      Example: //span[@id='u123']/div[1]/a
    
      XPath Axes: Parent and Child Relation
      //Node1/child::*
      //Node1/parent::*
    
      XPath Axes: Ancestor and Descendant Relationship
      //Node1/ancestor::*
      //Node1/descendant::*
    
   */
}
