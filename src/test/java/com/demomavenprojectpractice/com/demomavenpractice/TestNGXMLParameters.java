package com.demomavenprojectpractice.com.demomavenpractice;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import functionlibrary.Reusablefunctionss;

public class TestNGXMLParameters {
	
static final Logger logger = Logger.getLogger(Testngpracticee.class);
	
    static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	 
	
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
	
	@Test (priority = 2 ,description = "search of testing ")
	@Parameters({"username", "password"}) 
	public void clickurl (String username , String password)  {
	//type the keyword
		
		
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
	
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	logger.info("Input Entered");
	//implicit wait 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//capturescreenshot
	Reusablefunctionss.capturescreenshot(driver, "Testing text typed");
	System.out.println ("Screenshot captured while typing testing");
	}
	
	 
	@AfterTest
	 public void close () {
		   

		//close the browser 
		driver.quit();	   
		   
	   }
	
	
	
}
