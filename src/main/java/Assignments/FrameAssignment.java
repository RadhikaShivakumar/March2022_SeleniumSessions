package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Utilities.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAssignment {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://formsite.com/templates/registration-form-templates/vehicle-registration-form");
		driver.findElement(By.xpath("//img[@title='vehicle-registration-forms-and-templates']")).click();
		
		driver.switchTo().frame("frame-one748593425");
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys("2011");
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("Honda");
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("CRV");
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys("Black");
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys("10000");
		driver.findElement(By.id("RESULT_TextField-7")).sendKeys("3896");
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("Sham");
		driver.findElement(By.id("RESULT_TextField-9")).sendKeys("3000 Daniel lane");
		driver.findElement(By.id("RESULT_TextField-10")).sendKeys("Apt. 207");
		driver.findElement(By.id("RESULT_TextField-11")).sendKeys("MonroeVille");
		Select select = new Select(driver.findElement(By.id("RESULT_RadioButton-12")));
		select.selectByVisibleText("Minnesota");
		driver.findElement(By.id("RESULT_TextField-15")).sendKeys("xyz@gmail.com");
		
		

	}

}
