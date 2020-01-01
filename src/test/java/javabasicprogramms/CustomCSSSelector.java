package javabasicprogramms;

public class CustomCSSSelector {

	
	//how to use the css selector 
	//i)-htmltag#id,#id 
	//ii)htmltag.classname ,.classname ,.c1.c2.c3, htmltag.c1.c2.c3..cn
	//iii)-parenttag>childtag
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//url - https://guide.blazemeter.com/hc/en-us
		
		//css selector - ul#categories
		//css selector - input.logo
		//https://app.hubspot.com  -- input.c1.c2.c3
		//multiple css selectorcss selector - input.form-control.private-form__control.login-email
		//input#username.form-control.private-form__control.login-email (htmltag#id.c1.c2.c3)
		//input.c3(input.c3)
		//-- input[id ='username'] -- alternative of xpath = //input[@id = 'username']
		//-- input[id ='username'][type = 'email'] -- using two types of attributes and xpath =//input[@id = 'username' and @type = 'email']
        //--//div[@class = 'private-form__input-wrapper']//input[@id = 'username']-- using with css 
		//-- div.private-form__input-wrapper,input#username -- comma sep
		//input[id*='user']-- this is for verifying the contains keyword 
		//id = test_123
		       //test_245
		//input[id*='user_']
		//---starts with keyword -- input[id^='user']-- starts with keyword in css 
		//input[id^= 'txtUser']-- starts-with keyword -- xpath written as -- //input[starts-with (@id, 'txtUser')]
		//-- input[id$='name']-- ending with keyword --input[id $= 'name']
		
		//first-of-type -- it will identify the first-of-type category 
		//ul#categories>li -- it will give all the child tag under the parent tag
        //--div[id ='divUsername']>input -- it will go the next child  tag under the parent tag -- xpath can be written as -- 
		//div[@id ='divUsername']/input[@id = 'txtUsername']
		
		//ul#categories>li:first-of-type -- it will give the first child tag link under the parent link 
		// to go the last tag -- ul#categories>li:last-of-type
		//-- to go to any tag under the parent class (nth-of-type)--ul#categories>li:nth-of-type(4)--here it will go to 4th link 
		//-- to get all the child tags under the parent class -- ul#categories>li:nth-of-type(n)
		//--sibling - to select the next sibling link --div[id ='divUsername']+div#divPassword -- it will go the next div link 
		//--ul#categories>li:nth-of-type(4)+li+li -- it will go to 6th element 
		
	}

}
