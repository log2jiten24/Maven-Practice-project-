package javabasicprogramms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CSSPractice {
	
	public static WebDriver driver ;
	String baseUrl = "http://newtours.demoaut.com/";
	
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
	
	@Test (priority = 1 , description = "css selector features " , enabled = true)
	public void openurlandlogin() throws Exception 
	{
    
		WebElement Username = driver.findElement(By.cssSelector("td[width = '112']>input[name = 'userName']"));
		WebElement Password = driver.findElement(By.cssSelector("td[width = '112']>input[name = 'password']"));
		
		Username.sendKeys("log2jeet24@gmail.com");
		Password.sendKeys("Ajiten#1990");
		
		WebElement login = driver.findElement(By.cssSelector("input[ name = 'login'][type = 'image']"));
		
		login.click();
		
		//a[contains(text(),'SIGN-OFF')]--//td[@class = 'mouseOut']/a[contains(text(),'SIGN-OFF')]
		
		Select oselect = new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
		
    	oselect.selectByVisibleText("2");
    	
    	//click on airline using css selector 
		
        Select oselection = new Select(driver.findElement(By.cssSelector("select[name = 'airline'],[xpath = '1']")));
		
    	oselection.selectByVisibleText("Pangea Airlines");
		
		WebElement continuee = driver.findElement(By.cssSelector("input[name = 'findFlights'],[type ='image']"));
		continuee.click();
		
        WebElement logout = driver.findElement(By.xpath("//td[@class = 'mouseOut']/a[contains(text(),'SIGN-OFF')]"));
		logout.click();
		
		driver.close();

}
}