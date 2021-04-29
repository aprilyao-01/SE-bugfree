package test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import cw3.BoCApp;
import cw3.BoCCategory;
import cw3.BoCTransaction;


class BoCAppTest {

	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	
	
	// Following variables are created by Siyu Yao
	BoCApp boc;
	private static BigDecimal beCat;	// refer to  CategorySpend before and after method calls
	private static BigDecimal afCat;
	private static int beTran;			// refer to  transactionCategory before and after method calls
	private static int afTran;
	private static ArrayList<BoCTransaction> beforeTran;	// This is the original array list that not be modified
	private static ArrayList<BoCCategory> beforeCat;
	private static ArrayList<BoCTransaction> afterTran;		// This is the new array list after modified
	private static ArrayList<BoCCategory> afterCat;
	private static String confirmation;
	
	
	
	@BeforeAll
	public static void setUpStreams() 
	{
		System.setOut(new PrintStream(outContent));
		BoCApp.setup();
		confirmation = "The new category it belongs to ";
	}
	@AfterAll
	public static void cleanUpStreams() 
	{
	      System.setOut(null);
	}

	
	@BeforeEach
	public void setUp() {
		boc = new BoCApp();
		outContent.reset();	
	}
	
	@AfterEach
	public void tearDown() {
		boc = null;
	}
	
	

	// Function: ListTransactions()
	// Contributor: Xingyan Qu
	@Test
		void testListTransactions() 
		{
			
			BoCApp first = new BoCApp();
			first.setup();
			
			outContent.reset();
			
			first.ListTransactions();
			assertEquals("1) Rent(Unknown) - ¥850.00\n"
					   + "2) Phone Bill(Bills) - ¥37.99\n"
					   + "3) Electricity Bill(Bills) - ¥75.00\n"
					   + "4) Sainsbury's Checkout(Groceries) - ¥23.76\n"
					   + "5) Tesco's Checkout(Groceries) - ¥7.24\n"
					   + "6) RockCity Drinks(Social) - ¥8.50\n"
					   + "7) The Mooch(Social) - ¥13.99\n",outContent.toString());	
		}

	// Function: CategoryOverview()
	// Contributor: Xingyan Qu
	@Test
		void testCategoryOverview() 
		{
		
			BoCApp first = new BoCApp();
			first.setup();		
			outContent.reset();
			
			first.CategoryOverview();
			assertEquals( "1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)\n"
					    + "2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)\n"
					    + "3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)\n"
						+ "4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)\n"
						+ "",outContent.toString());		
		}


	// Function: CategoryOverview()
	// Contributor: Xingyan Qu
	@ParameterizedTest
	@ValueSource(ints = { 1,2,3,4 })
		void testListTransactionsForCategory(int catI) 
		{
			outContent.reset();
			
			BoCApp first = new BoCApp();
			first.setup();
			first.ListTransactionsForCategory(catI);
			if(catI==1)
				assertEquals( "Unknown:\n1) Rent(Unknown) - ¥850.00\n",outContent.toString());
			if(catI==2)
				assertEquals( "Bills:\n2) Phone Bill(Bills) - ¥37.99\n"
						    + "3) Electricity Bill(Bills) - ¥75.00\n" ,outContent.toString());
			if(catI==3)
				assertEquals( "Groceries:\n4) Sainsbury's Checkout(Groceries) - ¥23.76\n"
						    + "5) Tesco's Checkout(Groceries) - ¥7.24\n" ,outContent.toString());
			if(catI==4)
				assertEquals( "Social:\n6) RockCity Drinks(Social) - ¥8.50\n"
						    + "7) The Mooch(Social) - ¥13.99\n" ,outContent.toString());
			outContent.reset();
		}



