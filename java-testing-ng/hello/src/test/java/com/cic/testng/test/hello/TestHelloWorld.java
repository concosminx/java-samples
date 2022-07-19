/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic.testng.test.hello;

import com.cic.testng.hello.RandomEmailGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author cosmin.i
 */
public class TestHelloWorld {

  @Test()
  public void testEmailGenerator() {

    RandomEmailGenerator obj = new RandomEmailGenerator();
    String email = obj.generate();

    Assert.assertNotNull(email);
    Assert.assertEquals(email, "feedback@yoursite.com1");

  }
}
