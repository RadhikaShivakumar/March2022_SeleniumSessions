package WebTableHandling;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoWebTable {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/indian-premier-league-2022-1298423/royal-challengers-bangalore-vs-punjab-kings-60th-match-1304106/full-scorecard");
	
		System.out.println(getScoreCard("Rishi Dhawan"));
		System.out.println(getScoreCard("Rahul Chahar"));
		//score card only from batting table
		driver.findElements(By.xpath("(//th[text()='BATTING'])[1]/ancestor::table//span[text()='Harpreet Brar']/ancestor::td//following-sibling::td"));
	}

	public static List<String> getScoreCard(String playerName) {
		System.out.println("Player Name: "+playerName);
		List<WebElement> scoreList = driver.findElements(By.xpath("//span[contains(text(),'"+playerName+"')]/ancestor::td/following-sibling::td"));
		
		List<String> scoreCardList = new ArrayList<String>();
		for(WebElement e: scoreList) {
			String text =e.getText();
			scoreCardList.add(text);
		}
		return scoreCardList;
	}
}
