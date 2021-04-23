## Test Plan
Added three columns: *"Time"* represents when the test is run, *"Failure reason"* represents according to Juit Failure Trace why the test failed and *"Change"* represents after this test what did I do/ what need to fix. 
### Class: BoC Category

#### Function: public BoCCategory()

##### Tester: Siyu YAO

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|------------|------|
|1|21/04/19 10:32|Construct a new object and test if it is successfully constructed|NotNull|Null|Failed|@Before and @After is no longer exist in Junit5, use @BeforeEach and @AfterEach instead|Change the test code: @Before and @After to @BeforeEach and @AfterEach|
|2|21/04/19 10:38|Construct a new object and test if it is successfully constructed|NotNull|NotNull|Passed|||
|3|21/04/19 10:45|assertEquals("New Category", category.CategoryName());    assertEquals(0.00, category.CategoryBudget());       assertEquals(0.00, category.CategorySpend());|"New Category" 0.00 0.00|"New Category" 0.00 0.00|Failed|CategoryBudget methord returns BigDecimal should use String instead of Double|Change the test code to: assertEquals("0.00", category.CategoryBudget());assertEquals("0.00", category.CategorySpend());|
|4|21/04/19 10:52|assertEquals("New Category", category.CategoryName());    assertEquals("0.00", category.CategoryBudget());       assertEquals("0.00", category.CategorySpend());|"New Category" 0.00 0.00 |"New Category" 0.00 0.00|Failed|Should creat a new BigDecimal value to compare the result |Change the test code to:       BigDecimal bd = new BigDecimal("0.00");          assertEquals(bd, category.CategoryBudget());      assertEquals(bd, category.CategorySpend());|
|5|21/04/19 11:08|assertEquals("New Category", category.CategoryName());      assertEquals(bd, category.CategoryBudget());         assertEquals(bd, category.CategorySpend());|"New Category" 0.00 0.00 |"New Category" 0.00 0.00|Passed|||

#### Function: BoCCategory(String newTitle)

##### Tester: Jing ZHANG

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failed reason|Change|
|----|----|------|----------------|------------|------|-------------|------|
|1|21/04/20 19:02|"Cloth"|category.CategoryName = "Cloth"; category.CategoryBudget = 0.00; category.CategoryBudget = 0.00;|category.CategoryName = "Cloth"; category.CategoryBudget = 0.00;  category.CategoryBudget = 0.00;|PASS|\ | \|
|2|21/04/20 19:10|"This string is more than 15 characters"|error|category.CategoryName = "This string is more than 15 characters"; category.CategoryBudget =   0.00;  category.CategoryBudget = 0.00;|FAIL|when inputting the string more than 15 characters, the program won't throw out the expectation.|**Need to improve the Java code**|
|3|21/04/20 19:12|NULL|error|category.CategoryName = NULL; category.CategoryBudget =   0.00;  category.CategoryBudget = 0.00;|FAIL|when inputting null, the program won't throw out the expectation.|**Need to improve the Java code**|
|4|21/04/22 18:40|Unknown|error|Create a category named '0.00'|FAIL|when inputting Unknown, the program won't throw out the expectation.|**Need to improve the Java code**|

#### Function: public String CategoryName() 

##### Tester: Siyu YAO

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|------------|------|
|1|04-19 21:35|Creat two objects, one by defult construct, another by construct with String as parameter. Test althouth they have different id address, CategoryName() will return same String value.|NotSame  Equals|NotSame  Equals|Passed|||
|2|04-20 20:54|name = "food"; setCategoryName(name); String get = category.CategoryName();|set name and get is Same|Same|Passed|||

#### Function: Get Category Budget

##### Tester: Xingyan QU

Should return a BigDecimal of the category’s budget.

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|falure reason| Change|
|----|----|------|----------------|------------|------|-------------|-------|
| 1|4-20 am|  0.00| budget = 0.00 | 0.00|pass| /|/|
| 2|4-20 am|  -597.03| budget = 0.00 |0.00|pass|/|/|
| 3|4-20 am|  2220.00| budget = 2220.00| 2220.00|pass|/ |/ |

#### Function: Get Category Spend

##### Tester: Xingyan QU

Should return a BigDecimal of the category’s current spend total.
Here I set budget to be 3000.00

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|falure reason| Change|
|----|----|------|----------------|------------|------|-------------|-------|
| 1|4-22 pm|new spend of 234.00, a remove of 200.00 | 34.00|34.00|pass|/|/|
| 2|4-22 pm|new spend of 234.00, a remove of 300.00| 234.00|-66.00|fail|couldn't handle properly when remove > spend|sourse code to be change|
|3|4-22 pm|new spend of 234.00, a remove of -300.00|234.00|534.00|fail|couldn't handle properly when remove <0|sourse code to be change|
| 4|4-22 pm|new spend of -234.00, a remove of 200.00|0.00|-234.00|fail|couldn't handle properly when spend<0|sourse code to be change|

#### Function: public void setCategoryName(String newName)  AND  public String CategoryName()

