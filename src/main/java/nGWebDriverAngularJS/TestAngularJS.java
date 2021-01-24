package nGWebDriverAngularJS;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class TestAngularJS {
	
	nGWebDriverDemo calPage ;
	
	@BeforeTest
	public void setUp() {
		
	calPage = new nGWebDriverDemo();	
	}
	
	@Test(priority = 1)
	public void testAngular() {
		
	//storing the result 
	String resultstore = calPage.doSum("10", "20");
	
	Assert.assertEquals(resultstore, "30");
    
	calPage.closeBrowser();
		
	}
	
	
	

}
