package com.demomavenprojectpractice.com.demomavenpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import functionlibrary.Reusablefunctionss;

public class TestDataProvider {
	
	static WebDriver driver ;
	
	static String url = "http://newtours.demoaut.com/mercurywelcome.php" ;
	
	@BeforeTest
	public void setup () {
	
	System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");	
	driver = new ChromeDriver() ;
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void logincredentials () throws Exception {
		
	String filePath = "F:\\TestData\\LoginCredentials01.xlsx" ;
	
	String username = Reusablefunctionss.getData(filePath, 1, 1, 0);
	String password = Reusablefunctionss.getData(filePath, 1, 1, 1);
	
	System.out.println ("Username provided :" + username);
	System.out.println ("Password provided :" + password);
	
	WebElement User = driver.findElement(By.xpath("//input[@name='userName']"));
	User.sendKeys(username);
	
	WebElement Password = driver.findElement(By.xpath("//input[@name='password']")) ;
	Password.sendKeys(password);
	
	WebElement Login = driver.findElement(By.xpath("//input[@name='login']"));
	Login.click();
	
	Thread.sleep(5000);
	
	Reusablefunctionss.capturescreenshot(driver, "Login Captured");
			
	}
	
	
	@Test(dependsOnMethods = "logincredentials" , description = "TestNGDataProviders" , dataProvider = "getData")
	public void traveldetails (String DepartFrom ,String ArrivingIn , int ArrivingOn ,String AirlinesRef ) {
		
		WebElement OneWay = driver.findElement(By.xpath("//input[@value = 'oneway']"));
		if (OneWay.isDisplayed()) {
		OneWay.click();	
		}
		
		WebElement DepartingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select oselect = new Select (DepartingFrom);
		oselect.selectByValue(DepartFrom);
		
		WebElement ArrivingCity = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select oArrvIn = new Select(ArrivingCity);
		oArrvIn.selectByValue(ArrivingIn);
		
		WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
		Select ToDay  = new  Select(toDay);
		ToDay.selectByIndex(ArrivingOn);
		
		Reusablefunctionss.capturescreenshot(driver, "Travel Details filled ");
    	
		}
	
	@Test(dependsOnMethods = "traveldetails" , description = "logout")
	public void logout () {
		
		WebElement continuebutton = driver.findElement(By.xpath("//input[@name='findFlights']"));
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		
		js.executeScript("arguments[0].click", continuebutton);
		
		WebElement SignOff = driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]"));
		SignOff.click();
	}
	
	
	@AfterTest
	public void teardown() {
		
	driver.close();	
	}

}