    // Function: AddTransaction()
	// Contributor: Jiachen Zhang
	@ParameterizedTest
	@ValueSource(ints = {0,1})
	void testAddTransaction(int new1) throws IllegalAccessException,
	IllegalArgumentException,
	InvocationTargetException,
	NoSuchMethodException,
	SecurityException {
		if(new1 ==0)
		{
		BoCApp addt = new BoCApp();
		outContent.reset();
		BoCApp.setup();
		Method m = BoCApp.class.getDeclaredMethod("AddTransaction", Scanner.class);
		m.setAccessible(true);
		String input = System.lineSeparator() + "abc" + System.lineSeparator() + "1" + System.lineSeparator()+ "1000" + System.lineSeparator()  ;
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner in2 = new Scanner(System.in);
        m.invoke(addt, in2);
        
		assertEquals("What is the title of the transaction?" + System.lineSeparator() +      
			         "What is the category ID of the transaction?" + System.lineSeparator() +
			         "(Press \"Enter\" will set to \"Unknown\" automatically)" + System.lineSeparator() +
			         "What is the value of the transaction?" + System.lineSeparator() + 
			         "abc(¥1000) was added to Unknown"+ System.lineSeparator(), outContent.toString());}
		if(new1 ==1)
		{
			BoCApp addt = new BoCApp();
			outContent.reset();
			BoCApp.setup();
			Method m = BoCApp.class.getDeclaredMethod("AddTransaction", Scanner.class);
			m.setAccessible(true);
			String input = System.lineSeparator() + "abc" + System.lineSeparator() + "" + System.lineSeparator()+ "1000" + System.lineSeparator()  ;
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			Scanner in2 = new Scanner(System.in);
	        m.invoke(addt, in2);
	        
			assertEquals("What is the title of the transaction?" + System.lineSeparator() + 
				         "What is the category ID of the transaction?" + System.lineSeparator() +
				         "(Press \"Enter\" will set to \"Unknown\" automatically)" + System.lineSeparator() +
				         "What is the value of the transaction?" + System.lineSeparator() + 
				         "abc(¥1000) was added to Unknown"+ System.lineSeparator(), outContent.toString());}
	}
		

	// Function: private static void ChangeTransactionCategory(Scanner in)
	// Contributor: Siyu Yao
	
	static Stream<Arguments>arguments(){
		return Stream.of(
				Arguments.of((Object) new Scanner ("\n1\n2\n"), 1, 2),
				Arguments.of((Object) new Scanner ("\n2\n2\n"), 2, 2),
				Arguments.of((Object) new Scanner ("\n4\n3\n"), 4, 3)
				//Arguments.of((Object) new Scanner ("\n \n\n"),'')
		);
	}
	
	@ParameterizedTest
	@MethodSource("arguments")
	void testChangeTransactionCategory(Scanner in, int tID, int newCat)throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
   		
