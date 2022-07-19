package com.mkyong.testng.examples.dependency;

import org.testng.annotations.Test;

public class TestApp {

	@Test(dependsOnGroups={"deploy","db"})
	public void method1() {
		System.out.println("This is method 1");
		//throw new RuntimeException();
	}

	@Test(dependsOnMethods = { "method1" })
	public void method2() {
		System.out.println("This is method 2");
	}

}