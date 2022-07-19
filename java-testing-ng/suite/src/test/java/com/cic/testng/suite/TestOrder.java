/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic.testng.suite;

/**
 *
 * @author cosmin.i
 */
import org.testng.annotations.Test;
 
public class TestOrder {
 
	@Test(groups={"orderBo", "save"})
	public void testMakeOrder() {  
	  System.out.println("testMakeOrder");
	}  
 
	@Test(groups={"orderBo", "save"})
	public void testMakeEmptyOrder() {  
	  System.out.println("testMakeEmptyOrder");
	}  
	
	@Test(groups="orderBo")
	public void testUpdateOrder() {  
		System.out.println("testUpdateOrder");
	}  
 
	@Test(groups="orderBo")
	public void testFindOrder() {  
		System.out.println("testFindOrder");
	}  
	
}
