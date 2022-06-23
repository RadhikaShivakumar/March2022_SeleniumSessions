package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 Quit and close
 
 1. With respect to session id:
 	After quit -> session id is null, server will be up and running but the browser is closed.
 	After close -> session id is still the same, but get noSuchSessionException, invalid session id error
 	
 	
 	how will you check server is running?
 	it will always open a new server with each run.
 	
 	
 	
 	
 */
public class QuitVsClose {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		//driver.get("https://www.google.com"); // NoSuchSessionException: Session ID is null
		
		//driver.close();
		//driver.getTitle(); NoSuchSessionException, invalid session id.
	
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
	}

}
