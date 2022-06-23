package WaitConcept;

/*
 * Types of Waits:
 * 1. Static wait: Thread.sleep(4000)
 * 2. Dynamic wait: time out = 10 sec
 *    if element found in 2 seconds then rest of the 8 sec is ignored
 *    if all 10 second is used it then throws error.
 *    
 *    2.a) Implicitly wait
 *    2.b) Explicitly wait
 *          2.b.1: WebDriverWait
 *          2.b.2: FluentWait
 *          
 *      WebDriverWait is a class and is extending FluentWait class and it implents  Wait(Interface) --> method --> until() method   
 *      WebDriverWait(C) ---> extends --> FluentWait(C) --> implements --> Wait(I) --> method --> until();
 *      the until method is overridden in FluentWait class
 *      
 *      WebDriverWait does not have any methods and it inherits methods from FluentWait.
 */
public class WaitTypeConcept {

	public static void main(String[] args) {
		

	}

}
