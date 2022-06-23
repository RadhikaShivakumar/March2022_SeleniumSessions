package Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jQueryDropDown {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryscript.net/demo/Drop-Down-Combo-Tree");

		driver.findElement(By.id("justAnInputBox1")).click();
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		//By choices = By.xpath("(//div[contains(@id,'DropDownContainer')])[1]/ul//span[@class='comboTreeItemTitle']");
		
		//TC_01: single selection:
		//selectChoice(choices, "choice 9");

		//TC_02: Multi selection
		//selectChoice(choices,"choice 1","choice 2","choice 6 2 1","choice 7");
		
		//TC_03: All selection
		//selectChoice(choices,"select_all");

		
		By choices = By.xpath("(//div[@class='comboTreeDropDownContainer'])[2]/ul/li[@class='ComboTreeItemChlid' or @class='ComboTreeItemParent']");
		By choices26 =By.xpath("(//div[@class='comboTreeDropDownContainer'])[2]/ul/li[@class='ComboTreeItemParent']");
		//selectChoice(choices,"choice 1","choice 3","choice 4","choice 5","choice 7");
		//selectChoice(choices,"select_all");
		
		selectChoice(choices26,"choice 2"); //choice 2 and choice 6 is not selecting.
		
	}
	
	//significance of 3 dot parameter, user has to create an array and pass that array as input
	// with the help of 3 dot parameter, need not create any unnecessary array. that is the advantage.
	
	//String... 3 dot parameter, it is like array variable String[]
	// this parameter can be single value or multiple values.
	
	//3 dot parameter should be the last parameter in arguments list.
	
	/*
	 * This method is used to select the choices:
	 * 1. single
	 * 2. Multiple
	 * 3. All selections: please lass the 'select_all'
	 */
	public static void selectChoice(By locator,String... value) {
		List<WebElement> choiceList = driver.findElements(locator);

		System.out.println(choiceList.size());
		boolean flag = false;
		
		if(!value[0].equals("select_all")) {
			for(WebElement e:choiceList ) {
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
			//all selection logic:
			for(WebElement e: choiceList) {
				e.click();
				flag=true;
			}
		}
		
		if(flag==false) {
			System.out.println("Choice is not availale " +value[0]);
		}
		
	}

}

//Exception in thread "main" org.openqa.selenium.WebDriverException: target frame detached

//Handle other two dropdowns --> Assignment
//deselection, call the method two times.