		// Get the original value after created class
		beforeTran = boc.UserTransactions;		// This is the original array list that not be modified
		beforeCat = boc.UserCategories;
		beTran = beforeTran.get(tID).transactionCategory();	 // This is the original transaction category that before method calls (not be modified)
		beCat = beforeCat.get(newCat).CategorySpend();		// This is the original category spend that before method calls (not be modified)
		
		
		// Get the private method and call the method
		Method method = boc.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
		method.setAccessible(true);
   		method.invoke(boc, in);
   		
   		
   		// Get the modified value after method calls
   		afterTran = boc.UserTransactions;		// This is the new array list after modified
   		afterCat = boc.UserCategories;
   		afTran = afterTran.get(tID).transactionCategory();		// This is the new transaction category that after method calls (be modified)
   		afCat = afterCat.get(newCat).CategorySpend();			// This is the new category spend that after method calls (be modified)
   		
   		
   		/*
   		 *  After the method calls, the CategorySpend and transactionCategory are changed,
   		 *  so before and after CategorySpend and transactionCategory should not be equal 
   		 */
   		assertNotEquals(0, beCat.compareTo(afCat));
   		assertNotEquals(beTran, afTran);
   		
   		
   		/*
   		 * The ClassDescription.pdf specify that this function should print a confirmation of the name of the new category it belongs to,
   		 * so the print information should contains String "The new category it belongs to ",
   		 * which has be initialized as 'String confirmation'
   		 */
   		assertThat(outContent.toString(), containsString(confirmation)); 
  
	}
	
	
	
	
	// Function: AddCategory(Scanner in)
	// Contributor: Jing ZHANG
	/* Before this Integration test, we have already test the method in BoCCategory
	 * Thus, in this Integration test, we will not test the abnormal input
	 * because the method in BoCCategory should handle illegal input
	 * creating input streams for normal input and abnormal input
	 */
	
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
	// This test aims to test whether it could add the new category successfully or not
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
		
		// test whether it could add the new category successfully or not
		BigDecimal expectedcb = new BigDecimal("100.00");
		assertEquals("Cloth", test.get(4).CategoryName());
		assertEquals(expectedcb, test.get(4).CategoryBudget());
		
		outContent.reset();
		
		 
	}
	
	// testing if this function work well with normal input
	// This test aims to test if this function have the correct output
	@ParameterizedTest
	@MethodSource("normalIn")
	public void AddCategoryTests2(Scanner in) throws IllegalAccessException,
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
		
		// test if this function have the correct output
		assertEquals("What is the title of the category?"+System.lineSeparator() +
                     "What is the budget for this category?"+System.lineSeparator() +
				     "[Category added]"+System.lineSeparator() +
				     "1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)" + System.lineSeparator() +
				     "2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)" + System.lineSeparator() +
				     "3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)" + System.lineSeparator() +
				     "4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)" + System.lineSeparator() +
		             "5) Cloth(¥100.00) - ¥0.00 (¥100.00 Remaining)" + System.lineSeparator(), outContent.toString());
		
		outContent.reset();
		
		 
	}
	
	// Function: main(String[] args)
	// Contributor: Xingyan Qu

	//   test 1 :
	//list all transactions and then change transaction "phone bill" to category "Unknown", then exit		
	@Test
	void testMain_1() {
		outContent.reset();
		
		String input = "T"+"\r"+"C"+"\r"+"2"+"\r"+"0"+"\r"+"X";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        BoCApp.main(null);

	assertEquals( "1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)\n"
			    + "2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)\n"
			    + "3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)\n"
				+ "4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)\n"
	    		+ "\n"
	    		+ "What do you want to do?\n"
	    		+ " T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it\n"
	    		+ "1) Rent(Unknown) - ¥850.00\n"
				+ "2) Phone Bill(Bills) - ¥37.99\n"
				+ "3) Electricity Bill(Bills) - ¥75.00\n"
				+ "4) Sainsbury's Checkout(Groceries) - ¥23.76\n"
			    + "5) Tesco's Checkout(Groceries) - ¥7.24\n"
			    + "6) RockCity Drinks(Social) - ¥8.50\n"
			    + "7) The Mooch(Social) - ¥13.99\n"
	    		+ "\n"
	    		+ "What do you want to do?\n"
	    		+ " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it\n"
	    		+ "Which transaction ID?\n"
				+ "	- Phone Bill - ¥37.99\n"
				+ "Which category will it move to?\n"
				+ "1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)\n"
				+ "2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)\n"
				+ "3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)\n"
				+ "4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)\n"
				+"The new category it belongs to is: Unknown\n"
				+ "[Remove done]:\n"
				+"1) Unknown(¥0.00) - ¥887.99 (¥887.99 Overspent)\n"
			    + "2) Bills(¥120.00) - ¥75.00 (¥45.00 Remaining)\n"
			    + "3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)\n"
				+ "4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)\n"
	    		+ "\n"
				+ "What do you want to do?\n"
				+ " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it\n"
				+ "Goodbye!\n"
				+ "",outContent.toString());
		}
	
	//  test 2:
	//add a new category called "study" with a budget 900
	
	@Test
	void testMain_2() {
		outContent.reset();
		
		String input = "N"+"\r"+"study"+"\r"+"900"+"\r";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        BoCApp.main(null);
        assertEquals( "1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)\n"
				    + "2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)\n"
				    + "3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)\n"
					+ "4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)\n"
	        		+ "\n"
	        		+ "What do you want to do?\n"
	        		+ " T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it\n"
	        		+ "What is the title of the category?\n"
	        		+ "What is the budget for this category?\n"
	        		+ "[Category added]\n"
	        		+ "1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)\n"
				    + "2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)\n"
				    + "3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)\n"
					+ "4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)\n"
	        		+ "5) study(¥900) - ¥0.00 (¥900.00 Remaining)\n"
	        		+ "\n"
	        		+ "What do you want to do?\n"
	        		+ " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it\n"
	        		+ "",outContent.toString());
	}  

	//  test 3:
	//add a new transaction called "drink" with value 50 to category "Social" and show transactions in "Social"

	@Test
	void testMain_3() {
		outContent.reset();
		
		String input = "A"+"\r"+"drink"+"\r"+"3"+"\r"+"50"+"\r"+"3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        BoCApp.main(null);
        assertEquals("1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)\n"
			    + "2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)\n"
			    + "3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)\n"
				+ "4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)\n"
        		+ "\n"
        		+ "What do you want to do?\n"
        		+ " T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it\n"
        		+ "What is the title of the transaction?\n"
        		+ "What is the category of the transaction?\n"
        		+"(Press \"Enter\" will set to \"Unknown\" automatically)\n"
        		+ "What is the value of the transaction?\n"
        		+ "drink(¥50) was added to Groceries\n"
        		+ "\n"
        		+ "What do you want to do?\n"
        		+ " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it\n"
        		+ ""
        		+"Groceries:\n4) Sainsbury's Checkout(Groceries) - 楼23.76\n"
			    + "5) Tesco's Checkout(Groceries) - 楼7.24\n"
        		+ "8) drink(Groceries) - 楼50\n "
			    + "\n"
        		+ "What do you want to do?\n"
        		+ " O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it\n"
        		+ "",outContent.toString());
	}
}
