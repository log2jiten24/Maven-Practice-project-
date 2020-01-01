package selenium4features;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium4newlocator {
	
	
	public static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
	    System.setProperty("webdriver.chrome.driver", "\\drivers\\chromedriver.exe");
	    //WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		//launching the url
		//add implicit wait 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)	;
		driver.get(baseUrl);
		
	}
	
	@Test (priority = 1 , description = "new locator for selenium 4 " , enabled = true)
	public void openurlandlogin() throws Exception 
	{
    
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		
	//WebElement login = 	driver.findElement(RelativeLocator.withTagName("input").below(By.xpath("//input[@id='txtPassword']")));
		
		//working with one element
		//WebElement login = 	driver.findElement(withTagName("input").below(By.xpath("//input[@id='txtPassword']")));	
	    //login.click();
	 
	List<WebElement> sociallinks =	driver.findElements(withTagName("img").below(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")));
	
	System.out.println ("total count :" + sociallinks.size());
	
	for (WebElement ele : sociallinks) {
		
		System.out.println (ele.getAttribute("alt"));
	}
	
     }
	
	//type folowing method in console to get the height and width of the text box - document.getElementById.getBoundingClientrect()--it will give 
	//height and width 
}