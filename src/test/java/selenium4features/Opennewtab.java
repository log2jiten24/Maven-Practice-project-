package selenium4features;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import functionlibrary.Reusablefunctionss;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Opennewtab {
	
	public static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
		//it will open the Chrome browser 
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		//launching the url
		//add implicit wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
		driver.get(baseUrl);
		
	}
	
	@Test (priority = 1 , description = "open the url and switch to another tab" , enabled = true)
	public void openurlandlogin() throws Exception 
	{
		
		String title = driver.getTitle();
		System.out.println ("driver title is :"+ title );
		
		
		//to open new tab and driver control will switch to new tab 
		driver.switchTo().newWindow(WindowType.TAB);
		System.out.println ("after switching titile is  :"+ driver.getTitle());
		
		Set<String>   allwindows    =  driver.getWindowHandles();
		//pass the parameter inside the List 
		List<String> alllists = new ArrayList<String>(allwindows);
		
		String parentWindow = alllists.get(0);
		String childWindow  = alllists.get(1);
		System.out.println ("parent window is :" + parentWindow);
		System.out.println ("child window is :" +  childWindow);
		
		
		
		driver.get("https://www.facebook.com");
		System.out.println ("after switching new driver titile is  :"+ driver.getTitle());
		
		//close the second tab
		driver.close();
		
		//switch to parent window 
		driver.switchTo().window(parentWindow);
		
		System.out.println (" parent window driver title is :"+ driver.getTitle() );
		
		Reusablefunctionss.wait(4000);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		//character sequenc
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		//close the window 
		driver.close();

}
}