package TestNGSessions.Annotations;
/*
  priority: when have to run tests according to user requirement instead of 
  default alphabetical order
  
  if priority is same for all tests, then it will run according to alphabetical order.

  To run a single testcase, select the testcase and right click and -> Run As -> TestNG Test	
 
 To disable test - enabled = false.	
 
 */
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	WebDriver driver;
	
	@BeforeTest(description="----- setup for amazon test:  launch chrome and enter url------")
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com");
	}
	
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
		Assert.assertTrue(url.contains("amazon"),".....amazon page Url is not matched with amazon....");
	}
	
	@Test(priority=3,description="-----------checking search test--------")
	public void isSearchExistTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@AfterTest(description = " ----- closing the browser-------")
	public void tearDown() {
		driver.quit();
	}
}
