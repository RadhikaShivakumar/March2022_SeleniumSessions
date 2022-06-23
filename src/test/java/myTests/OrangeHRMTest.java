package myTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {
	
		@Test(priority=1,description="-----------checking page title  contains OrangeHRM --------")
		public void pageTitleTest() {
			String title = driver.getTitle();
			System.out.println("Page Title: " + title);
			Assert.assertEquals("Sign Up for a Free HR Software Trial | OrangeHRM", title,"....OrangeHRM Page title not matched...");
		}
		
		@Test(priority=2,description="-----------checking page URL contains amazon --------", enabled = true)
		public void pageUrlTest() {
			String url = driver.getCurrentUrl();
			System.out.println("Page URL: " + url);
			Assert.assertTrue(url.contains("orangehrm"),".....OrangeHRM page Url is not matched with orangehrm....");
		}
		
	}


