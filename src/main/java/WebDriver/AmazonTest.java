package WebDriver;

import Utilities.BrowserUtil;

public class AmazonTest {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		brUtil.init_driver("chrome");
		brUtil.launchUrl("www.amazon.com");
		
		String title = brUtil.getPageTitle();
		System.out.println(title);
		if(title.contains("Amazon")) {
			System.out.println("Correct title");
		}
		
		String url = brUtil.getPageUrl();
		if(url.contains("amazon")) {
			System.out.println("url is correct");
		}
		
		brUtil.quitBrowser();
		
		
		
	}

}
