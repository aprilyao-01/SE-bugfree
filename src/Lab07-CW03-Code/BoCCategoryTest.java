import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BoCCategoryTest {

	BoCCategory category;
	private static BigDecimal bd;
	
	@BeforeAll
	static void initializeSetUp() {
		bd = new BigDecimal ("0.00");
	}
	
	
	@BeforeEach
	public void setUp() {
		category = new BoCCategory();
	}
	
	@AfterEach
	public void tearDown() {
		category = null;
	}
	 
	@Test
	@DisplayName("Display name of container")
	void testDefultConstructor() {
		System.out.println("test.");
		assertNotNull(category);
		
		assertEquals("New Category", category.CategoryName());
		assertEquals(bd, category.CategoryBudget());
		assertEquals(bd, category.CategorySpend());
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "food", "shopping", "transportation","this is a sentence" })
	void testSetAndGetCategoryName(String name) {
	   category.setCategoryName(name);
	   assertEquals(name, category.CategoryName());
	}
	
	
	@Test
	void testCategoryName() {
		
		
	}
	
	@Test
	void testtoString() {
		
		
	}

}
