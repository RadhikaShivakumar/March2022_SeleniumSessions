package TestNGSessions.DependsOnMethods;

/*
 InvocationCount: to run tests n number of times.
 Test will be run the number of times specified.
 
 will be used in API testing, when need to create many users,accounts
 it is not parallel exceution, the tests are run one by one.
 
 It is not used much in practical scenarios.
 
 */
import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount =10)
	public void createUserTest() {
		System.out.println("create User test");
	}
}
