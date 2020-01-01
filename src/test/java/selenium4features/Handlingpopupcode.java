package selenium4features;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Handlingpopupcode {
	
	public static WebDriver driver ;
	//String baseUrl = "http://demo.guru99.com/test/delete_customer.php";
	
	String baseUrl = "http://demo.guru99.com/popup.php";
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
	    System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		//launching the url
		//add implicit wait 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)	;
		driver.get(baseUrl);
		
	}
	
	@Test (priority = 1 , description = "open the url and switch to another window" , enabled = true)
	public void openurlandlogin() throws Exception 
	{
		
		
		//handling alert types
//      WebElement custid = driver.findElement(By.xpath("//input[@name='cusid']")) ;
		
		//sending multiple string as parameter 
//		custid.sendKeys("3562","8956");
//		
//		WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
//		submit.click();
//		
//		Alert alert = driver.switchTo().alert();
//		
//		String alerttext = alert.getText();
//		
//		System.out.println ("alert message text :" + alerttext);
//		
//		alert.accept();
		
		
		WebElement clickhere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		
		clickhere.click();
		
		//Main window handle 
		String mainwindow = driver.getWindowHandle();
		
		Set<String> allwindows = driver.getWindowHandles();
		
		Iterator<String> allitems = allwindows.iterator();
		
		while (allitems.hasNext()) {
			
			String childwindow = allitems.next();
			
			if(!mainwindow.equalsIgnoreCase(childwindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(childwindow);	                                                                                                           
                    driver.findElement(By.name("emailid"))
                    .sendKeys("gaurav.3n@gmail.com");                			
                    
                    driver.findElement(By.name("btnLogin")).click();			
                                 
			// Closing the Child Window.
                        driver.close();		
            }		
			
			
		}
		
		driver.switchTo().window(mainwindow);
		
		//open new window 
		
		
		
		
		

}

	@AfterTest
	public void closebrowser() {
		
		driver.close();
	}
	
}