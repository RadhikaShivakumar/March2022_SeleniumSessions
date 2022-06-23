package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropdownSingleSelection {

		//jquery drop down Single Selection
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://jqueryscript.net/demo/Drop-Down-Combo-Tree");

			
			
			driver.findElement(By.id("justAnotherInputBox")).click();
			driver.manage().window().maximize();
			
			Thread.sleep(2000);
			
			//By choices = By.xpath("(//div[@class='comboTreeDropDownContainer'])[2]/ul/li[@class='ComboTreeItemChlid' or @class='ComboTreeItemParent']");
			By choices = By.xpath("(//div[@class='comboTreeDropDownContainer'])[3]//span[@class='comboTreeItemTitle']");
			
			//selectChoice(choices,"choice 1","choice 3","choice 4","choice 5","choice 7");
			//selectChoice(choices,"all"); //here not all options under choice 2 and choice 6 is selecting.

			//selectChoice(choices,"choice 3");
			selectChoice(choices,"choice 2 1");
			//selectChoice(choices,"choice 6 1");
			
	}

		public static void selectChoice(By locator,String...value) {
			List<WebElement> choiceList = driver.findElements(locator);
			
			boolean flag = false;
			
			if(!value[0].equals("all")) {
				for(WebElement e: choiceList) {
					String text = e.getText().trim();
					for(int i=0;i<value.length;i++) {
						if(text.equals(value[i])) {
							flag=true;
							e.click();
							break;
						}
					}
				}
			}
			else {
				// all selection logic
				for(WebElement e: choiceList) {
					e.click();
					flag=true;
				}
			}
			
			if(flag==false) {
				System.out.println("Choice is not available" + value[0]);
			}
		}
	
}
