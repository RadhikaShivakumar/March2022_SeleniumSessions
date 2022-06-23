package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.BrowserUtil;
import Utilities.ElementUtil;

public class HRMAppTest1 {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.init_driver("chrome");
		brUtil.launchUrl("https://www.orangehrm.com/contact-sales/");
		
		By name = By.id("Form_submitForm_FullName");
		By companyName = By.id("Form_submitForm_CompanyName");
		By jobTitle = By.id("Form_submitForm_JobTitle");
		By phone = By.id("Form_submitForm_Contact");
		By email = By.id("Form_submitForm_Contact");
		By comment = By.id("Form_submitForm_Email");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(name, "Naveen");
		eleUtil.doSendKeys(companyName, "Infy");
		eleUtil.doSendKeys(jobTitle, "QA");
		eleUtil.doSendKeys(phone, "9898989898");
		eleUtil.doSendKeys(email, "Naveen@gmail.com");
		eleUtil.doSendKeys(comment, "Test2 orangeHRM");
		
		
		brUtil.quitBrowser();
		
		
		
		
	}

}
