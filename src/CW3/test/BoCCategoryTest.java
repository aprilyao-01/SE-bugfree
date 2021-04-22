import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BoCCategoryTest {

//these two below defined by xingyan Qu
	private static BigDecimal budget;
	private static BigDecimal newSpend;
//here below defined by siyu Yao
	BoCCategory category;
	BoCCategory category2;
	private static BigDecimal bd;
	private static BigDecimal spent1;
	private static BigDecimal spent2;
	
	@BeforeAll
	static void initializeSetUp() {
		bd = new BigDecimal ("0.00");
		spent1 = new BigDecimal("2573.42");
		spent2 = new BigDecimal("3281.07");
		
	}
	
	
	@BeforeEach
	public void setUp() {
		category = new BoCCategory();
	}
	
	@AfterEach
	public void tearDown() {
		category = null;
	}
//siyu Yao	 
	@Test
	void testDefultConstructor() {
		assertNotNull(category);
		
		assertEquals("New Category", category.CategoryName());
		assertEquals(bd, category.CategoryBudget());
		assertEquals(bd, category.CategorySpend());
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "food", "shopping", "transportation", "this is a sentence more than 15 characters", "Unknown", "   " })
	void testSetAndCategoryName(String name) {
		category.setCategoryName(name);
		
	 // This test tests the category name is at most 15 characters
		assertFalse(category.CategoryName().length() > 15);
	
	 // This test tests the category name cannot set to be "Unknown"
		assertNotEquals("Unknown",category.CategoryName());
	
	 // This test tests the category name cannot set to be blank 
		assertFalse(category.CategoryName().isBlank());
	   
	// Other compliance with the specification
	   assertEquals(name, category.CategoryName());
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "food", "shopping", "transportation"})
	void testCategoryName(String name) {
		category.setCategoryName(name);
		BoCCategory category2 = new BoCCategory(name);
		/*
		 * This test is to insure the id of two object are not the same
		 * if their CategoryName is same, then method works
		 */
		assertNotSame(category,category2);
		assertEquals(category.CategoryName(),category2.CategoryName());
		
		// This test if CategoryName() use the same id address with the one that use to set
		String get = category.CategoryName();
		assertSame(get,name);
	}
	
	@ParameterizedTest
	@CsvSource({"testname, 3000.00, 2573.42","testname2, 3000.00, 3281.07"})
	void testtoString(String name, BigDecimal budget, BigDecimal spent) {
		/* 
		 * The first value of spent is less than budget
		 * and second value of spent is more than budget
		 * it should return two different formats 
		 */
		category.setCategoryName(name);
		category.setCategoryBudget(budget);
		category.addExpense(spent);
		String expect1 = "testname(¥3000.00) - Est. ¥2573.42 (¥426.58 Remaining)";
		String expect2 = "testname(¥3000.00) - Est. ¥3281.07 (¥281.07 Overspent)";
		if (spent.compareTo(spent1) == 0) {
			assertEquals(expect1,category.toString());
		} else if (spent.compareTo(spent2) == 0) {
			assertEquals(expect2,category.toString());
		}
	}
//Xingyan Qu
	//4
	@ParameterizedTest
	@CsvSource({"0.00", "-597.03","2220.00"})
    void testCategoryBudget(BigDecimal budget) {
		BoCCategory second = new BoCCategory();
		second.setCategoryBudget(budget);
		
		if(budget.compareTo(new BigDecimal("0.00")) == 1) {
			
			assertEquals(budget, second.CategoryBudget());
			
		}else
		{
			assertEquals(new BigDecimal("0.00"), second.CategoryBudget());
		}
	}
	//5
	@Test
	public void testCategorySpend() {
		BoCCategory fourth = new BoCCategory();
		
		//set budget
		budget = new BigDecimal("3000.00");
		fourth.setCategoryBudget(budget);
		//set a new spend
		newSpend = new BigDecimal("234.00");
		fourth.addExpense(newSpend);
		
		if(newSpend.compareTo(new BigDecimal("0.00")) == 1) {
			
			 assertEquals(newSpend, fourth.CategorySpend());
		}
		else {
			assertEquals(new BigDecimal("0.00"), fourth.CategorySpend());
		}
		
		 //set a remove
		 BigDecimal remove = new BigDecimal("-300.00");
		 fourth.removeExpense(remove);
		 
		 if(remove.compareTo(newSpend) == -1 && remove.compareTo(new BigDecimal("0.00")) == 1) {
			 BigDecimal result = newSpend.subtract(remove);
			 assertEquals(result, fourth.CategorySpend());
		 }
		 else 
		 {
			 assertEquals(newSpend, fourth.CategorySpend());
		 }

	}
	
	//8
	@ParameterizedTest
	@CsvSource({"2300.00","-5.00","6000.00"})
	void testaddExpense(BigDecimal newSpend){
		BoCCategory first = new BoCCategory();
		
		budget = new BigDecimal("3000.00");
		first.setCategoryBudget(budget);
		
		//the total spend before
		BigDecimal before = first.CategorySpend();
		
		first.addExpense(newSpend);
		
        if(newSpend.compareTo(new BigDecimal("0.00")) == 1) 
        {        	
        	BigDecimal after = before.add(newSpend);
			assertEquals( after, first.CategorySpend());
			
		}else {
			assertEquals(before, first.CategorySpend());
		}	
	}
	//9
	@ParameterizedTest
	@CsvSource({"5.00","-5.00","6000.00"})
	void testremoveExpense(BigDecimal remove){
		BoCCategory third = new BoCCategory();
				
		budget = new BigDecimal("3000.00");
		third.setCategoryBudget(budget);

		BigDecimal preSpend = new BigDecimal("500.00");
		third.addExpense(preSpend);
		
		
		BigDecimal before = third.CategorySpend();
		
		third.removeExpense(remove);
		
		if(remove.compareTo(new BigDecimal("0.00")) == 1 && remove.compareTo(before) == -1) {
			BigDecimal after = before.subtract(remove);
			
			assertEquals( after, third.CategorySpend());
			}
		else {
			assertEquals( before, third.CategorySpend());
		}
	}	

}
