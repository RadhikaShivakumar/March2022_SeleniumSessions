package PopUps;

// alert switches to the currently active modal dialog, ie the popup.
// modal dialog also called java script popups



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertPopHandle {
	// Java script (JS) pop up: alerts/prompt/confirmation

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//Alert API
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		Thread.sleep(4000);
	
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
	
		alert.accept(); //click on ok
		//alert.dismiss(); //dismiss the alert, click on cancel
		
		//alert.sendKeys("testing"); //to pass value
		

	}

}
