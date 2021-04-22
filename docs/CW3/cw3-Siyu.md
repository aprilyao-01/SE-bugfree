### Following test are created by Siyu Yao

## Test Plan
Added three columns: *"Time"* represents when the test is run, *"Failure reason"* represents according to Juit Failure Trace why the test failed and *"Change"* represents after this test what did I do/ what need to fix. 

### Class: BoC Category

#### Function: public BoCCategory()

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change
|----|----|------|----------------|------------|------|------------|------
|1|04-19 10:32|Construct a new object and test if it is successfully constructed|NotNull|Null|Failed|@Before and @After is no longer exist in Junit5, use @BeforeEach and @AfterEach instead|Change the test code: @Before and @After to @BeforeEach and @AfterEach|
|2|04-19 10:38|Construct a new object and test if it is successfully constructed|NotNull|NotNull|Passed|||
|3|04-19 10:45|assertEquals("New Category", category.CategoryName());    assertEquals(0.00, category.CategoryBudget());       assertEquals(0.00, category.CategorySpend());|"New Category" 0.00 0.00|"New Category" 0.00 0.00|Failed|CategoryBudget methord returns BigDecimal should use String instead of Double|Change the test code to: assertEquals("0.00", category.CategoryBudget());assertEquals("0.00", category.CategorySpend());|
|4|04-19 10:52|assertEquals("New Category", category.CategoryName());    assertEquals("0.00", category.CategoryBudget());       assertEquals("0.00", category.CategorySpend());|"New Category" 0.00 0.00 |"New Category" 0.00 0.00|Failed|Should creat a new BigDecimal value to compare the result |Change the test code to:       BigDecimal bd = new BigDecimal("0.00");          assertEquals(bd, category.CategoryBudget());      assertEquals(bd, category.CategorySpend());|
|5|04-19 11:08|assertEquals("New Category", category.CategoryName());      assertEquals(bd, category.CategoryBudget());         assertEquals(bd, category.CategorySpend());|"New Category" 0.00 0.00 |"New Category" 0.00 0.00|Passed|||


### Class: BoC Category

#### Function: public void setCategoryName(String newName)  AND  public String CategoryName()

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change
|----|----|------|----------------|------------|------|------------|------
|1|04-19 17:44|@ValueSource(strings = { "food", "shopping", "transportation"})|food shopping transportation|food shopping transportation|Passed 3|||
|2|04-19 20:31|"this is a sentence more than 15 characters"|NotEquals, should alart the user|Equals|Faileed|The setCategoryName method couldn't handle this cases|Change the test code to: _try catch exception_ and change the java class code to:  _throws Exception_|
|3|04-19 20:47|@ValueSource(strings = { "food", "shopping", "transportation","this is a sentence more than 15 characters"}|Pass all four tests|Errors in "food" "shopping" "transportation", pass the last one|Errors 3 Passed 1|"Unhandled exception type exception"|Change back the test code and java class code to last modified|
|4|04-19 20:51|"this is a sentence more than 15 characters"|NotEquals, should alart the user|Equals|Failed|The setCategoryName method couldn't handle this cases|**Need improve the java class code**|
|5|04-19 20:57|"Unknown"|NotEquals, should alart the user|Equals|Failed|The setCategoryName method couldn't handle this cases|**Need improve the java class code**|
|6|04-20 20:16|"   "|CategoryName is not blank, should alart the user|Blank|Failed|The setCategoryName method couldn't handle this cases|**Need improve the java class code**|

### Class: BoC Category

#### Function: public String CategoryName() 

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change
|----|----|------|----------------|------------|------|------------|------
|1|04-19 21:35|Creat two objects, one by defult construct, another by construct with String as parameter. Test althouth they have different id address, CategoryName() will return same String value.|NotSame  Equals|NotSame  Equals|Passed|||
|2|04-20 20:54|name = "food"; setCategoryName(name); String get = category.CategoryName();|set name and get is Same|Same|Passed|||


### Class: BoC Category

#### Function: @Override   public String toString()

|Test|Time|Inputs|Expected Outcome|Test Outcome|Result|Failure reason|Change
|----|----|------|----------------|------------|------|------------|------
|1|04-20 19:33|name = "testname", budget = "3000.00", spent1 = "2573.42"|testname(¥3000.00) - Est. ¥2573.42 (¥426.58 Remaining)|testname(¥3000.00) - Est. ¥2573.42 (¥426.58 Remaining)|Passed|||
|2|04-20 19:39|name = "testname", budget = "3000.00", spent1 = "3281.07"|testname(¥3000.00) - Est. ¥3281.07 (¥281.07 Overspent)|testname(¥3000.00) - Est. ¥3281.07 (¥-281.07 Remaining)|Failed|The toString methord cannot handle if the spent is more than budget and return the wrong format|**Need improve the java code**|
