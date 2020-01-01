package selenium4features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysfunctionaity {
	
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
	
	@Test (priority = 1 , description = "open the url and send keys functionality" , enabled = true)
	public void openurlandlogin() throws Exception 
	{
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		//1.sending username as String 
		//username.sendKeys("Admin");
		 
		//2.String Builder is mutable ,it can be changed whereas String is immutable ,String can be changed .
//		StringBuilder sb = new StringBuilder ()
//	      .append("Jiten")
//	      .append(" ")
//	      .append("Automation")
//	      .append("")
//	      .append("Practice")
//	      //insert new value at particular position
//        .insert(6, "Priya");
		
		
	    //3.pass parameter for String Buffer 
//		StringBuffer sb = new StringBuffer ()
//	      .append("Jiten")
//	      .append(" ")
//	      .append("Automation")
//	      .append("")
//	      .append("Practice")
//	      //insert new value at particular position
//        .insert(6, "Priya");
		
		
		//4. Use StringBuilder ,StringBuffer ,and String combination 
		StringBuilder sb = new StringBuilder ()
	      .append("Jiten")
	      .append(" ")
	      .append("Automation")
	      .append("")
	      .append("Practice")
	      //insert new value at particular position
          .insert(6, "Priya");
		
		String space = " " ;
		
		StringBuffer stringbuff = new StringBuffer ()
	      .append("Vivek")
	      .append(" ")
	      .append("Automation")
	      .append("")
	      .append("Practice1");
		
		String author = "Jiten and Priya" ;
		
		//enter multiple strings as character sequence(multiple String Parameters )
		username.sendKeys(sb,space,stringbuff, space,author,Keys.TAB);
		
		
		
		
		
		
		
		username.sendKeys(sb);
		
		
		
		
		

}

	
}