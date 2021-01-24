package com.demomavenprojectpractice.com.demomavenpractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGPractice {
	
	
  @BeforeMethod 
  public void beforemethod () {
	  
	  System.out.println("Before Method ");
  }
  
  @AfterMethod
  public void aftermethod () {
	  
	  System.out.println("After  Method ");
	  
  }
  
  @BeforeClass
  public void beforeclass () {
	  
	  System.out.println("Before Class ");
	  
  }
  
  @AfterClass
  public void afterclass () {
	  
	  System.out.println("AfterClass");
	  
  }
  
  @BeforeTest 
  public void beforetest () {
	  
	  System.out.println("Before Test ");
	  
  }
  
  @AfterTest
  public void aftertest () {
	 
	  System.out.println("After Test ");
	  	  
  }
  
  @Test (priority = 0 , description = "Oth priority testng")
  public void testngclass () {
	  
	  System.out.println ("0th priority testing ");
  }
  
  @Test (priority = 1 , description = "1st priority testng")
  public void testngclassOne () {
	  
	  System.out.println ("1st priority testing ");
  }
  
  @BeforeSuite(description = "beforesuite " )
  public void beforesuite () {
	  
	  System.out.println("Before Suite");  
	  
  }
  
  @AfterSuite(description = "aftertestsuite")
  public void aftersuite () {
	  
	  System.out.println("After Suite");
	  
  }
  
  String assertionString="demoforHardAssertion";
  @Test
  public void test2()
   {
      //Soft assert Object
  	
      SoftAssert softAssert=new SoftAssert();
  	softAssert.assertEquals("demoforHardAssertions", assertionString);
  	
      System.out.println("After Assert equals");
  	
      softAssert.assertTrue(assertionString.equals("demoforHardAssertions"));
      System.out.println("After Assert true");
  	
      }
  
}
