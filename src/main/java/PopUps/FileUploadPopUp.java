package PopUps;

import org.openqa.selenium.By;
/*
 * Windows or OS popups.
 * to upload files,browse through file system.
 * 
 * Only driver.findElement(locator).sendkeys() are best.
 * multiple file selection is not supported.
 * 
 * AutoIT and Robot are not working in linux,mac. only for windows it works. hence not a good option
 * sikuli -> image based, capture the image of 'choose file', windows machine
 * the images are different in different os, it will not work on linux,mac,containers.
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

		//type = 'file' is mandatory to work with this kind of popups.
		// if not present, ask dev to add this attribute for selenium to work
		 driver.findElement(By.xpath("//input[@name='upfile']")).sendKeys("C:\\TestFiles\\sample.txt");
		
	}

}
