package javabasicprogramms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bootstrapdropdown {
	
	public static WebDriver driver ;
	String baseUrl = "https://semantic-ui.com/modules/dropdown.html";
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
	    System.setProperty("webdriver.chrome.driver", "\\drivers\\chromedriver.exe");
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
	

	@Test (priority = 1 , description = "bootstrap down features " , enabled = true)
	public void bootstrapdown() throws Exception 
	{
		
		driver.findElement(By.xpath("//div[@class='dropdown example']//div[@class='ui selection dropdown']")).click();
		Thread.sleep(3000);
		
//		driver.findElement(By.xpath("//ul[@class = 'dropdown-menu']/li[2]/label/input")).click();
//		Thread.sleep(2000);
		
		List<WebElement>alllinks = driver.findElements(By.xpath("//div[contains(@class ,'menu transition visible')]/div"));
		
		System.out.println ("all elements present " + alllinks.size());
		
		for (WebElement ele : alllinks ) {
			
			System.out.println (" element present :"+ ele.getText());
			
			if (ele.getText().contains("Male")) {
				
					ele.click();
					
					Thread.sleep(3000);
					
					break;
			}else {
			System.out.println ("Element Not found");		
				}
			        }
		                 }
		
	
	
	@AfterTest
	public void closebrowser() {
		
		driver.close();
	}
}
	
