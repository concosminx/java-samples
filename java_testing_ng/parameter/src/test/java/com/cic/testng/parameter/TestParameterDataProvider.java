/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cic.testng.parameter;

/**
 *
 * @author cosmin.i
 */
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterDataProvider {

	@Test(dataProvider = "provideNumbers")
	public void test(int number, int expected) {
		Assert.assertEquals(number + 10, expected);
	}

	@DataProvider(name = "provideNumbers")
	public Object[][] provideData() {

		return new Object[][] { 
			{ 10, 20 }, 
			{ 100, 110 }, 
			{ 200, 210 } 
		};
	}

}
