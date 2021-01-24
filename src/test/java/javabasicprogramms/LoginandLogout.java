package javabasicprogramms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginandLogout {


	public static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
	    //System.setProperty("webdriver.chrome.driver", "\\drivers\\chromedriver.exe");
	   WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		
		//delete all  cookies
		driver.manage().deleteAllCookies();
		//launching the url
		//add implicit wait 
		//add page load timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}
	
	@Test(description = "test the orangehrm pages ")
	public void testcredentials () throws Exception {
		
		String filepath = System.getProperty("user.dir")+ "\\LoginCredentials.xlsx";
		
		FileInputStream fis = new FileInputStream(filepath);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis) ;
		
	    XSSFSheet sh = wb.getSheet("Sheet1");
		
		int rowCount = sh.getLastRowNum() ;
		
		for (int i = 0 ; i <rowCount ; i ++ ) {
			
			String username = sh.getRow(i).getCell(0).getStringCellValue() ;
			String password = sh.getRow(i).getCell(1).getStringCellValue();
			
			System.out.println ("username printed is" + username);
			System.out.println ("password printed is" + password);
			
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
			
			driver.findElement(By.id("btnLogin")).click();
			
			Thread.sleep(30000);
			
			String text = driver.getTitle();
			
			if (text.equalsIgnoreCase("OrangeHRM")) {
				
			System.out.println ("Textpresent  : " + text);
			}
		}
		
		//to write the data file 
        FileInputStream fis1 = new FileInputStream(filepath);
		
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1) ;
		
	    XSSFSheet sh1 = wb1.getSheet("Sheet1");
		
		int rowCount1 = sh1.getLastRowNum() ;
		
		
			//to save the cell value at particular cell
			
		sh1.getRow(1).createCell(2).setCellValue("Success");
		
		FileOutputStream fileout = new FileOutputStream(filepath);
			
			wb1.write(fileout);
			
			wb1.close();
			
				 }
	
	

	@AfterTest
	public void closebrowser() {
		
		driver.close();
	}

}
