package myTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{

	@Test(priority=1,description="-----------checking page title  contains Google --------")
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		Assert.assertEquals("Google", title,"....Google Page title not matched...");
	}
	
	@Test(priority=2,description="-----------checking page URL contains Google --------", enabled = true)
	public void pageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("Page URL: " + url);
		Assert.assertTrue(url.contains("google"),".....Google page Url is not matched with Google....");
	}
		
}
