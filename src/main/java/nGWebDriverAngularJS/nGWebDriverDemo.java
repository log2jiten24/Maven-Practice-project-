package nGWebDriverAngularJS;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class nGWebDriverDemo {
	
WebDriver driver ;
NgWebDriver ngWebDriver ;
JavascriptExecutor jsExecutor ;



//store the objects 
ByAngularModel first = ByAngular.model("first");
ByAngularModel second = ByAngular.model("second");
ByAngularModel select = ByAngular.model("operator");
ByAngularButtonText gobutton = ByAngular.buttonText("Go!");

By result = By.tagName("h2");

 //create a constructor of the class to initialise some of the initial objects 
 public nGWebDriverDemo()  {
	 
	 System.setProperty("webdriver.edge.driver", "E:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
	 driver = new EdgeDriver() ;
	 jsExecutor = (JavascriptExecutor)driver ;
	 //create object of nGWebDriver and pass jsExecutor as reference 
	 ngWebDriver = new NgWebDriver(jsExecutor);
	 
	 
	 driver.get("http://localhost:3456/");
	 driver.manage().window().maximize();
	 //this will create default wait -it will wait for angular wait till the waiting of the objects 
	 ngWebDriver.waitForAngularRequestsToFinish();	
	
	
}
  
 public String doSum (String val1 , String val2) {
	 
	 driver.findElement(first).clear();
	 driver.findElement(first).sendKeys(val1);
	 
	 driver.findElement(second).clear();
	 driver.findElement(second).sendKeys(val2);
	 
	 driver.findElement(select).sendKeys("+");
	 
	 driver.findElement(gobutton).click();
	 ngWebDriver.waitForAngularRequestsToFinish();
	 
	 System.out.println("store the text :"+ driver.findElement(result).getText());
	 
	 return driver.findElement(result).getText();
	 
	 
 }
 
 public void closeBrowser() {
	 
	 driver.close();
 }

}