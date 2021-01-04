/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic.testng.dependency;

/**
 *
 * @author cosmin.i
 */
import org.testng.annotations.Test;

public class App {

  @Test
  public void method1() {
    System.out.println("This is method 1");
    //throw new RuntimeException();
  }

  @Test(dependsOnMethods = {"method1"})
  public void method2() {
    System.out.println("This is method 2");
  }

}
