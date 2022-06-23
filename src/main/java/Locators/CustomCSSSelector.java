package Locators;

import org.openqa.selenium.By;
/*
 	css selector - is not an attribute
	id and class
	#id or tag#id  #input-email or input#input-email
	.class tag.class .form-control or input.form-control
	
	combination:
	------------
	#id.class
	#input-email.form-control
	
	.class#id
	.form-control#input-email
	
	tag#id.class
	input#input-email.form-control
	
	
	tag.class#id
	input.form-control#input-email
	
	.c1.c2.c3..cn
	.form-control.private-form__control.login-email
	
	tag.c1.c2.c3...cn
	input.form-control.private-form__control.login-email
	
	tag.c1.c2.c3...cn#id
	input.form-control.private-form__control.login-email#username


	tag#id.c1.c2.c3..cn
	input#username.form-control.private-form__control.login-email
	
	
	formula:
	tag[attribute='value']
	input[name='email']
	
	
	for multiple attribute
	tag[attribute1='value'] [attribute2='value'] [attribute3='value']
	input[name='email'][type='text'][placeholder='E-Mail Address']

	(Intv)
	
	Which below are correct?
		By.className("form-control private-form__control login-email");
	Incorrect, whenever using className, multiple classes should not be present.
	Find elements based on the value of the "class" attribute. Only one class name should beused. 
	If an element has multiple classes,	 please use By.cssSelector(String).	
		
		By.xpath("//input[@class='form-control private-form__control login-email']");
	xpath is correct.
	
		By.cssSelector("input.form-control.private-form__control.login-email");
	Css is correct
	
		By.className("login-email"); correct, only one className should be used.
	
	//parent to child navigation:
	 *  > direct child
	 div.private-form__input-wrapper > input#username
   
   	// if write a space direct and indirect child can be captured
    div.private-form__input-wrapper input#username
   
   form#hs-login  input --> 3 inputs
   form#hs-login  input#password --> password
   
   child-to-parent is not possible in CSS(backward traversing is not allowed in css)
   
   //contains function like in CSS
    input[id*='username'][type='email'][class*='login-email']

	//starts-with use ^ symbol
	 * input[id^='user']

	//ends-with use $ symbol
	 * input[id$='name']
	 
	//preceding-sibling: NA
	//following-sibling: Available,not that great
	 label.control-label + input#input-email 
	 
	 cannot get collection of siblings, we can only get one sibling
	 
	 //No text support
	  * 
	 
	 //with comma, we can combine multiple locator values
	  input#username,input#password,button#loginBtn,input#remember
	 
	 //not in css
	  * form-control private-form__control login-email
	  * form-control private-form__control login-password m-bottom-3
	  * 
	   input.form-control.private-form__control:not(#password)
	
	 	xpath engine will try to find the element based on the xpath written and they are very powerful and fast.
	
	  
	  	Dynamic element: (like contains,starts with)
	  	                     xpath            |        cssSelector
	 1.	syntax:              hard			        	simple
	 2.	backward traversing: possible					NA
	 3.	performance:         same                       same 
	 4.	comma,not:           NA				    		available
	 5.	text: 				Available					NA	
	 6.	sibling:			better support				only direct forward sibling
	 7.	dynamic element     available					available
 	 8.	webtable			better support				not that great

 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CustomCSSSelector {
	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
		By name = By.cssSelector("#input-email");
		By.className("form-control private-form__control login-email"); //wrong 
		By.xpath("//input[@class='form-control private-form__control login-email']"); //right
		By.cssSelector("input.form-control.private-form__control.login-email"); //right
		By.className("login-email"); //right
		By.className("private-form__control"); //right
		
		int mandatoryFieldCounts = driver.findElements(By.cssSelector("input#username, input#password, button#loginBtn, input#remember")).size();
		System.out.println(mandatoryFieldCounts);
		
		//Exception in thread "main" org.openqa.selenium.InvalidSelectorException: Compound class names not permitted
		//For documentation on this error, please visit: https://selenium.dev/exceptions/#invalid_selector_exception
		//	Build info: version: '4.1.3', revision: '7b1ebf28ef'
	}
}
