package Locators;

import java.util.List;

import org.openqa.selenium.By;
/*
 * SVG: Scalable vector graph
 * svg: is combination of multiple elements.
 * we cannot CSSSelector, always crate xpath.
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		List<WebElement> statesList = driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='path']"));
		System.out.println(statesList.size());
	
		Actions act = new Actions(driver);
		
		
		for(WebElement e: statesList ) {
			act.moveToElement(e).perform(); //to mouse hover over all graph elements
			String name = e.getAttribute("name");
			System.out.println(name);
				if(name.equals("Maryland")) {
					e.click();
					break;
				}
			}
		
		//This click is not happening.
	
		
		//driver.quit();
		
		//for flipkart search icon which is a svg element.
		//*[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']
	}

}

//Assignment: print citys of State Maryland

