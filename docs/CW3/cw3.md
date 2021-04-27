## Test Plan
Added three columns: *"Time"* represents when the test is run, *"Failure reason"* represents according to Juit Failure Trace why the test Faileded and *"Change"* represents after this test what did I do/ what need to fix. 
### Class: BoCTransaction

#### Function:BoCTransaction

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/18 18:10|BoCTransaction myAnswer1 = new BoCTransaction();|assertEquals("[Pending Transaction]",myAnswer1);|""|||
|2|21/04/18 18:20|BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1);Date myDate = new Date();|assertEquals(myDate,myAnswer1.transactionTime());|assertEquals(myDate,myAnswer1.transactionTime());|Passed|||

#### Function:TransactionName
##### Contributor: Wangji Wei
|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/17 19:01|String name = "abcd"; BoCTransaction account = new BoCTransaction(); account.setTransactionName(name);|abcd|abcd|Passed|\ |\ |
|2|21/04/17 19:05|String name = "abcd1231"; BoCTransaction account = new BoCTransaction(); account.setTransactionName(name);|abcd1231|abcd1231|Passed|\ |\ |

#### Function: transactionValue
##### Contributor: Wangji Wei
|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/17 19:12|BigDecimal value = new BigDecimal(8888.00); BoCTransaction account = new BoCTransaction(); account.setTransactionValue(value);|8888.00|8888.00|Passed|\ |\ |
|2|21/04/17 19:15|BigDecimal value = new BigDecimal(0.00); BoCTransaction account = new BoCTransaction(); account.setTransactionValue(value);|0.00|0.00|Passed|\ |\ |

#### Function: transactionCategory
##### Contributor: Wangji Wei
|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/17 19:18|int category = 88;    BoCTransaction account = new BoCTransaction(); account.setTransactionCategory(category);|88|88|Passed|\ |\ |
|2|21/04/17 19:19|int category = -1;    BoCTransaction account = new BoCTransaction(); account.setTransactionCategory(category);|-1|-1|Passed|\ |\ |

#### Function: transactionTime
##### Contributor: Wangji Wei
|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/17 19:30|Date time = new Date(); BoCTransaction account = new BoCTransaction(); account.setTransactionTime(time);|2021/04/17 19:30:48|2021/04/17 19:30:48|Passed|\ |\ |
|2|21/04/17 19:32|Date time = new Date(); BoCTransaction account = new BoCTransaction(); account.setTransactionTime(time);|2021/04/17 19:32:15|2021/04/17 19:32:15|Passed|\ |\ |

#### Function: setTransactionName
##### Contributor: Wangji Wei
|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/17 20:01|String name1 = "aaaa"; BoCTransaction account1 = new BoCTransaction();account1.setTransactionName(name1);|aaaa|aaaa|Passed|\ |\ |
|2|21/04/17 20:18|String name2 = "abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde"; BoCTransaction account2 = new BoCTransaction(); account2.setTransactionName(name2);|abcdeabcdeabcdeabcdeabcde|abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde|Failed|The name is limited to 25 characters but the function does not recognize that limitation.|change the code in BoCTransaction to limit the characters.|
|3|21/04/17 20:26|String name3 = "abcde"; String name4 = "abcd";BoCTransaction account3 = new BoCTransaction();account3.setTransactionName(name3);account3.setTransactionName(name4);|abcde|abcd|Failed|The name only can be set once but the function does not recognize the limitation.|change the code in BoCTransaction to limit the time of input name.|

#### Function: setTransactionValue
##### Contributor: Wangji Wei
|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/17 20:34|BigDecimal value1 = new BigDecimal(8888.00); BoCTransaction account1 = new BoCTransaction(); account1.setTransactionValue(value1);|8888.00|8888.00|Passed|\ |\ |
|2|21/04/17 20:38|BigDecimal value2 = new BigDecimal(-1.00); BoCTransaction account2 = new BoCTransaction(); account2.setTransactionValue(value2);|-1.00|null|Failed|The value cannot be negative but the function cannot recognize the limitation|change the code in BoCTransaction to limit the value that must be positive|
|3|21/04/17 20:45|BigDecimal value3 = new BigDecimal(500.00);BigDecimal value4 = new BigDecimal(800.00); BoCTransaction account3 = new BoCTransaction(); account3.setTransactionValue(value3); account3.setTransactionValue(value4);|500|800|Failed|The value only can be set once but the function does not recognize the limitation.|change the code in BoCTransaction to limit the time of input value.|

