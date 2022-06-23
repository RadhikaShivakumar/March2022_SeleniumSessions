package myTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

public class LoginNegativeTest extends BaseTest {

	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			{"testttt@gmail.com", "test12323"},
			{"testttt@gmail.com", "      "},
			{"testttt@.@gmail.com", "test123"},
			{"naveeen@gmail.com", "test12323"},
			{"    ", "    "},
		};
	}
	
	@Test(dataProvider="getLoginData")
	public void loginTest(String username, String password) {
		
		Assert.assertTrue(doLogin(username,password));
	}
	
	public boolean doLogin(String username, String password) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errorMsg);
		
		if(errorMsg.contains("No match for E-Mail Address and/or Password")) {
			return true;
		}
		return false;
	}
	
	
}
