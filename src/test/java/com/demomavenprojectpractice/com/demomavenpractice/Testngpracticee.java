package com.demomavenprojectpractice.com.demomavenpractice;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import functionlibrary.*;



public class Testngpracticee {
	
	static final Logger logger = Logger.getLogger(Testngpracticee.class);
	
    static WebDriver driver ;
	String baseUrl = "https://www.google.co.in/";
	
	 
	
	@BeforeTest ( description = "launching of browser")
	public void launchbrowser () {
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 	
		
	}
	
	@Test (priority = 1 , description = "open the url" , enabled = true)
	public void openurl() throws Exception 
	{
	//launching the url	
	driver.get(baseUrl);	
	
	logger.info("URL Launched successfully");
    //take the screenshot of url opened
	Reusablefunctionss.capturescreenshot(driver, "Googlepageopened");
	
	System.out.println ("Screenshot captured while opening google page");
	
	}
	
	@Test (priority = 2 ,description = "search of testing ",enabled = true,dependsOnMethods= "openurl")
	public void clickurl () {
	//type the keyword
	driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Testing"); 
	
	logger.info("Input Entered");
	//implicit wait 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//capturescreenshot
	Reusablefunctionss.capturescreenshot(driver, "Testing text typed");
	System.out.println ("Screenshot captured while typing testing");
	}
	
   @Test (priority = 3 , description = "click on testing definition", enabled = true)
    public void clickontesting () {
	   
//   List <WebElement> allelements = driver.findElements(By.xpath("//b"))	 ;  
//   //iterate through each element and click on testing definition 
//   for (WebElement items : allelements) {
//  
//   if (allelements.toString().equalsIgnoreCase("testing definition"))
//   {
//	   items.click();
//	   //takescreenshot for the testing definition to be clicked
    driver.findElement(By.xpath("//b[contains(text(),'jobs in pun')]")).click();
    
    logger.info("Input value clicked ");
    Reusablefunctionss.capturescreenshot(driver, "click done successfully");
    
	System.out.println ("Screenshot captured while typing testing");   
   }
       
   @AfterTest
 //  public void close (ITest result) {
   
   public void close () {
	   
//	  if (ITestResult.FAILURE == result.getTestName())
//	  {
//		  
//	  }
	   
	//close the browser 
	driver.quit();	   
	   
   }
}
