package selenium4features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

public class LaunchChromeBrowser {
	
	static WebDriver driver ;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "E:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		
		EdgeDriver driver  = new EdgeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		String text = driver.getTitle();
		
		Assert.assertEquals("OrangeHRM", text);
		
		driver.findElement(By.xpath("//a[contains(text(),'Welcome Admin')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		driver.close();
		
		

	}

}
