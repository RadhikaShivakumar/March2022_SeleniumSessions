package PopUps;
/* https://admin:admin@the-internet.herokuapp.com/basic_auth
 * Disadvantage: password is exposed,
 * it will not work,if pwd is having @ eg: admin@123, its a limitation, no solution
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopupConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		String username = "admin";
		String password = "admin";
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		
		
	}

}
