package selenium4features;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Dockergrid {
	
	@Test
	public void testgrid() throws MalformedURLException, Exception {
		
		    //opening the chrome webdriver 
		    WebDriverManager.chromedriver().setup();
		
	         ChromeOptions options = new ChromeOptions();
//			 options.addExtensions(new File("/path/to/extension.crx"))
//			 options.setBinary(new File("/path/to/chrome"));

			 // For use with ChromeDriver:
			 WebDriver  driver = new ChromeDriver(options);

			 // For use with RemoteWebDriver:
			  driver  = new RemoteWebDriver(new URL("http://localhost:4546/wd/hub"),
			            new ChromeOptions());
			  
			  driver.get("https://www.google.co.in");
			  
			  Thread.sleep(5000);
			  
			  driver.close();
			  
			  //selenium3 code 
			//  DesiredCapabilities capab = new DesiredCapabilities();
			  //capab.setBrowserName(BrowserType.Chrome());
			  //WebDriver driver = new RemoteDriver (new URL("http://localhost:4546/wd/hub"),capab);
			  //driver.get(url);
			  driver.close();
	
}

	
}