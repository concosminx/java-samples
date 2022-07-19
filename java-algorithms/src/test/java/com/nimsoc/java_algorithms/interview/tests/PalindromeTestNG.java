
package com.nimsoc.java_algorithms.interview.tests;

import com.nimsoc.java_algorithms.interview.Palindrome;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PalindromeTestNG {
  
  @Test
  public void isPalindrom() {
    Assert.assertEquals(new Palindrome().palindrome("TENET"), true);
  }
  
  @Test
  public void isNotPalindrome() {
    Assert.assertEquals(new Palindrome().palindrome("BLEAH!"), false);
  }
  
  @Test
  public void testIgnoreCase() {
    Assert.assertEquals(new Palindrome().palindrome("Level"), true);
  }
  
  @Test
  public void testNull() {
    Assert.assertTrue(new Palindrome().palindrome(null));
  }
  
  @Test
  public void testEmpty() {
    Assert.assertEquals(new Palindrome().palindrome(""), true);
  }
  
}
