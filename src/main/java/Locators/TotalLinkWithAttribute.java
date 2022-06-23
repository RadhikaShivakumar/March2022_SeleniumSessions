package Locators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinkWithAttribute {

	static WebDriver driver;
	public static void main(String[] args) {
		//total link with Attribute

		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
	
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		
//		System.out.println("Total number of links: "+ linksList.size());
//		
//		for(WebElement e: linksList) {
//			String hrefVal = e.getAttribute("href");
//			System.out.println(hrefVal);
//		}
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		
//		List<String> hrefList= getElementsAttributeList(links,"href");
//		for(String e: hrefList) {
//			System.out.println(e);
//		}
//		
		
//		if(getElementsTextList(links).contains("Registry")) {
//			System.out.println("PASS");
//		}
		
		System.out.println("Total links " + getElementCount(links));
		System.out.println("Total images " + getElementCount(images));
		
		driver.quit();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static int getElementCount(By locator) {
		return getElements(locator).size();
	}
	
	public static List<String> getElementsAttributeList(By locator,String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String attrVal = e.getAttribute(attrName);
			eleAttrList.add(attrVal);
		}
		return eleAttrList;
	}
	
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String eleText = e.getText();
			System.out.println(eleText);
			eleTextList.add(eleText);
		}
		return eleTextList;
	}
	
	
}
