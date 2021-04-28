package cw3;
import java.math.BigDecimal;
import java.util.Scanner;

public class BoCCategory {
	private String CategoryName;
	private BigDecimal CategoryBudget;
	private BigDecimal CategorySpend;

	public BoCCategory() {
		CategoryName = "New Category";
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}

	public BoCCategory(String newTitle) {
		CategoryName = newTitle;
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}

	public String CategoryName() {
		return CategoryName;
	}

	public BigDecimal CategoryBudget() {
		return CategoryBudget;
	}

	public BigDecimal CategorySpend() {
		return CategorySpend;
	}

	// Modified by: Siyu Yao
	// Last modified time: 21/04/28 19:34
	/*
	 * Edit: 1)Add the do-while loop to make sure that the category name cannot be Unknown/blank/more than 15 char
	 */
	
	public void setCategoryName(String newName) {
		int n=0;
		do {
			if(newName.equalsIgnoreCase("Unknown") || newName.length() > 15 || newName.isBlank()) {
				System.out.println("Nonconformity Catagory name, please inter again: ");
				Scanner in = new Scanner(System.in);
				newName = in.nextLine();
				continue;
			} else {
				CategoryName = newName;
				n+=1;
			}
		}while(n==0);	
	}

	public void setCategoryBudget(BigDecimal newValue) {
		// 1 means bigger, -1 means smaller, 0 means same
		if (newValue.compareTo(new BigDecimal("0.00")) == 1) {
			CategoryBudget = newValue;
		}
	}

	public void addExpense(BigDecimal valueToAdd) {
		CategorySpend = CategorySpend.add(valueToAdd);
	}

	public void removeExpense(BigDecimal valueToRemove) {
		CategorySpend = CategorySpend.subtract(valueToRemove);
	}

	public void resetBudgetSpend() {
		CategorySpend = new BigDecimal("0.00");
	}

	public BigDecimal getRemainingBudget() {
		BigDecimal remainingBudget = CategoryBudget.subtract(CategorySpend);
		return remainingBudget;
	}

	/*
	 * Modified by: Siyu Yao
	 * Last modified time: 21/04/28 18:55
	 * Edit: 1) Delete the 'Est' in return format, cause this information is useless
	 * 		 2) Add the format when spent is larger than budget and return overspent format
	 */
	@Override
	public String toString() {
		if(CategoryBudget.compareTo(CategorySpend)!=-1) 		// if budget <= spend return format should be 'Overspent'
		{
			return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - ¥" + CategorySpend.toPlainString()
			+ " (¥" + getRemainingBudget().toPlainString() + " Overspent)";
		}
		else				// if budget > spend return format should be 'Remaining'										
		{
			return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - ¥" + CategorySpend.toPlainString()
			+ " (¥" + getRemainingBudget().toPlainString() + " Remaining)";
		}
		
	}

}
