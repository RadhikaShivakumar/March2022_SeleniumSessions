package WaitConcept;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.xpath("//input[@title='Sign in']")).click(); //no such alertExpection
		//driver.switchTo().alert().accept();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
	
	}

	/**
	 * Method for alert is present or not
	 * @param timeout
	 * @return
	 */
	public static Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String doGetAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}
	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	public void alertSendKeys(int timeOut,String value) {
		waitForAlert(timeOut).sendKeys(value);
	}
}