#### Function: setTransactionCategory
##### Contributor: Wangji Wei
|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/17 21:02|int category = 88; BoCTransaction account1 = new BoCTransaction(); account1.setTransactionCategory(category);|88|88|Passed|\ |\ |
|2|21/04/17 21:15|int cate1 = 1;int cate2 = 2;BoCTransaction account2 = new BoCTransaction();account2.setTransactionCategory(cate1);account2.setTransactionCategory(cate2);|2|2|Passed|\ |\ |


#### Function: isComplete

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|--------|--------------|------------|------|--------------|------|
|1|21/04/19 19:10|BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1);|assertEquals(1,myAnswer1.iscomplete());||error|||

#### Function: toString

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/19 19:30|BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1);|assertEquals(myAnswer1.transactionName() + " - 楼" + myAnswer1.transactionValue().toString(),myAnswer1.toString());|assertEquals(myAnswer1.transactionName() + " - 楼" + myAnswer1.transactionValue().toString(),myAnswer1.toString());|Passed|||

### Class: BoC Category

#### Function: public BoCCategory()

##### Contributor: Siyu YAO

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|--------------|------|
|1|21/04/19 10:32|Construct a new object and test if it is successfully constructed|NotNull|Null|Failed|@Before and @After is no longer exist in Junit5, use @BeforeEach and @AfterEach instead|Change the test code: @Before and @After to @BeforeEach and @AfterEach|
|2|21/04/19 10:38|Construct a new object and test if it is successfully constructed|NotNull|NotNull|Passed|||
|3|21/04/19 10:45|assertEquals("New Category", category.CategoryName());    assertEquals(0.00, category.CategoryBudget());       assertEquals(0.00, category.CategorySpend());|"New Category" 0.00 0.00|"New Category" 0.00 0.00|Failed|CategoryBudget methord returns BigDecimal should use String instead of Double|Change the test code to: assertEquals("0.00", category.CategoryBudget());assertEquals("0.00", category.CategorySpend());|
|4|21/04/19 10:52|assertEquals("New Category", category.CategoryName());    assertEquals("0.00", category.CategoryBudget());       assertEquals("0.00", category.CategorySpend());|"New Category" 0.00 0.00 |"New Category" 0.00 0.00|Failed|Should creat a new BigDecimal value to compare the result |Change the test code to:       BigDecimal bd = new BigDecimal("0.00");          assertEquals(bd, category.CategoryBudget());      assertEquals(bd, category.CategorySpend());|
|5|21/04/19 11:08|assertEquals("New Category", category.CategoryName());      assertEquals(bd, category.CategoryBudget());         assertEquals(bd, category.CategorySpend());|"New Category" 0.00 0.00 |"New Category" 0.00 0.00|Passed|||

#### Function: BoCCategory(String newTitle)

##### Contributor: Jing ZHANG

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|-------------|------|
|1|21/04/20 19:02|"Cloth"|category.CategoryName = "Cloth"; category.CategoryBudget = 0.00; category.CategoryBudget = 0.00;|category.CategoryName = "Cloth"; category.CategoryBudget = 0.00;  category.CategoryBudget = 0.00;|Passed|\ | \|
|2|21/04/20 19:10|"This string is more than 15 characters"|error|category.CategoryName = "This string is more than 15 characters"; category.CategoryBudget =   0.00;  category.CategoryBudget = 0.00;|Failed|when inputting the string more than 15 characters, the program won't throw out the expectation.|**Need to improve the Java code**|
|3|21/04/20 19:12|NULL|error|category.CategoryName = NULL; category.CategoryBudget =   0.00;  category.CategoryBudget = 0.00;|Failed|when inputting null, the program won't throw out the expectation.|**Need to improve the Java code**|
|4|21/04/22 18:40|Unknown|error|Create a category named '0.00'|Failed|when inputting Unknown, the program won't throw out the expectation.|**Need to improve the Java code**|

