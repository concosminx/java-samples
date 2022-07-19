package com.mkyong.testng.examples.timeout;

import org.testng.annotations.Test;

public class TestTimeout {

	@Test(timeOut = 2000)
	public void testThisShouldPass() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test(timeOut = 1000, enabled=false)
	public void testThisShouldFail() {
		while (true);
	}

}