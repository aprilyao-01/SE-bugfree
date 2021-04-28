package cw3;

import java.math.BigDecimal;
import java.util.Date;

public class BoCTransaction {
	private String transactionName;
	private BigDecimal transactionValue;
	private int transactionCategory;
	private Date transactionTime;

	public BoCTransaction() {
		transactionName = null;
		transactionValue = null;
		transactionCategory = 0;
		transactionTime = null;
	}

	public BoCTransaction(String tName, BigDecimal tValue, int tCat) {
		transactionName = tName;
		transactionValue = tValue;
		transactionCategory = tCat;
		transactionTime = new Date();
	}

	public String transactionName() {
		return transactionName;
	}

	public BigDecimal transactionValue() {
		return transactionValue;
	}

	public int transactionCategory() {
		return transactionCategory;
	}

	public Date transactionTime() {
		return transactionTime;
	}

	public void setTransactionName(String tName) {
		// modified by Wangji Wei:
		// check if the transaction name is already exist and give a warning message and ignore the operation of set the name again.
		if(transactionName != null) {
			System.out.println("Already set the TransactionName.\n");
			tName = transactionName;
		}
		// modified by Wangji Wei: 
		// check the length of transactionName, if the length is bigger than 25, cut the string to the legal range.
		if (tName.length()>25) {
			tName = tName.substring(0, 25);
		}
		transactionName = tName; 
		}

	public void setTransactionValue(BigDecimal tValue) {
		// modified by Wangji Wei:
		// check if the transaction value is already exist and give a warning message and ignore the operation of set the value again.
		if (transactionValue != null) {
			System.out.println("Already set the TransactionValue.\n");
			tValue = transactionValue;
		}
		// modified by Wangji Wei:\
		// check if the input is negative then give an error message.
		if (tValue.compareTo(new BigDecimal("0.00"))== -1) {
			System.out.println("The transaction Value cannot be negative.\n");
		}
		if (tValue.compareTo(new BigDecimal("0.00")) == 1) {
			// 1 means bigger, -1 means smaller, 0 means same
				transactionValue = tValue;
			}
		}

	public void setTransactionCategory(int tCat) {
		if (tCat > 0) {
			transactionCategory = tCat;
		}
	}

	public void setTransactionTime(Date tTime) {
		if (tTime != null) {
			transactionTime = tTime;
		}
	}

	@Override
	public String toString() {
		return transactionName + " - ¥" + transactionValue.toString();
	}

}
