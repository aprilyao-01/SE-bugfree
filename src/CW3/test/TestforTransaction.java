import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestforTransaction {

	@Test
	void testTransactionName() {
		String name = "abcd";
		BoCTransaction account = new BoCTransaction();
		account.setTransactionName(name);
		assertSame(name,account.transactionName());
	}
	@Test
	void testTransactionValue() {
		BigDecimal value = new BigDecimal(8888.00);
		BoCTransaction account = new BoCTransaction();
		account.setTransactionValue(value);
		assertSame(value,account.transactionValue());
	}
	@Test
	void testTransactionCategory() {
		
		int category = 88;
		BoCTransaction account = new BoCTransaction();
		account.setTransactionCategory(category);
		assertSame(category,account.transactionCategory());
	}
	@Test
	void testTransactionTime() {
		Date time = new Date();
		BoCTransaction account = new BoCTransaction();
		account.setTransactionTime(time);
		assertSame(time,account.transactionTime());
	}

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
		assertEquals(account2.transactionValue(),value2);
		// unmormal test2:
		// set again
		BigDecimal value3 = new BigDecimal(500.00);
		BigDecimal value4 = new BigDecimal(800.00);
		BoCTransaction account3 = new BoCTransaction();
		account3.setTransactionValue(value3);
		account3.setTransactionValue(value4); // set the value again
		assertEquals(account3.transactionValue(),value3);
	}

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

}
