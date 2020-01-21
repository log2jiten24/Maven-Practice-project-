package javabasicprogramms;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bootsrapexample {

	
	public static WebDriver driver ;
	String baseUrl = "https://accounts.google.com/signup/v2/webcreateaccount?service=accountsettings&continue=https%3A%2F%2Fmyaccount.google.com%2F%3Futm_source%3Dsign_in_no_continue%26pli%3D1&dsh=S-637462234%3A1578753757020912&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp";
	
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
		
		//click on dropwdown 
		
		driver.findElement(By.xpath("//div[@class='MocG8c B9IrJb LMgvRb KKjvXb']")).click();
		Thread.sleep(3000);
		
		List<WebElement> alllinks = driver.findElements(By.xpath("//div[@class='MocG8c B9IrJb LMgvRb']/span"));
		System.out.println ("all elements present " + alllinks.size());
		
//		for (WebElement ele : alllinks ) {
//			
//			System.out.println (" element present :"+ ele.getText());
//			
//			if (ele.getText().contains("‪Español (España)‬")) {
//				
//					ele.click();
//					
//					Thread.sleep(3000);
//					
//					break;
//			}else {
//			System.out.println ("Element Not found");		
//				}
//			        }
		//$x("//span[@class='vRMGwf oJeWuf']")[11]
		for (int i = 0 ; i <alllinks.size() ; i ++ ) {
//			
//		  System.out.println ("all elements :" + alllinks.get(i).getText());
			String xPathLng ="//div[@class='MocG8c B9IrJb LMgvRb']/span])"+"["+  i +  "]";
					

					
		  WebElement alllink = driver.findElement(By.xpath(xPathLng));
		  alllink.click();
		}
//			
//		  if (alllinks.size() == 138) {
//			  
//			  alllinks.get(i).click();
//		  }else {
//				System.out.println ("Element Not found");
//			}
//		
//		}	
		
//		Iterator<WebElement> itr = alllinks.iterator() ;
//		
//		while (itr.hasNext()) {
//			
//			System.out.println ("all links present " + itr.next());
//			
//			if (itr.next().getText().equalsIgnoreCase("‪Español (España)‬")) {
//				
//				itr.next().click();
//				
//				Thread.sleep(2000);
//				
//				break ;
//			} else {
//				
//				System.out.println ("Element Not found");
//			}
			
		
			
	
	
	}
		
		
	
	
	@AfterTest
	public void closebrowser() {
		
		driver.close();
	}
}


