package MouseOperations;

/*
 * build method will collect all methods in the exact order mentioned and readies it for perform.
 * build the actions in the same sequence.
 * * perform method will perform all methods in the order on webpage.
 * single action, only perform is sufficient.
 * for multiple actions then too build is not mandatory. only perform will work
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		WebElement source1 = driver.findElement(By.id("draggable"));
		WebElement target1 = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
//		act
//			.clickAndHold(source)
//				.moveToElement(target)
//							.release().build().perform();
		
		//act.dragAndDrop(source, target).perform();
		By source = By.id("draggable");
		By target = By.id("droppable");
		dragAndDropAction(source,target);
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void dragAndDropAction(By source,By target) {
		Actions act = new Actions(driver);
		act.clickAndHold(getElement(source)).moveToElement(getElement(target)).build().perform();
	}
}
