package com.mkyong.testng.examples.dependency;

import org.testng.annotations.Test;

public class TestDatabase {

	@Test(groups="db", dependsOnGroups="deploy")
	public void initDB() {
		System.out.println("This is initDB()");
	}

	@Test(dependsOnMethods = { "initDB" }, groups="db")
	public void testConnection() {
		System.out.println("This is testConnection()");
	}

}