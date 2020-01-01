package otpHandling;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import objectrepositories.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import functionlibrary.*;

public class Testotp {

	//Account_SID for Message 
    public static final String ACCOUNT_SID = "AC9201fc50ec1f7a83abfac931a797f4ec";
	//Message token 
	public static final String AUTH_TOKEN  = "c60d65bfc58503a47651dc0d744313c9";
	
	public static String URL = "https://www.amazon.in/";
	
	public static WebDriver driver ;
	
	@BeforeTest
	public void launchbroswer( ) throws Exception {
		
		//launch the browser 
		Reusablefunctionss.launchbrowser("Chrome", URL);
		
		Reusablefunctionss.elementTimeOut("30");
		
		
		}
	
	@Test(priority = 1 ,description = "fill the Amazon page details", enabled = true)
	public void verifyOTP () throws Exception {
	
	Reusablefunctionss.capturescreenshot(driver, "url got opened");	
	
	//click on amazon link for creating account
	Reusablefunctionss.click(ObjectRepository.Amazon_link);
	
	Reusablefunctionss.wait(2000);
	
	Reusablefunctionss.capturescreenshot(driver, "amazon link clicked successfully");
	//click on start here
	Reusablefunctionss.click(ObjectRepository.Amazon_StartHere);
	
	//click on create Account 
	
	Reusablefunctionss.click(ObjectRepository.Amazon_Continue);
	
	Reusablefunctionss.wait(2000);
	//type the edit text 
	Reusablefunctionss.type(ObjectRepository.Amazon_NameText, "Jiten");
	
	//select the country drop down
	Reusablefunctionss.click(ObjectRepository.Amazon_CountryDropdown);
	
	Reusablefunctionss.wait(2000);
	//select the United States from drop down
	Reusablefunctionss.click(ObjectRepository.Amazon_USSelect);
	//Enter phone number
	Reusablefunctionss.type(ObjectRepository.Amazon_PhnNum, "3342928378");
	//Enter password
	Reusablefunctionss.type(ObjectRepository.Amazon_Pwd, "Ajiten#1990");
	
	//click on Continue button
	
	Reusablefunctionss.click(ObjectRepository.Amazon_Continue);
	
	Reusablefunctionss.wait(5000);
	}
	
	
	@Test(priority = 2, description = "verify the otp login " , enabled = true)
	public void verifyotplogin () throws Exception  {
	
	//setting connection with twilio API
		
	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);	
		
	//String sms_body = getMessage() ;
	//printing the sms body 
	//System.out.println ("print the sms body :"+ sms_body);
		
	//String OTP_Number = sms_body.replaceAll("[^-?0-9]+", " ")	;
	
	//System.out.println ("print the otp :"+ OTP_Number);
	
	
	//Reusablefunctionss.type(ObjectRepository.Amazon_OTPText, OTP_Number);
		
	Reusablefunctionss.wait(2000);
		
	Reusablefunctionss.capturescreenshot(driver, "Otp Number Entered Successfully ");
		
	
	
	}
	
	@AfterTest
	public void closebroser () {
	
	Reusablefunctionss.closebrowser();	
	}
	
//	public static String getMessage() {
////		return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
////				.filter(m -> m.getTo().equals("+13343734019")).map(Message::getBody).findFirst()
////				.orElseThrow(IllegalStateException::new);
//		
//		return message ;
//	}

	 	private static Stream<Message> getMessages() {
	 		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
	 		return StreamSupport.stream(messages.spliterator(), false);
	 	}
	    

}
