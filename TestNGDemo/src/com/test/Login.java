package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Login {
  @Test
  public void f() {
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("after method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("after method");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after method");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("after method");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after method");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("after method");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after method");
  }

}
