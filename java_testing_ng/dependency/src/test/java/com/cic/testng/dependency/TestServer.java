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

//all methods of this class are belong to "deploy" group.
@Test(groups="deploy")
public class TestServer {

	@Test
	public void deployServer() {
		System.out.println("Deploying Server...");
	}

	//Run this if deployServer() is passed.
	@Test(dependsOnMethods="deployServer")
	public void deployBackUpServer() {
		System.out.println("Deploying Backup Server...");
	}
	
}
