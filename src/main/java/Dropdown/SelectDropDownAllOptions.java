package Dropdown;

import java.util.ArrayList;
import java.util.List;

/*
 * //shortcut to ctrl+2 (to assign the results to local variable)
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllOptions {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By country = By.id("Form_submitForm_Country");
		By states = By.id("Form_submitForm_State");

//		dropDownSelectValue(country,"India");
//		
//		Thread.sleep(4000);
//		dropDownSelectValue(states,"Goa");
		dropDownSelectValueGetOptions(country,"India");
		
//		Select select = new Select(driver.findElement(country));
//		select.selectByValue("India");
		
		//without using Select  class, to select value in drop down
//		By countryOptions = By.xpath("//select[@id='Form_submitForm_Country']/option");
//		dropDownSelectValue(countryOptions,"India");
//	
//		List<String> optionsList = getDropdownOptionsList(country);
//		for(String s: optionsList ) {
//			System.out.println(s);
//		}
		
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public static void dropDownSelectValueGetOptions(By locator,String value) {
		Select sel_country = new Select(getElement(locator));
		List<WebElement> optionList = sel_country.getOptions();
		
		for(WebElement e: optionList) {
			String text= e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public static void dropDownSelectValue(By locator,String value) {
		List<WebElement> list = driver.findElements(locator);
        for(WebElement e: list) {
			String text= e.getText();
			  if(text.equals("India")) {
				e.click();
				break;
			  }
			}
	}
	
	public static  List<String> getDropdownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> dropdownOptionList = select.getOptions();
		List<String> stringListOfOptions = new ArrayList<String>();
		for(WebElement e: dropdownOptionList ) {
			String text = e.getText();
			stringListOfOptions.add(text);
		}
		return stringListOfOptions;
	}
}
