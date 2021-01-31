package com.nimsoc.java_algorithms.interview;


/*
  A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward, 
  such as madam or racecar. 
*/
public class Palindrome {
  public static boolean palindrome(String s) {
    if (s == null || s.length() <= 1) {
      return true;
    }
    
    /*ignore case*/
    s = s.toUpperCase();
    
    int i = 0;
    int j = s.length() - 1;
    int k = (i + j) / 2;

    for (int index = i; index <= k; index++) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        return false;
      }
    }
    return true;
  }
}
