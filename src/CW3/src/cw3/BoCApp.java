package cw3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class BoCApp {
	public static ArrayList<BoCTransaction> UserTransactions;
	public static ArrayList<BoCCategory> UserCategories;

	public static void main(String[] args) {
		/*The code of set up sample data has been improving in order for testing*/
		/*Refactored by JingZHANG*/
		setup();

		// MAIN FUNCTION LOOP

		CategoryOverview();
		System.out.println(
				"\nWhat do you want to do?\n T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String s = in.next();
			try {
				if (s.equals("T")) {
					ListTransactions();
				} else if (s.equals("O")) {
					CategoryOverview();
				} else if (s.equals("C")) {
					ChangeTransactionCategory(in);
				} else if (s.equals("N")) {
					AddCategory(in);
				} else if (s.equals("A")) {
					AddTransaction(in);
				} else if (s.equals("X")) {
					System.out.println("Goodbye!");
					break;
				} else if (Integer.parseInt(s) != -1) {
					ListTransactionsForCategory((int) Integer.parseInt(s));
				} else {
					System.out.println("Command not recognised");
				}
			} catch (Exception e) {
				System.out.println("Something went wrong: " + e.toString() + "\n");
			}

			System.out.println(
					"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
		}
		in.close();
	}



	public static void setup() {
		UserCategories = new ArrayList<BoCCategory>();
		UserTransactions = new ArrayList<BoCTransaction>();

		// SETUP EXAMPLE DATA //
		UserCategories.add(new BoCCategory("Unknown"));
		BoCCategory BillsCategory = new BoCCategory("Bills");
		BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
		UserCategories.add(BillsCategory);
		BoCCategory Groceries = new BoCCategory("Groceries");
		Groceries.setCategoryBudget(new BigDecimal("75.00"));
		UserCategories.add(Groceries);
		BoCCategory SocialSpending = new BoCCategory("Social");
		SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
		UserCategories.add(SocialSpending);

		UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
		UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
		UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
		UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
		UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
		UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
		UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));

		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			int utCat = temp.transactionCategory();
			BoCCategory temp2 = UserCategories.get(utCat);
			temp2.addExpense(temp.transactionValue());
			UserCategories.set(utCat, temp2);
		}
	}

	public static void ListTransactions() {
		/*
		* Modified by: Xingyan Qu
		* Last modified time: 21/04/29 10:34
		* Edit: fix wrong print out format: add category name right after transaction name
		*/
		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			System.out.println((x + 1) + ") " + temp.transactionName() + "(" + UserCategories.get(temp.transactionCategory()).CategoryName() + ")" + " - ¥" + temp.transactionValue().toString() );

		}
	}

	public static void CategoryOverview() {
		for (int x = 0; x < UserCategories.size(); x++) {
			BoCCategory temp = UserCategories.get(x);
			System.out.println((x + 1) + ") " + temp.toString());
		}

	}

	public static void ListTransactionsForCategory(int chosenCategory) {
		/*
		* Modified by: Xingyan Qu
		* Last modified time: 21/04/29 10:44
		* Edit: fix wrong print out format: add category name right after transaction name
		*/
		if(chosenCategory<1 || chosenCategory>UserCategories.size()){
			System.out.println("Invalid index");
		}else{
			System.out.println(UserCategories.get(chosenCategory-1).CategoryName()+":");
		}

		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			if (temp.transactionCategory() == chosenCategory-1) {
			System.out.println((x + 1) + ") " + temp.transactionName() + "(" + UserCategories.get(temp.transactionCategory()).CategoryName() + ")" + " - ¥" + temp.transactionValue().toString() );
			}
		}
	}

	private static void AddTransaction(Scanner in) {
		// modified by Jiachen Zhang:
		// add optionally a category, show Transaction Name](value)was added to [Category Name]
		int n = 0;
		System.out.println("What is the title of the transaction?");
		in.nextLine(); // to removAe read-in bug
		String title = in.nextLine();
		System.out.println("What is the value of the transaction?");
		BigDecimal tvalue = new BigDecimal(in.nextLine());
		do
		{
		System.out.println("What is the category ID of the transaction?");
		System.out.println("(Press \"Enter\" will set to \"Unknow\" automatically)");
		String tcategory = in.nextLine();
		int a = -1;
		if (tcategory.length() == 0 )
		{
			UserTransactions.add(new BoCTransaction(title, tvalue, 0));
			System.out.println("[" + title + "]" + "(¥" + tvalue + ") " + "was added to " + "[Unknow]");
			n = n +1 ;
		}
		else
		{
			 a = Integer.parseInt(tcategory);
		}
		if(a >= 0 && a <= UserCategories.size())
		{
		UserTransactions.add(new BoCTransaction(title, tvalue, a));
		System.out.println("[" + title + "]" + "(¥" + tvalue + ") " + "was added to " + "[" + tcategory + "]");
		n = n +1;
		}
		}while (n ==0);
	}
	private static void ChangeTransactionCategory(Scanner in) {
		// modified by Siyu Yao:
		// add confirmation after change as the class description asked
		System.out.println("Which transaction ID?");
		in.nextLine();
		int tID = Integer.parseInt(in.nextLine());
		System.out.println("\t- " + UserTransactions.get(tID - 1).toString());
		System.out.println("Which category will it move to?");
		CategoryOverview();
		int newCat = Integer.parseInt(in.nextLine());
		BoCTransaction temp = UserTransactions.get(tID);
		temp.setTransactionCategory(newCat);
		UserTransactions.set(tID, temp);
		BoCCategory temp2 = UserCategories.get(newCat);
		temp2.addExpense(temp.transactionValue());
		UserCategories.set(newCat, temp2);
		System.out.println("The new category it belongs to is: "+temp2.CategoryName());
		System.out.println("[Remove done]:");
		CategoryOverview();
	}

	private static void AddCategory(Scanner in) {
		System.out.println("What is the title of the category?");
		in.nextLine(); 
		// to remove read-in bug
		String title = in.nextLine();
		System.out.println("What is the budget for this category?");
		BigDecimal cbudget = new BigDecimal(in.nextLine());

		BoCCategory temp = new BoCCategory(title);
		temp.setCategoryBudget(cbudget);
		UserCategories.add(temp);
		System.out.println("[Category added]");
		CategoryOverview();
	}



}
