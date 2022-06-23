package myTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest{

	@Test(priority=1,description="-----------checking page title  contains amazon --------")
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		Assert.assertEquals("Amazon.com. Spend less. Smile more.", title,"....amazon Page title not matched...");
	}
	
	@Test(priority=2,description="-----------checking page URL contains amazon --------", enabled = true)
	public void pageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("Page URL: " + url);
		Assert.assertTrue(url.contains("amazn"),".....amazon page Url is not matched with amazon....");
	}
	
	@Test(priority=3,description="-----------checking search test--------")
	public void isSearchExistTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);
	}

	
}
