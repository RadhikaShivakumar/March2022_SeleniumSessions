package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.BrowserUtil;
import Utilities.ElementUtil;

public class OpenCartTest {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.init_driver("chrome");
		brUtil.launchUrl("http://opencart.antropy.co.uk/index.php?route=account/register");
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By fax = By.id("input-fax");
		By company = By.id("input-company");
		By address1 = By.id("input-address-1");
		By address2 = By.id("input-address-2");
		By city = By.id("input-city");
		By postcode = By.id("input-postcode");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
	
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Naveen");
		eleUtil.doSendKeys(lastName, "Lab");
		eleUtil.doSendKeys(email, "Naveen@gmail.com");
		eleUtil.doSendKeys(telephone, "989898989");
		eleUtil.doSendKeys(fax, "768789000");
		eleUtil.doSendKeys(company, "infy");
		eleUtil.doSendKeys(address1, "1305 radio drive");
		eleUtil.doSendKeys(address2, "apt 121");
		eleUtil.doSendKeys(city, "Boxton");
		eleUtil.doSendKeys(postcode, "54677");
		eleUtil.doSendKeys(password, "test@123");
		eleUtil.doSendKeys(confirmPassword, "test@123");
		
		brUtil.quitBrowser();
		
	}

}
