package com.mkyong.testng.examples.parameter;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

		return new Object[][] { { 10, 20 }, { 100, 110 }, { 200, 210 } };
	}

	@Test(dataProvider = "dbconfig")
	public void testConnection(Map<String, String> map) {

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
		}

	}

	@DataProvider(name = "dbconfig")
	public Object[][] provideDbConfig() {

		Map<String, String> map = readDbConfig();

		return new Object[][] { { map } };
	}

	public Map<String, String> readDbConfig() {

		Properties prop = new Properties();
		InputStream input = null;
		Map<String, String> map = new HashMap<String, String>();

		try {
			input = getClass().getClassLoader().getResourceAsStream("db.properties");

			prop.load(input);

			map.put("jdbc.driver", prop.getProperty("jdbc.driver"));
			map.put("jdbc.url", prop.getProperty("jdbc.url"));
			map.put("jdbc.username", prop.getProperty("jdbc.username"));
			map.put("jdbc.password", prop.getProperty("jdbc.password"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return map;

	}
	
}