#### Function: public String CategoryName() 

##### Contributor: Siyu YAO

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|------------|------|
|1|21/04/19 21:35|Creat two objects, one by defult construct, another by construct with String as parameter. Test althouth they have different id address, CategoryName() will return same String value.|NotSame  Equals|NotSame  Equals|Passed|||
|2|21/04/20 20:54|name = "food"; setCategoryName(name); String get = category.CategoryName();|set name and get is Same|Same|Passed|||

#### Function: Get Category Budget

##### Contributor: Xingyan QU

Should return a BigDecimal of the category’s budget.

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason| Change|
|----|----|------|----------------|------------|------|-------------|-------|
| 1|21/04/20 8:45|  0.00| budget = 0.00 | 0.00|Passed| /|/|
| 2|21/04/20 9:00|  -597.03| budget = 0.00 |0.00|Passed|/|/|
| 3|21/04/20 9:05|  2220.00| budget = 2220.00| 2220.00|Passed|/ |/ |

#### Function: Get Category Spend

##### Contributor: Xingyan QU

Should return a BigDecimal of the category’s current spend total.
Here I set budget to be 3000.00

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason| Change|
|----|----|------|----------------|------------|------|-------------|-------|
| 1|21/4/22 8:35|new spend of 234.00, a remove of 200.00 | 34.00|34.00|Passed|/|/|
| 2|21/4/22 8:26|new spend of 234.00, a remove of 300.00| 234.00|-66.00|Failed|couldn't handle properly when remove > spend|sourse code to be change|
|3|21/4/22 8:44|new spend of 234.00, a remove of -300.00|234.00|534.00|Failed|couldn't handle properly when remove <0|sourse code to be change|
| 4|21/4/22 9:02|new spend of -234.00, a remove of 200.00|0.00|-234.00|Failed|couldn't handle properly when spend<0|sourse code to be change|

#### Function: public void setCategoryName(String newName)  AND  public String CategoryName()

