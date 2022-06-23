package TestNGSessions.DependsOnMethods;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	String name;
	
	//Here either NullPointerException or ArithmeticException should be seen else
	// test will fail.
	
//	@Test(expectedExceptions= {NullPointerException.class,ArithmeticException.class})

	@Test(expectedExceptions= {NullPointerException.class,ArithmeticException.class})

//	@Test(expectedExceptions= {Exception.class})
	public void loginTest() {
		System.out.println("login test");
		int i=9/3;
		
		ExpectedExceptionConcept obj = new ExpectedExceptionConcept();
		obj.name="Naveen";
		//obj = null;
		System.out.println(obj.name);
	}

}

