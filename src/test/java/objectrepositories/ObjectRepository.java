package objectrepositories;

public class ObjectRepository {
	
public static String Amazon_link = "xpath=//*[@id='nav-link-accountList']//span[2]";
	
public static String Amazon_StartHere = "xpath=//div[@id = 'nav-flyout-ya-newCust']//a[1]" ;
	
public static String Amazon_NameText = "xpath=//input[@id='ap_customer_name']" ;

public static String Amazon_CountryDropdown  = "xpath=//span[@id='auth-country-picker-container']" ;

public static String Amazon_USSelect  = "xpath=//ul[@role = 'application']//li/a[contains (text (),'United States +1')]";

public static String Amazon_PhnNum  = "xpath=//input[@id='ap_phone_number']";

public static String Amazon_Pwd = "xpath=//input[@id='ap_password']";

public static String Amazon_Continue = "xpath=//input[@id='continue']";

public static String Amazon_OTPText = "xpath=//input[@id='auth-pv-enter-code']";

public static String Amazon_CrateAccount = "xpath =//*[@id='createAccountSubmit']";

}
