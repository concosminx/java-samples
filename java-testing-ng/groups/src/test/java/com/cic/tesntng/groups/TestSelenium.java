/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic.tesntng.groups;

/**
 *
 * @author cosmin.i
 */
import org.testng.annotations.Test;

@Test(groups= "selenium-test")
public class TestSelenium {

	public void runSelenium() {
		System.out.println("runSelenium()");
	}

	public void runSelenium1() {
		System.out.println("runSelenium()1");
	}
	
}