##### Tester: Siyu YAO

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|------------|------|
|1|04-19 17:44|@ValueSource(strings = { "food", "shopping", "transportation"})|food shopping transportation|food shopping transportation|Passed 3|||
|2|04-19 20:31|"this is a sentence more than 15 characters"|NotEquals, should alart the user|Equals|Faileed|The setCategoryName method couldn't handle this cases|Change the test code to: _try catch exception_ and change the java class code to:  _throws Exception_|
|3|04-19 20:47|@ValueSource(strings = { "food", "shopping", "transportation","this is a sentence more than 15 characters"}|Pass all four tests|Errors in "food" "shopping" "transportation", pass the last one|Errors 3 Passed 1|"Unhandled exception type exception"|Change back the test code and java class code to last modified|
|4|04-19 20:51|"this is a sentence more than 15 characters"|NotEquals, should alart the user|Equals|Failed|The setCategoryName method couldn't handle this cases|**Need improve the java class code**|
|5|04-19 20:57|"Unknown"|NotEquals, should alart the user|Equals|Failed|The setCategoryName method couldn't handle this cases|**Need improve the java class code**|
|6|04-20 20:16|"   "|CategoryName is not blank, should alart the user|Blank|Failed|The setCategoryName method couldn't handle this cases|**Need improve the java class code**|

#### Function: public void setCategoryBudget(BigDecimal newValue)

##### Tester: Jing ZHANG

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failed reason|Change|
|----|----|------|----------------|------------|------|-------------|------|
|1|21/04/21 18:32|1234|category.CategoryBudget = 1234|category.CategoryBudget = 1234.00|PASS|\|\|
|2|21/04/21 18:32|0.00|error|category.CategoryBudget = 0.00|FAIL|When the user input the wrong numeric, the program have not ask the user to input again|**Need to improve the Java code**|
|3|21/04/21 18:32|-1234|error|category.CategoryBudget = 0.00|FAIL|When the user input the wrong numeric, the program have not ask the user to input again|**Need to improve the Java code**|

#### Function: Add Expense function

##### Tester: Xingyan QU

This function should take a BigDecimal and ad it to the current toal spend for the category.
Here I set budget to be 3000.00

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|falure reason| Change|
|----|----|------|----------------|------------|------|-------------|-------|
| 1|4-21 am|add a new spend 2300.00 |2300.00 |2300.00| pass|/|/|
| 2|4-21 am|add a new spend -5.00| 2300.00|2295.00|fail|the sourse code didn't handle the invalid input where the new expense is negative|sourse code to be change|
| 3|4-21 pm|add a new spend 6000.00 |8295.00 |8295.00.00| pass|/|/|


#### Function: Remove Expense function

##### Tester: Xingyan QU

This function sould take a BigDecimal and subtract it from the current total spend for the category.
Here I set budget to be 3000.00, plus before each round of test, add a new spend of 500.00.

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|falure reason| Change|
|----|----|------|----------------|------------|------|-------------|-------|
| 1| 4-21 am|5.00| 495.00| 495.00|pass|/|/|
| 2|4-21 am| -5.00 | 995.00|1000.00|fail|the sourse code didn't handle the invalid input where the remove amount is negative|sourse code to be change|
| 3|4-21 pm|6000.00 |1500.00|-4500.00|fail| the sourse code didn't handle the invalid input where the remove amount bigger than the total spend|sourse code to be change|


#### Function: public void resetBudgetSpend() 

##### Tester: Jing ZHANG

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failed reason|Change|
|----|----|------|----------------|------------|------|-------------|------|
|1|21/04/21 18:50|1234|category.CategoryBudget = 0.00|category.CategoryBudget = 0.00|PASS|\|\|
|2|21/04/21 18:50|0.00|category.CategoryBudget = 0.00|category.CategoryBudget = 0.00|PASS|\|\|

#### Function: public void resetBudgetSpend() 

##### Tester: Jing ZHANG

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failed reason|Change|
|----|----|------|----------------|------------|------|-------------|------|
|1|21/04/21 19:20|1111 1000|111|111|PASS|\|\|
|2|21/04/21 19:25|1000 1000|0|0|PASS|\|\|
|3|21/04/21 19:50|1000 2000|-1000|-1000|PASS|\|\|

#### Function: @Override   public String toString()

##### Tester: Siyu YAO

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change|
|----|----|------|----------------|------------|------|------------|------|
|1|04-20 19:33|name = "testname", budget = "3000.00", spent1 = "2573.42"|testname(¥3000.00) - Est. ¥2573.42 (¥426.58 Remaining)|testname(¥3000.00) - Est. ¥2573.42 (¥426.58 Remaining)|Passed|||
|2|04-20 19:39|name = "testname", budget = "3000.00", spent1 = "3281.07"|testname(¥3000.00) - Est. ¥3281.07 (¥281.07 Overspent)|testname(¥3000.00) - Est. ¥3281.07 (¥-281.07 Remaining)|Failed|The toString methord cannot handle if the spent is more than budget and return the wrong format|**Need improve the java code**|




