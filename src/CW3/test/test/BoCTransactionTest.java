package test;
import cw3.BoCTransaction;
import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BoCTransactionTest {
	// test function: BoCTransaction
	// tester: Jiachen Zhang
	@Test
	void testBoCTransaction() {
		BoCTransaction myAnswer1 = new BoCTransaction();
		assertEquals("[Pending Transaction]",myAnswer1.transactionName());
	}
    // test function: BoCTransaction
	// tester: Jiachen Zhang
	@ParameterizedTest
	@ValueSource(ints = {0,1,2})
	void testBoCTransaction1(int new1) {
		
		if(new1 ==0)
		{
		BigDecimal value = new BigDecimal("22");
		BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1);
		Date myDate = new Date();
		assertEquals(myDate,myAnswer1.transactionTime());
		}
		
		if(new1 ==1)
		{
		BigDecimal value = new BigDecimal("22");
		BoCTransaction myAnswer2 = new BoCTransaction("abcdfghjkloiuygfdfasfsssdfrfrwfwwedewfds", value, 1);
		assertEquals("abcdfghjkloiuygfdfasfsssd", myAnswer2.transactionName());
		}
		if(new1 == 2)
		{
		BigDecimal value2 = new BigDecimal("-10");
		BoCTransaction myAnswer3 = new BoCTransaction("abc", value2, 1);
		assertEquals(null, myAnswer3.transactionValue());
		}
	}
	// test function: TransactionName
	// tester: Wangji Wei
	@Test
	void testTransactionName() {
		String name = "abcd";
		BoCTransaction account = new BoCTransaction();
		account.setTransactionName(name);
		// check whether name has the same type after passing the function
		assertSame(name,account.transactionName());
	}
	// test function: TransactionValue
	// tester: Wangji Wei
	@Test
	void testTransactionValue() {
		BigDecimal value = new BigDecimal(8888.00);
		BoCTransaction account = new BoCTransaction();
		account.setTransactionValue(value);
		// check whether value has the same type after passing the function`
		assertSame(value,account.transactionValue());
	}
	// test function: TransactionCategory
	// tester: Wangji Wei
	@Test
	void testTransactionCategory() {
		int category = 88;
		BoCTransaction account = new BoCTransaction();
		account.setTransactionCategory(category);
		// check whether category has the same type after passing the function
		assertSame(category,account.transactionCategory());
	}
	// test function: TransactionTime
	// tester: Wangji Wei
	@Test
	void testTransactionTime() {
		Date time = new Date();
		BoCTransaction account = new BoCTransaction();
		account.setTransactionTime(time);
		// check whether time has the same type after passing the function
		assertSame(time,account.transactionTime());
	}
	// test function: setTransactionName
	// tester: Wangji Wei
	@Test
	void testSetTransactionName() {
		// normal test
		String name1 = "aaaa";
		BoCTransaction account1 = new BoCTransaction();
		account1.setTransactionName(name1);
		assertEquals(account1.transactionName(),name1);
		// unnormal test 1:
		// long character parameter
		String name2 = "abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde";
		BoCTransaction account2 = new BoCTransaction();
		account2.setTransactionName(name2);
		assertEquals(account2.transactionName(),"abcdeabcdeabcdeabcdeabcde");
		// unnormal test 2:
		// set the name again
		String name3 = "abcde";
		String name4 = "abcd";
		BoCTransaction account3 = new BoCTransaction();
		account3.setTransactionName(name3);
		account3.setTransactionName(name4); // set the name again
		assertEquals(account3.transactionName(),name3);
	}
	// test function: setTransactionValue
	// tester: Wangji Wei
	@Test
	void testSetTransactionValue() {
		// normal test
		BigDecimal value1 = new BigDecimal(8888.00);
		BoCTransaction account1 = new BoCTransaction();
		account1.setTransactionValue(value1);
		assertEquals(account1.transactionValue(),value1);
		// unnormal test1:
		// negative value
		BigDecimal value2 = new BigDecimal(-1.00);
		BoCTransaction account2 = new BoCTransaction();
		account2.setTransactionValue(value2);
		assertEquals(account2.transactionValue(),null);
		// unmormal test2:
		// set again
		BigDecimal value3 = new BigDecimal(500.00);
		BigDecimal value4 = new BigDecimal(800.00);
		BoCTransaction account3 = new BoCTransaction();
		account3.setTransactionValue(value3);
		account3.setTransactionValue(value4); // set the value again
		assertEquals(account3.transactionValue(),value3);
	}
	// test function: setTransactionCategory
	// tester: Wangji Wei
	@Test
	void testSetTransactionCategory() {
		// normal test
		int category = 88;
		BoCTransaction account1 = new BoCTransaction();
		account1.setTransactionCategory(category);
		assertEquals(account1.transactionCategory(),category);
		// unnormal test
		// set the category again
		int cate1 = 1;
		int cate2 = 2;
		BoCTransaction account2 = new BoCTransaction();
		account2.setTransactionCategory(cate1);
		account2.setTransactionCategory(cate2);
		assertEquals(account2.transactionCategory(),cate2);
	}
	// test function: isComplete
	// tester: Jiachen Zhang
	@ParameterizedTest
	@ValueSource(ints = {0,1})
	void testIsComplete(int new1) {
		if(new1 ==0)
		{
			BigDecimal value = new BigDecimal("22");
			BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1);
			assertEquals(2,myAnswer1.isComplete());
		}
		if(new1 ==1)
		{
			BoCTransaction myAnswer1 = new BoCTransaction();
			assertEquals(1,myAnswer1.isComplete());
		}
	}
	// test function: toString
	// tester: Jiachen Zhang
	@Test
	void testToString() {
	BigDecimal value = new BigDecimal("22");
	BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1);
	assertEquals(myAnswer1.transactionName() + " - ¥" + myAnswer1.transactionValue().toString(),myAnswer1.toString());
	}
}