##### Contributor: Siyu YAO

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|------------|------|
|1|21/04/19 17:44|@ValueSource(strings = { "food", "shopping", "transportation"})|food shopping transportation|food shopping transportation|Passed 3|||
|2|21/04/19 20:31|"this is a sentence more than 15 characters"|NotEquals, should alart the user|Equals|Faileed|The setCategoryName method couldn't handle this cases|Change the test code to: _try catch exception_ and change the java class code to:  _throws Exception_|
|3|21/04/19 20:47|@ValueSource(strings = { "food", "shopping", "transportation","this is a sentence more than 15 characters"}|Pass all four tests|Errors in "food" "shopping" "transportation", Passed the last one|Errors 3 Passed 1|"Unhandled exception type exception"|Change back the test code and java class code to last modified|
|4|21/04/19 20:51|"this is a sentence more than 15 characters"|NotEquals, should alart the user|Equals|Failed|The setCategoryName method couldn't handle this cases|**Need improve the java class code**|
|5|21/04/19 20:57|"Unknown"|NotEquals, should alart the user|Equals|Failed|The setCategoryName method couldn't handle this cases|**Need improve the java class code**|
|6|21/04/20 20:16|"   "|CategoryName is not blank, should alart the user|Blank|Failed|The setCategoryName method couldn't handle this cases|**Need improve the java class code**|

#### Function: public void setCategoryBudget(BigDecimal newValue)

##### Contributor: Jing ZHANG

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|-------------|------|
|1|21/04/21 18:32|1234|category.CategoryBudget = 1234|category.CategoryBudget = 1234.00|Passed|||
|2|21/04/21 18:32|0.00|error|category.CategoryBudget = 0.00|Failed|When the user input the wrong numeric, the program have not ask the user to input again|**Need to improve the Java code**|
|3|21/04/21 18:32|-1234|error|category.CategoryBudget = 0.00|Failed|When the user input the wrong numeric, the program have not ask the user to input again|**Need to improve the Java code**|

#### Function: Add Expense function

##### Contributor: Xingyan QU

This function should take a BigDecimal and ad it to the current toal spend for the category.
Here I set budget to be 3000.00

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason| Change|
|----|----|------|----------------|------------|------|-------------|-------|
| 1|21/04/21 12:20|add a new spend 2300.00 |2300.00 |2300.00| Passed|/|/|
| 2|21/04/21 12:31|add a new spend -5.00| 2300.00|2295.00|Failed|the source code didn't handle the invalid input where the new expense is negative|source code to be change|
| 3|21/04/21 12:56|add a new spend 6000.00 |8295.00 |8295.00.00| Passed|/|/|


#### Function: Remove Expense function

##### Contributor: Xingyan QU

This function sould take a BigDecimal and subtract it from the current total spend for the category.
Here I set budget to be 3000.00, plus before each round of test, add a new spend of 500.00.

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason| Change|
|----|----|------|----------------|------------|------|-------------|-------|
| 1|21/4/21 18:34|5.00| 495.00| 495.00|Passed|/|/|
| 2|21/4/21 18:50| -5.00 | 995.00|1000.00|Failed|the source code didn't handle the invalid input where the remove amount is negative|source code to be change|
| 3|21/4/21 18:55|6000.00 |1500.00|-4500.00|Failed| the source code didn't handle the invalid input where the remove amount bigger than the total spend |source code to be change|


#### Function: public void resetBudgetSpend() 

##### Contributor: Jing ZHANG

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|-------------|------|
|1|21/04/21 18:50|1234|category.CategoryBudget = 0.00|category.CategoryBudget = 0.00|Passed|||
|2|21/04/21 18:50|0.00|category.CategoryBudget = 0.00|category.CategoryBudget = 0.00|Passed|||

#### Function: public BigDecimal getRemainingBudget()

##### Contributor: Jing ZHANG

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|-------------|------|
|1|21/04/21 19:20|1111 1000|111|111|Passed|||
|2|21/04/21 19:25|1000 1000|0|0|Passed|||
|3|21/04/21 19:50|1000 2000|-1000|-1000|Passed|||

#### Function: @Override   public String toString()

##### Contributor: Siyu YAO

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|------------|------|
|1|21/04/20 19:33|name = "testname", budget = "3000.00", spent1 = "2573.42"|testname(¥3000.00) - Est. ¥2573.42 (¥426.58 Remaining)|testname(¥3000.00) - Est. ¥2573.42 (¥426.58 Remaining)|Passed|||
|2|21/04/20 19:39|name = "testname", budget = "3000.00", spent1 = "3281.07"|testname(¥3000.00) - Est. ¥3281.07 (¥281.07 Overspent)|testname(¥3000.00) - Est. ¥3281.07 (¥-281.07 Remaining)|Failed|The toString methord cannot handle if the spent is more than budget and return the wrong format|**Need improve the java code**|

### Class: BoC App

#### Function: private static void AddCategory(Scanner in)

##### Contributor: Jing ZHANG

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|------------|------|
|1|21/04/26 22:12|title = 'Cloth' cbudget = 100.00|What is the title of the category?  What is the budget for this category?  [Category added]  1) Unknown(¥0.00) - Est. ¥850.00 (¥-850.00 Remaining)  2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)  3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)  4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)  5) Cloth(¥100.00) - Est. ¥0.00 (¥100.00 Remaining)|What is the title of the category?  What is the budget for this category?  [Category added]  1) Unknown(¥0.00) - Est. ¥850.00 (¥-850.00 Remaining)  2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)  3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)  4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)  5) Cloth(¥100.00) - Est. ¥0.00 (¥100.00 Remaining)|Passed|||
|2|21/04/26 23:32|title = 'This is greater than 15 characters' cbudget = 100.00|error|A new category was added|Failed|The function not throw exception when the category's name is invalid|**Need improve the java code**|
|3|21/04/26 23:32|title = 'This is greater than 15 characters' cbudget = -1234|error|A new category was added|Failed|The function not throw exception when the category's name and the budget are invalid|**Need improve the java code**|
|4|21/04/26 23:32|title = 'Cloth' cbudget = -1234|error|A new category was added|Failed|The function not throw exception when the budget is invalid|**Need improve the java code**|