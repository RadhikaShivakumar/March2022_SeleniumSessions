package Utilities;

import org.openqa.selenium.By;

public class XpathGen {

	//xpathExpression = //input[@id="{0}"] 
	// ... object array, instead of passing 10 values, all values passed will be stored in args array of type object(all
	//data types allowed)
	
	//To change values in xpath to generate dynamic xpath, values can be coming from xcel,api etc
	// //input[@id="{0}"]  --> 1 value
	//input[@id="{0}" and @name="{1}"]  --> 2 value
	//input[@id="{0}" and @name="{1}" and @type="{2}"]  -> 3 value
	
	
	public static By email = By.xpath(createXpath("//input[@name='{0}']","naveen@gmail.com"));
	
	public static String createXpath(String xpathExp,Object...args) {
		for(int i =0;i<args.length;i++) {
			xpathExp = xpathExp.replace("{"+i+"}", (CharSequence)args[i]);
		}
		return xpathExp;
	}
	
	
	public static void main(String[] args) {
		String x1 = createXpath("//input[@id='{0}']","test");
		System.out.println(x1);
		
		
		String x2 = createXpath("//input[@id='{0}' and @name='{1}']","email","user");
		System.out.println(x2);
		
		String x3 = createXpath("//input[@id='{0}' and @name='{1}' and @type='{2}']","email","user","button");
		System.out.println(x3);
		
		System.out.println(email.toString().substring(email.toString().indexOf("//"))); //begin printing from //
		
	}

}
