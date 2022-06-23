package Locators;

/*
 * 		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),\"::before\").getPropertyValue('content')";

Here getPropertyValue --> will always be content only.
 */
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PsuedoClassConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://opencart.antropy.co.uk/index.php?route=account/register");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),\"::before\").getPropertyValue('content')";
		String mandatoryText = js.executeScript(script).toString();
		System.out.println(mandatoryText);
		if(mandatoryText.contains("*")) {
			System.out.println("Mandatory field");
		}
	
	}
	
	//for orangeHRM webpage: https://www.orangehrm.com/contact-sales
	//window.getComputedStyle(document.querySelector("label[for='Form_submitForm_FullName']"),"::after").getPropertyValue('content')
}
