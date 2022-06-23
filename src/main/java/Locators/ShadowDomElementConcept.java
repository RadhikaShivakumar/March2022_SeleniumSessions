package Locators;

import org.openqa.selenium.JavascriptExecutor;
/*
 * Shadow Dom:
 *  can put some sensitive information
 *  
 *  
 *  // html page DOM --> elements
 *  				// --> Shadow DOM (its having its own structure) --> elements are available
 *  
 *  
 *  html page DOM --> elements
 *  		//---> iframe
 *   			//---> Shadow DOM
 *   					//---> elements
 *   
 *   
 *   shadow dom --> only cssSelector works and not xpath.
 *   
 *   right click on shadown dom and copy js path and copy it in console.
 *   from there get the complete shadow dom and then complete the js query
 *   execute it with using JavascriptExceutor
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElementConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);
//		driver.switchTo().frame("pact");
//		driver.findElement(By.id("tea")).sendKeys("Masala Tea"); //No such Element exception
//		
		//no such element exception even after switching to iframe
		//because it is present in shadow dom
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement tea = (WebElement) js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		tea.sendKeys("masala tea");
		
		//Not working
	}

}


/*
 Exception in thread "main" org.openqa.selenium.JavascriptException: javascript error: Cannot read properties of null (reading 'shadowRoot')
  (Session info: chrome=101.0.4951.64)

*/