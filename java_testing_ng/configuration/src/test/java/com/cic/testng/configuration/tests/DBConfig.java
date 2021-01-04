/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic.testng.configuration.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 *
 * @author cosmin.i
 */
public class DBConfig {

  @BeforeSuite()
  public void beforeSuite() {
    System.out.println("@BeforeSuite");
  }

  @AfterSuite()
  public void afterSuite() {
    System.out.println("@AfterSuite");
  }

  @BeforeTest()
  public void beforeTest() {
    System.out.println("@BeforeTest");
  }

  @AfterTest()
  public void afterTest() {
    System.out.println("@AfterTest");
  }

}
