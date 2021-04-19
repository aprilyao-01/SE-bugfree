import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.EnableJUnit4MigrationSupport;

class TestMyMathModule {
	private static int input1;
	private static int input2;
	private static int input3;
	private static int input4;
	
	@BeforeAll
	static void setup() {
		input1 = 3;
		input2 = 6;
		input3 = 2000000000;
		input4 = - 2000000000;
	}
	
	
	
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	   void myMultiply() {
//	      int myAnswer = MathModule.myMultiply(input3, input2);
//	      assertEquals(12000000000,myAnswer);
		int myAnswer = 0;
	      try {
	          myAnswer = MathModule.myMultiply(input1, input2);
	      } catch(Exception e) { }
	      assertEquals(18, myAnswer);
	   }
	
	@Test
		void testError() {
        	int myAnswer = 0;
        	try {
        		myAnswer = MathModule.myMultiply(input2, input3);
        	} catch(Exception e) {
        		if(e.getClass() == Exception.class) {
        			System.out.println("Exception is thrown!");
                    return; // it passed
              }
          }
        fail("it failed");
    }

	@Test
	void testexpectiedfail() {
    	int myAnswer = 0;
    	try {
    		myAnswer = MathModule.myMultiply(input2, input4);
    	} catch(Exception e) {
    		if(e.getClass() == Exception.class) {
    			System.out.println("Exception is thrown!");
                return; // it passed
          }
      }
    fail("it failed");
}

}
