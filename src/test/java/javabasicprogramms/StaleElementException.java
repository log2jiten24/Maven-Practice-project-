package javabasicprogramms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaleElementException {
	
	
	public static WebDriver driver ;
	String baseUrl = "https://classic.freecrm.com/login.cfm";
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
	    System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
	    //WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		
		//delete all  cookies
		driver.manage().deleteAllCookies();
		//launching the url
		//add implicit wait 
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)	;
	    //add page load timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}
	

	@Test (priority = 1 , description = "stale element features " , enabled = true)
	public void staleElement() throws Exception 
	{
		
	WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
	
	username.sendKeys("log2jeet24@gmail.com");
	
    WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
	
    password.sendKeys("jeet47900");
    
    driver.navigate().refresh();
    Thread.sleep(3000);
    
    try {
    	
    username.sendKeys("log2jeet240@gmail.com");
    Thread.sleep(5000);
    password.sendKeys("jeet47900");
    Thread.sleep(5000);
    
    }catch (StaleElementReferenceException e) {
    
    //again we need to identify the same elements 
    username = 	driver.findElement(By.xpath("//input[@name = 'username']"));
    username.sendKeys("log2jeet240@gmail.com");
    
    password = driver.findElement(By.xpath("//input[@name = 'password']"));
	password.sendKeys("jeet47900");
    	
     }
	      }	
	
	@AfterTest (description = "close the browser" , enabled = true )

	public void closebrowser() {
		
	driver.close();	
	}
	

}
