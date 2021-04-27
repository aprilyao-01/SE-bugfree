package test;
import cw3.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class BoCAppTest {

	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeAll
	public static void setUpStreams() {
	System.setOut(new PrintStream(outContent));
	}
    // Function: AddTransaction()
	// Contributor: Jiachen Zhang
	@Test
	void testAddTransaction() throws IllegalAccessException,
	IllegalArgumentException,
	InvocationTargetException,
	NoSuchMethodException,
	SecurityException {
		
		BoCApp addt = new BoCApp();
		BoCApp.setup();
		Method m = BoCApp.class.getDeclaredMethod("AddTransaction", Scanner.class);
		m.setAccessible(true);
		String input = System.lineSeparator() + "abc" + System.lineSeparator() + "1000" + System.lineSeparator()+ "1" + System.lineSeparator()  ;
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner in2 = new Scanner(System.in);
        m.invoke(addt, in2);
        
		assertEquals("What is the title of the transaction?" + System.lineSeparator() + 
			         "What is the value of the transaction?" + System.lineSeparator() + 
			         "[abc(1000)was added to 1]", outContent.toString());}
		

	
	// Function: AddCategory(Scanner in)
	// Contributor: Jing ZHANG
	
	// creating input streams for normal input and abnormal input
	static Stream<Arguments> normalIn(){
		return Stream.of(
				Arguments.of((Object) new Scanner ("\nCloth\n100.00\n"))
		);
	}
	
	static Stream<Arguments> abnormalIn(){
		return Stream.of(
				Arguments.of((Object) new Scanner ("\nThis is greater than 15 characters\n100.00\n")),
				Arguments.of((Object) new Scanner ("\nThis is greater than 15 characters\n-1234\n")),
				Arguments.of((Object) new Scanner ("\nCloth\n-1234\n"))
		);
	}

	// testing if this function work well with normal input
	@ParameterizedTest
	@MethodSource("normalIn")
	public void AddCategoryTests1(Scanner in) throws IllegalAccessException,
	IllegalArgumentException,
	InvocationTargetException,
	NoSuchMethodException,
	SecurityException {
		// create object
		BoCApp testforBC = new BoCApp();
		ArrayList<BoCCategory> test = new ArrayList<BoCCategory>();
		
		BoCApp.setup();
		Method m = BoCApp.class.getDeclaredMethod("AddCategory", Scanner.class);//declare which method you want to test
		m.setAccessible(true);//set the accessible to true, then you can access the method
		m.invoke(testforBC, in);
		test = testforBC.UserCategories;
		
		assertEquals("What is the title of the category?"+System.lineSeparator() +
                     "What is the budget for this category?"+System.lineSeparator() +
				     "[Category added]"+System.lineSeparator() +
				     "1) Unknown(¥0.00) - Est. ¥850.00 (¥-850.00 Remaining)" + System.lineSeparator() +
				     "2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)" + System.lineSeparator() +
				     "3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)" + System.lineSeparator() +
				     "4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)" + System.lineSeparator() +
		             "5) Cloth(¥100.00) - Est. ¥0.00 (¥100.00 Remaining)" + System.lineSeparator(), outContent.toString());
		BigDecimal expectedcb = new BigDecimal("100.00");
		assertEquals("Cloth", test.get(4).CategoryName());
		assertEquals(expectedcb, test.get(4).CategoryBudget());
		outContent.reset();
		
		 
	}
	
	//testing if this function work well with abnormal inputs
	//three cases:
	//1)test if it's not allowed to add a new category with a abnormal title(greater than 15 characters)
	//2)test if it's not allowed to add a new category with a abnormal title(greater than 15 characters) and a abnormal budget(<=0)
	//3)test if it's not allowed to add a new category with a normal title and a abnormal budget(<=0)
	@ParameterizedTest
	@MethodSource("abnormalIn")
	public void AddCategoryTests2(Scanner in) throws IllegalAccessException,
	IllegalArgumentException,
	InvocationTargetException,
	NoSuchMethodException,
	SecurityException {
		//create object
		BoCApp testforBC = new BoCApp();
		ArrayList<BoCCategory> test = new ArrayList<BoCCategory>();	
		BoCApp.setup();
		Method m = BoCApp.class.getDeclaredMethod("AddCategory", Scanner.class);//declare the AddCategory method 
		m.setAccessible(true);//set the accessible to true
		m.invoke(testforBC, in);
		test = BoCApp.UserCategories;
		assertTrue(test.get(4) == null); //test to see if the method create the wrong category
		outContent.reset();
		
		 
	}

	// Function: AddCategory(Scanner in)
	// Contributor: Jing ZHANG
}