package TestNGSessions.DependsOnMethods;

/*
 DependsOnMethodsConcept:
 
 only if the dependent testcase is passed, then only the other testcases
 gets executed else will be skipped.
 
 is it a good practice --> No
 if tests are run in parallel mode -> then the tc will not work.
 
 According to unit test ,testNG rules -> should avoid depends on Methods
 
 AAA rule in unit test:
 Arrange Act assert pattern is one of the most fundamental and important
 patterns for writing maintainable unit tests.
 it states that you should separate each test into three phases(Arrange,Act,Assert)
 
 
 
 
 
 */
import org.testng.annotations.Test;


public class DependsOnMethodsConcept {

	@Test
	public void loginTest() {
		System.out.println("login test");
		int i=9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void dashboardTest() {
		System.out.println("dashboardTest");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void searchTest() {
		System.out.println("searchTest");
	}
}
