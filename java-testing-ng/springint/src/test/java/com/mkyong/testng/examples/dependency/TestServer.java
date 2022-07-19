package com.mkyong.testng.examples.dependency;

import org.testng.annotations.Test;

@Test(groups="deploy")
public class TestServer {

	@Test
	public void deployServer() {
		System.out.println("Deploying Server...");
	}

	@Test(dependsOnMethods="deployServer")
	public void deployBackUpServer() {
		System.out.println("Deploying Backup Server...");
	}
	
}