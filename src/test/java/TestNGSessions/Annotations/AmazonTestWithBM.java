package TestNGSessions.Annotations;

/*
 Which approach is better ? BeforeTest or BeforeMethod
 BeforeTest                                         BeforeMethod
 if test has 100 cases								since we are launching the browser
 and some test fails(like crash
 ,memory issues)  then the						    each time for every TC, we do not see this issue	
 remaining cases will not be executed
 
 Execution percent : 4% if TC fails at 4			Execution percent: 99%
 
 
 
 BT													BM		BM				
 TC1												TC1	    TC2
 TC2												AM      AM
 .
 .
 .
 TC100
 AT
 
 Coverage is not good								good coverage
 Less time because browser							More time as browser opens and closes for every TC
 opens and closes only once
 
 
 
 if application is stable, if tc's are less(50 or less TC, sanity TC) then can use BT
 
 BM -> for regression testcases(100 or 200+ TC's)
 
 
 the above issue of BT can be solved by docker containers in frameworks.
 thread local and parallel execution.
 
 */
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestWithBM {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com");
	}
	
	@Test(priority=1)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		Assert.assertEquals("Amazon.com. Spend less. Smile more.", title);
	}
	
	@Test(priority=2)
	public void pageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("Page URL: " + url);
		Assert.assertTrue(url.contains("amazon"));
	}
	
	@Test(priority=3)
	public void isSearchExistTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
