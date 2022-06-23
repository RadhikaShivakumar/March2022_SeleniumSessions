package myTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenCartRegistrationTest extends BaseTest {

	@DataProvider
	public Object[] getRegisterData() {
		return new Object[][] {
			{"john","Ming","john@gmail.com","999011112","test@123","test@123","Yes"},
			{"ann","le","ann@gmail.com","4324354","test@123","test@123","Yes"},
			{"pinto","kale","pinto@gmail.com","45647567","test@123","test@123","No"},
			{"ramya","xing","ramya@gmail.com","13213213","test@123","test@123","Yes"},
			{"Aditi","jyn","aditi@gmail.com","7876878768","test@123","test@123","No"},
			{"lakshmi","manch","lakshmi@gmail.com","4444444444","test@123","test@123","Yes"},
		};
	}
	@Test(dataProvider="getRegisterData")
	public void register(String firstName,String lastName,String email,String telephone,String pwd,String confirmPwd, String subscribe) {
		
		doRegister(firstName,lastName,email,telephone,pwd,confirmPwd,subscribe);
		
	}
	
	public void doRegister(String firstName,String lastName,String email,String telephone,String pwd,String confirmPwd, String subscribe) {
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);
		
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPwd);
		
		
		List<WebElement> subscribeOptions = driver.findElements(By.xpath("//label[@class='radio-inline']"));
		for(WebElement ele:subscribeOptions) {
			String text = ele.getText().trim();
			if(text.equals(subscribe)) {
				ele.click();
			}
		}
	}
	

}
