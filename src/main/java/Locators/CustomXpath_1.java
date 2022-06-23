package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 Xpath is not an attribute
 it is the address of the element in html dom.
 
 dom hierarchy:
 //html/body/div/div[2]/form/div[1]/div[3]/input
 //html/body/div/div[2]/ul/li/input
  
 absolute xpath: starts from starting element of DOM (Not recommended)
 
 Relative xpath: custom xpath: xpath Axes
 
  http://opencart.antropy.co.uk/index.php 
 xpath formula: 
 //htmltag[@attribute='value']
//input[@id='input-email']
 
//htmltag[@attribute='value' and @attr2='value']
//input[@id='input-email' and @name='email']

//htmltag[@attribute='value' and @attr2='value' and @attr3='value']
//input[@id='input-email' and @name='email' and @type='text']
 //input[@placeholder='Email Address']
 
contains() method - when have long descriptions and validate some portion of it
and in case of dynamic id.

//htmltag[contains(@attribute,'value')]

//input id = "test_123"
//input id = "test_123"
//input id = "test_123"
  
//input[contains(@id,'test_')]
 

//htmltag[contains(@attribute,'value') and @attr2='value']
//input[contains(@id,firstname') and @name='firstname'] 
 

 //input[@name='firstname'] and contains(@id,firstname')] 
//input[@name='firstname' and contains(@id,'firstname')]


//input[@name='firstname' and contains(@id,'firstname') and contains(@name,'first')]

//htmltag[contains(@attribute,'value') and contains(@attribute2,'value')]
 //input[contains(@id,firstname') and contains(@name,first')]


Based on Text:text():
====================
//htmltag[text()='value']
//h1[text()='Register Account']

//a[text()='Register']
 
//p[text()='Freshworks makes it easy and fast for businesses to delight their customers']

contains() with text():
====================
//htmltag[contains(text()='value')]
//p[contains(text()='easy and fast for businesses']
  

 //text() with attribute: can change sequence as well
 ============================================================
 //htmltag[text()='value' and @attr='value']
//a[text()='Forgotten Password' and @class='listgroup-item']


contains() with text() and attribute:
========================================
//htmltag[contains(@attr1,'value') and text()='value' and @attr2='value']
//a[contains(@href,''route=account/forgotten) and text()='Forgotten Password' and @class='listgroup-item']

All contains with attribute and text():
======================================
//a[contains(@href,''route=account/forgotten) and contains(text(),'Forgotten Password') and contains( @class,'listgroup-item')]

//starts-with(): dynamic id or values.
 * ==================================
//htmltag[starts-with(@attr,'value')]  
//input[starts-with(@name,'first')] 

//input[starts-with(@name,'first') and starts-with(@placeholder,'First')] 

starts-with and text():
======================
//htmltag[starts-with(text(),'value')]

//input[starts-with(text(),'Register']
 
ends-with is deprecated.



//index: when do not have any other attribute left then can use this.
=======

 //input[@class='form-control'] -- giving 6 matching elements
  * 
 To go to specific element:
 (//input[starts-with(text(),'Register']) --> called capture group
(//input[starts-with(text(),'Register'])[1] 
(//input[starts-with(text(),'Register'])[2] 
(//input[starts-with(text(),'Register'])[3] 
(//input[starts-with(text(),'Register'])[4] 
(//input[starts-with(text(),'Register'])[5] 
(//input[starts-with(text(),'Register'])[6] 


//position():
 (//input[starts-with(text(),'Register'])[postion()=2]  same as indexing

//to go to last element:
(//input[starts-with(text(),'Register'])[last()]
(//input[starts-with(text(),'Register'])[last()-1]
(//input[starts-with(text(),'Register'])[last()-2]
(//input[starts-with(text(),'Register'])[last()-3]
(//input[starts-with(text(),'Register'])[last()-4]
(//input[starts-with(text(),'Register'])[last()-5]

(Intv):
to verify help link is available in the last column and last link in footer section.


((//div[contains(@class,'navFooterLinkCol')])[last()]//li)[last()]/a

previous column
((//div[contains(@class,'navFooterLinkCol')])[last()-1]//li)[last()]/a

previous  previous column
((//div[contains(@class,'navFooterLinkCol')])[last()-2]//li)[last()]/a

Xpath Axes:
-----------
//Parent and child:
===================
//parent tag / child tag --> direct child element

//parent tag // child tag  --> direct + indirect child elements
 
//div[@id='content']/child::div --> with child keyword 
 
//div[@id='content']//child::form --> indirect child with child keyword
//div[@id='content']//form  --> same as above
 
//div[@id='content']//form/input[@name='email']


//child to Parent: backward traversing in xpath is allowed, practically not do this.
===================================================================================
//input[@name='email']/../../../.. --> and reach at the top of DOM.
 
single or two forward slash does not matter with parent keyword. this will give you  your immediate next parent. 
//input[@name='email']//parent::div
 
 
child to go to grandParent:
//input[@name='email']//ancestor::form


sibling:
=======
preceding -> previous sibling
//input[@name='email']/preceding-sibling::label[@class='control-label']

following sibling --> next sibling
//label[@class='control-label']/following-sibling:input[@name='email']

normalize-space() is a method when dom has leading or triling spaces

//label[normalize-space()='yes']




 */
public class CustomXpath_1 {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://opencart.antropy.co.uk/index.php");
	
		By firstname = By.xpath("//input[contains(@id,firstname') and contains(@name,first')]");
		
		
		
	}

}
