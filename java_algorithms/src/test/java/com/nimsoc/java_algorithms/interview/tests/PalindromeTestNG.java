
package com.nimsoc.java_algorithms.interview.tests;

import com.nimsoc.java_algorithms.interview.Palindrome;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PalindromeTestNG {
  
  @Test
  public void isPalindrom() {
    Assert.assertEquals(Palindrome.palindrome("TENET"), true);
  }
  
  @Test
  public void isNotPalindrome() {
    Assert.assertEquals(Palindrome.palindrome("BLEAH!"), false);
  }
  
  @Test
  public void testIgnoreCase() {
    Assert.assertEquals(Palindrome.palindrome("Level"), true);
  }
  
}
