package coen352.ch4.list;




import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * All of the code written under coen352.ch4.list was give to us on moodle
 */

public class ListTestRunner {
   
	
	public static void main(String[] args) {
	   
	   ListTestRunner.runManualTest();
	   
	   //ListTestRunner.runJUnit5();
	   
   }
   
   public static void runManualTest() {
	   ListJUnitTest t = new ListJUnitTest();
	   ListJUnitTest.setUp();
	   t.testAppend();
	   t.testFind();
	   t.testListOfObjects();
	   t.testNext();
	   t.testRemove();
	   t.testNext();
   }
   
   public static void runJUnit5() {
	   JUnitCore jUnitCore = new JUnitCore();
	   Result result = jUnitCore.run(ListJUnitTest.class);
	   System.out.printf("Test ran: %s, Failed: %s%n",
		          result.getRunCount(), result.getFailureCount());
	
       for (Failure failure : result.getFailures())
       {
           System.out.println(failure.toString());
       }
	   

   }
}