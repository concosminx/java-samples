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

public class TestDatabase {

	//belong to "db" group, 
  //Run if all methods from "deploy" group are passed.
  @Test(groups = "db", dependsOnGroups = "deploy")
  public void initDB() {
    System.out.println("This is initDB()");
  }

	//belong to "db" group,
  //Run if "initDB" method is passed.
  @Test(dependsOnMethods = {"initDB"}, groups = "db")
  public void testConnection() {
    System.out.println("This is testConnection()");
  }

}
