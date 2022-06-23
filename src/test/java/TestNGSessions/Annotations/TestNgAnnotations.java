package TestNGSessions.Annotations;

import org.testng.annotations.*;

/*
 Annotations: is a specific keyword starting with the keyword @ and is associated
 with a method.
 
 can write only 1 @BeforeSuite,@BeforeTest,@BeforeClass,@BeforeMethod
 
Can write n number of @Test testcases.

Tests are run in the following sequence.
 
 @BeforeSuite
 @BeforeTest
 @BeforeClass
 @BeforeMethod
 
 Tests are run based on alphabetical order
 
 @BeforeMethod
 @TEst
 @AfterMethod
 
 Again @BeforeMethod will be run before the next @Test and is run
 before each @Test  @BeforeMethod will be executed.
 
@AfterClass
@AfterTest
@AfterSuite


// Test Results

	BeforeSuite -- DB connection
	BeforeTest -- create user
	BeforeClass -- launchBrowser

		BeforeMethod -- loginToApp
		getPageTitleTest
		AfterMethod -- logout
		
		BeforeMethod -- loginToApp
		searchTest
		AfterMethod -- logout
		
		BeforeMethod -- loginToApp
		userInfoTest
		AfterMethod -- logout
		
	AfterClass -- closeBrowser
	AfterTest -- deleteUser
	AfterSuite -- disconnectDB
	
PASSED: searchTest
PASSED: getPageTitleTest
PASSED: userInfoTest


 */
public class TestNgAnnotations {

	@BeforeSuite //1
	public void DBConnection() {
		System.out.println("BeforeSuite-DB connection");
	}
	
	@BeforeTest  //2
	public void createUser() {
		System.out.println("BeforeTest-create user");
	}
	
	@BeforeClass  //3
	public void launchBrowser() {
		System.out.println("BeforeClass-launchBrowser");
	}
	
	@BeforeMethod  //4 //7 //10
	public void loginToApp() {
		System.out.println("BeforeMethod-loginToApp");
	}
	
	//Good practice to write Test at the end, industry practice
	@Test //5
	public void getPageTitleTest() {
		System.out.println("getPageTitleTest");
	}
	
	//Can write n number of @Test testcases.
	
	@Test //11
	public void userInfoTest() {
		System.out.println("userInfoTest");
	}
	 
	@Test //8
	public void searchTest() {
		System.out.println("searchTest");
	}
	
	@AfterMethod //6 //9 //12
	public void logout() {
		System.out.println("AfterMethod-logout");
	}
	@AfterClass //13
	public void closeBrowser() {
		System.out.println("AfterClass-closeBrowser");
	}
	@AfterTest //14
	public void deleteUser() {
		System.out.println("AfterTest-deleteUser");
	}
	@AfterSuite //15
	public void disconnectDB() {
		System.out.println("AfterSuite-disconnectDB");
	}
}
