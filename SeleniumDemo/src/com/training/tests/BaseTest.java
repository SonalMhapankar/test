package com.training.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("menthod - before class");
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\lenovo\\Desktop\\IDE Test Cases\\sw\\chromedriver.exe");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("menthod - after class");

	}

}
