package FrameConcept;

/*
 Frames:
 ------
is a type of web element containing  multiple web elements.

 frame or iframe, method to handle is same
 
 
 
 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameDemo {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");

		//driver.switchTo().frame(2); // 3rd frame
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.name("main")));
		
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		driver.switchTo().defaultContent(); //to move to immediate frame or main document
		//selenium 4x:
		//frames inside frame inside frame
		driver.switchTo().parentFrame(); //when have parent and child frames,then it will switch back to the parent frame.
		
	}

}

//Assignment: 