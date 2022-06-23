package TestNGSessions.Priority;

/*
 priority:
 ========
 1. if no priority, then tests are run in alphabetical order
 2. priority numbers are given, then runs according to the smallest number to bigger priority
 3. priority = zero can be given and it will be run first
 4. Negative numbers = it will be run first as -ve numbers are least
 5. All same priority: priority is nullified and then tests are run in alphabetical order
 6. Tests with no priority and some tests with priority, then preference
 	is given to tests with no priority and then for tests with priority.
 
 7. Tests with no priority and some tests with same priority, then preference
 	is given to tests with no priority and then for tests with priority, since priority is same,
 	priority is nullified and run according to alphabetical order.
 	
 8.priority as 'characters', as char come from numeric family and its ascii value is considered.
 
 9. combination of numbers and characters, lesser numbers are given priority.
 	characters start from 97..104
 
 */
import org.testng.annotations.Test;

public class PriorityTest {

	@Test(priority=1)
	public void a_test() {
		System.out.println("a test");
	}
	

	@Test(priority='b')
	public void b_test() {
		System.out.println("b test");
	}

	@Test(priority='a')
	public void c_test() {
		System.out.println("c test");
	}

	@Test(priority='d')
	public void d_test() {
		System.out.println("d test");
	}
	
	@Test(priority='e')
	public void e_test() {
		System.out.println("e test");
	}
}
