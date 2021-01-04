package com.mkyong.testng.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mkyong.testng.project.service.email.EmailGenerator;

@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class TestSpring extends AbstractTestNGSpringContextTests {

	@Autowired
	EmailGenerator emailGenerator;

	@Test()
	void testEmailGenerator() {

		String email = emailGenerator.generate();
		System.out.println(email);

		Assert.assertNotNull(email);
		Assert.assertEquals(email, "feedback@yoursite.com");
		

	}

}