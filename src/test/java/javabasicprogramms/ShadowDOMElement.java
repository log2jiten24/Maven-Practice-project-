package javabasicprogramms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShadowDOMElement {
	
	
	public static WebDriver driver ;
	String baseUrl = "http://sandbox-sponsors.pointsville.com/";
	
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
	

	@Test (priority = 1 , description = "shadow dom elements " , enabled = true)
	public void bootstrapdown() throws Exception 
	{
	
	 Thread.sleep(5000);	
	 JavascriptExecutor js = (JavascriptExecutor)driver ;
     WebElement user_name = (WebElement) js.executeScript("return document.querySelector('amplify-authenticator >amplify-sign-in').shadowRoot.querySelector('amplify-form-section >amplify-auth-fields').shadowRoot.querySelector('div>amplify-username-field').shadowRoot.querySelector('amplify-form-field').shadowRoot.querySelector('input')");
     WebElement password  = (WebElement) js.executeScript("return document.querySelector(\" amplify-authenticator > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\").shadowRoot.querySelector(\"div > amplify-password-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#password\")");     
     WebElement rest_pwd  = (WebElement) js.executeScript("return document.querySelector(\"amplify-authenticator > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\").shadowRoot.querySelector(\"div > amplify-password-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#password-hint > div > amplify-button\")");
     
     
     //code to enter the value inside the text box 
     String js_enter = "arguments[0].setAttribute('value','log2jeet24@gmail.com')";
     
     //to enter the value and execute the javascript 
     ((JavascriptExecutor)driver).executeScript(js_enter, user_name);
     ((JavascriptExecutor)driver).executeScript(js_enter, password);
     ((JavascriptExecutor)driver).executeScript("arguments[0].click();", rest_pwd);
     
     Thread.sleep(5000);	
	
	}

	@AfterTest
	public void closebrowser() {
		
		driver.close();
	}
	
}