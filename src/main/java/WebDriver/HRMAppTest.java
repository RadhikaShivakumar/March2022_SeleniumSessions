package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.BrowserUtil;
import Utilities.ElementUtil;

public class HRMAppTest {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.init_driver("chrome");
	
		brUtil.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial");
		System.out.println(brUtil.getPageTitle());
		System.out.println(brUtil.getPageUrl());
		
		By name = By.id("Form_submitForm_Name"); 
		By email = By.id("Form_submitForm_Email");
		By telephone = By.id("Form_submitForm_Contact");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(name,"naveen");
		eleUtil.doSendKeys(email,"test@gmail.com");
		eleUtil.doSendKeys(telephone,"9898989898");
		
		brUtil.quitBrowser();
	
		//Assignment =https://www.orangehrm.com/contact-sales/

		//fill the form
		
		//http://opencart.antropy.co.uk/index.php?route=account/login
		//register
		
		
	}

}
