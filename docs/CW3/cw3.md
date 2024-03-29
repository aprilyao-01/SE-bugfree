## Test Plan
Added three columns: *"Time"* represents when the test is run, *"Failure reason"* represents according to Juit Failure Trace why the test Faileded and *"Change"* represents after this test what did I do/ what need to fix. 
### Class: BoCTransaction

#### Function:BoCTransaction()
##### Contributor: Jiachen Zhang
| Test | Time           | Inputs                                                       | Expected Outcome      | Test Outcome          | Result | Failure reason   | Change                    |
| ---- | -------------- | ------------------------------------------------------------ | --------------------- | --------------------- | ------ | ---------------- | ------------------------- |
| 1    | 21/04/18 18:10 | BoCTransaction myAnswer1 = new BoCTransaction();             | [Pending Transaction] | null                  | Failed | its name is null | add [Pending Transaction] |
| 2    | 21/04/18 18:20 | BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1);Date myDate = new Date(); | new Date()            | new Date()            | Passed |                  |                           |
| 2    | 21/04/28 17:00 | BoCTransaction myAnswer1 = new BoCTransaction();             | [Pending Transaction] | [Pending Transaction] | Passed |                  |                           |

#### Function:BoCTransaction(String tName, BigDecimal tValue, int tCat)
##### Contributor: Jiachen Zhang
| Test | Time           | Inputs                                                       | Expected Outcome            | Test Outcome                               | Result | Failure reason       | Change                                      |
| ---- | -------------- | ------------------------------------------------------------ | --------------------------- | ------------------------------------------ | ------ | -------------------- | ------------------------------------------- |
| 1    | 21/04/18 18:20 | BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1);Date myDate = new Date(); | new Date()                  | new Date()                                 | Passed |                      |                                             |
| 2    | 21/04/18 18:20 | BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer2 = new BoCTransaction("abcdfghjkloiuygfdfasfsssdfrfrwfwwedewfds", value, 1); | "abcdfghjkloiuygfdfasfsssd" | "abcdfghjkloiuygfdfasfsssdfrfrwfwwedewfds" | Failed | name is not limited  | add the limitation                          |
| 3    | 21/04/18 18:20 | BigDecimal value2 = new BigDecimal("-10");BoCTransaction myAnswer1 = new BoCTransaction("abc", value2, 1); | null                        | -10                                        | Failed | value is not limited | it should be greater than 0, only set once. |
| 4    | 21/04/28 19:50 | BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer2 = new BoCTransaction("abcdfghjkloiuygfdfasfsssdfrfrwfwwedewfds", value, 1); | "abcdfghjkloiuygfdfasfsssd" | "abcdfghjkloiuygfdfasfsssd"                | Passed |                      |                                             |
| 5    | 21/04/28 19:50 | BigDecimal value2 = new BigDecimal("-10");BoCTransaction myAnswer1 = new BoCTransaction("abc", value2, 1); | null                        | null                                       | Passed |                      |                                             |


#### Function:transactionName()
##### Contributor: Wangji Wei
| Test | Time           | Inputs                                                       | Expected Outcome | Test Outcome | Result | Failure reason | Change |
| ---- | -------------- | ------------------------------------------------------------ | ---------------- | ------------ | ------ | -------------- | ------ |
| 1    | 21/04/17 19:01 | String name = "abcd"; BoCTransaction account = new BoCTransaction(); account.setTransactionName(name); | abcd             | abcd         | Passed |                |        |
| 2    | 21/04/17 19:05 | String name = "abcd1231"; BoCTransaction account = new BoCTransaction(); account.setTransactionName(name); | abcd1231         | abcd1231     | Passed |                |        |

#### Function: transactionValue()
##### Contributor: Wangji Wei
| Test | Time           | Inputs                                                       | Expected Outcome | Test Outcome | Result | Failure reason | Change |
| ---- | -------------- | ------------------------------------------------------------ | ---------------- | ------------ | ------ | -------------- | ------ |
| 1    | 21/04/17 19:12 | BigDecimal value = new BigDecimal(8888.00); BoCTransaction account = new BoCTransaction(); account.setTransactionValue(value); | 8888.00          | 8888.00      | Passed |                |        |
| 2    | 21/04/17 19:15 | BigDecimal value = new BigDecimal(0.00); BoCTransaction account = new BoCTransaction(); account.setTransactionValue(value); | 0.00             | 0.00         | Passed |                |        |

#### Function: transactionCategory()
##### Contributor: Wangji Wei
| Test | Time           | Inputs                                                       | Expected Outcome | Test Outcome | Result | Failure reason | Change |
| ---- | -------------- | ------------------------------------------------------------ | ---------------- | ------------ | ------ | -------------- | ------ |
| 1    | 21/04/17 19:18 | int category = 88;    BoCTransaction account = new BoCTransaction(); account.setTransactionCategory(category); | 88               | 88           | Passed |                |        |
| 2    | 21/04/17 19:19 | int category = -1;    BoCTransaction account = new BoCTransaction(); account.setTransactionCategory(category); | -1               | -1           | Passed |                |        |

#### Function: transactionTime()
##### Contributor: Wangji Wei
| Test | Time           | Inputs                                                       | Expected Outcome    | Test Outcome        | Result | Failure reason | Change |
| ---- | -------------- | ------------------------------------------------------------ | ------------------- | ------------------- | ------ | -------------- | ------ |
| 1    | 21/04/17 19:30 | Date time = new Date(); BoCTransaction account = new BoCTransaction(); account.setTransactionTime(time); | 2021/04/17 19:30:48 | 2021/04/17 19:30:48 | Passed |                |        |
| 2    | 21/04/17 19:32 | Date time = new Date(); BoCTransaction account = new BoCTransaction(); account.setTransactionTime(time); | 2021/04/17 19:32:15 | 2021/04/17 19:32:15 | Passed |                |        |

#### Function: setTransactionName(String tName) 
##### Contributor: Wangji Wei
| Test | Time           | Inputs                                                       | Expected Outcome          | Test Outcome                                       | Result | Failure reason                                               | Change                                                       |
| ---- | -------------- | ------------------------------------------------------------ | ------------------------- | -------------------------------------------------- | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | 21/04/17 20:01 | String name1 = "aaaa"; BoCTransaction account1 = new BoCTransaction();account1.setTransactionName(name1); | aaaa                      | aaaa                                               | Passed |                                                              |                                                              |
| 2    | 21/04/17 20:18 | String name2 = "abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde"; BoCTransaction account2 = new BoCTransaction(); account2.setTransactionName(name2); | abcdeabcdeabcdeabcdeabcde | abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde | Failed | The name is limited to 25 characters but the function does not recognize that limitation. | change the code in BoCTransaction to limit the characters.   |
| 3    | 21/04/17 20:26 | String name3 = "abcde"; String name4 = "abcd";BoCTransaction account3 = new BoCTransaction();account3.setTransactionName(name3);account3.setTransactionName(name4); | abcde                     | abcd                                               | Failed | The name only can be set once but the function does not recognize the limitation. | change the code in BoCTransaction to limit the time of input name. |
| 4    | 21/04/26 19:45 | String name2 = "abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde"; BoCTransaction account2 = new BoCTransaction(); account2.setTransactionName(name2); | abcdeabcdeabcdeabcdeabcde | abcdeabcdeabcdeabcdeabcde                          | passed |                                                              | if the length of transactionName is bigger than 25,cut the string to 25 characters at maximum. |
| 5    | 21/04/26 20:12 | String name3 = "abcde"; String name4 = "abcd";BoCTransaction account3 = new BoCTransaction();account3.setTransactionName(name3);account3.setTransactionName(name4); | abcde                     | abcde                                              | passed |                                                              | if the transaction is not null then continue the next move else do not set the transactionname again. |

#### Function: setTransactionValue(BigDecimal tValue)
##### Contributor: Wangji Wei
| Test | Time           | Inputs                                                       | Expected Outcome | Test Outcome | Result | Failure reason                                               | Change                                                       |
| ---- | -------------- | ------------------------------------------------------------ | ---------------- | ------------ | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | 21/04/17 20:34 | BigDecimal value1 = new BigDecimal(8888.00); BoCTransaction account1 = new BoCTransaction(); account1.setTransactionValue(value1); | 8888.00          | 8888.00      | Passed |                                                              |                                                              |
| 2    | 21/04/17 20:38 | BigDecimal value2 = new BigDecimal(-1.00); BoCTransaction account2 = new BoCTransaction(); account2.setTransactionValue(value2); | -1.00            | null         | Failed | The value cannot be negative but the function cannot recognize the limitation | change the code in BoCTransaction to limit the value that must be positive |
| 3    | 21/04/17 20:45 | BigDecimal value3 = new BigDecimal(500.00);BigDecimal value4 = new BigDecimal(800.00); BoCTransaction account3 = new BoCTransaction(); account3.setTransactionValue(value3); account3.setTransactionValue(value4); | 500              | 800          | Failed | The value only can be set once but the function does not recognize the limitation. | change the code in BoCTransaction to limit the time of input value. |
| 4    | 21/04/26 20:25 | BigDecimal value2 = new BigDecimal(-1.00); BoCTransaction account2 = new BoCTransaction(); account2.setTransactionValue(value2); | null             | null         | passed |                                                              | show the warning "The transaciton value cannot be negative." |
| 5    | 21/04/26 21:00 | BigDecimal value3 = new BigDecimal(500.00);BigDecimal value4 = new BigDecimal(800.00); BoCTransaction account3 = new BoCTransaction(); account3.setTransactionValue(value3); account3.setTransactionValue(value4); | 500              | 500          | passed |                                                              | if the transactionValue is not null then continue the next move else do not set the transaction value again. |

#### Function: setTransactionCategory(int tCat)
##### Contributor: Wangji Wei
| Test | Time           | Inputs                                                       | Expected Outcome | Test Outcome | Result | Failure reason | Change |
| ---- | -------------- | ------------------------------------------------------------ | ---------------- | ------------ | ------ | -------------- | ------ |
| 1    | 21/04/17 21:02 | int category = 88; BoCTransaction account1 = new BoCTransaction(); account1.setTransactionCategory(category); | 88               | 88           | Passed |                |        |
| 2    | 21/04/17 21:15 | int cate1 = 1;int cate2 = 2;BoCTransaction account2 = new BoCTransaction();account2.setTransactionCategory(cate1);account2.setTransactionCategory(cate2); | 2                | 2            | Passed |                |        |


#### Function: isComplete()
##### Contributor: Jiachen Zhang
| Test | Time           | Inputs                                                       | Expected Outcome | Test Outcome | Result | Failure reason           | Change           |
| ---- | -------------- | ------------------------------------------------------------ | ---------------- | ------------ | ------ | ------------------------ | ---------------- |
| 1    | 21/04/19 19:10 | BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1); | 1                |              | error  | there is no isComplete() | add isComplete() |
| 2    | 21/04/28 16:00 | BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1); | 2                | 2            | Passed |                          |                  |
| 3    | 21/04/28 16:00 | BoCTransaction myAnswer1 = new BoCTransaction();             | 1                | 1            | Passed |                          |                  |

#### Function: toString()
##### Contributor: Jiachen Zhang
| Test | Time           | Inputs                                                       | Expected Outcome | Test Outcome | Result | Failure reason | Change |
| ---- | -------------- | ------------------------------------------------------------ | ---------------- | ------------ | ------ | -------------- | ------ |
| 1    | 21/04/19 19:30 | BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1); | abc - ¥22        | abc - ¥22    | Passed |                |        |
| 2    | 21/04/28 19:30 | BigDecimal value = new BigDecimal("22");BoCTransaction myAnswer1 = new BoCTransaction("abc", value, 1); | abc(1) - ¥22     | abc - ¥22    | Passed |                |        |

### Class: BoC Category

#### Function: BoCCategory()

##### Contributor: Siyu YAO

| Test | Time           | Inputs                                                       | Expected Outcome         | Test Outcome             | Result | Failure reason                                               | Change                                                       |
| ---- | -------------- | ------------------------------------------------------------ | ------------------------ | ------------------------ | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | 21/04/19 10:32 | Construct a new object and test if it is successfully constructed | NotNull                  | Null                     | Failed | @Before and @After is no longer exist in Junit5, use @BeforeEach and @AfterEach instead | Change the test code: @Before and @After to @BeforeEach and @AfterEach |
| 2    | 21/04/19 10:38 | Construct a new object and test if it is successfully constructed | NotNull                  | NotNull                  | Passed |                                                              |                                                              |
| 3    | 21/04/19 10:45 | assertEquals("New Category", category.CategoryName());    assertEquals(0.00, category.CategoryBudget());       assertEquals(0.00, category.CategorySpend()); | "New Category" 0.00 0.00 | "New Category" 0.00 0.00 | Failed | CategoryBudget methord returns BigDecimal should use String instead of Double | Change the test code to: assertEquals("0.00", category.CategoryBudget());assertEquals("0.00", category.CategorySpend()); |
| 4    | 21/04/19 10:52 | assertEquals("New Category", category.CategoryName());    assertEquals("0.00", category.CategoryBudget());       assertEquals("0.00", category.CategorySpend()); | "New Category" 0.00 0.00 | "New Category" 0.00 0.00 | Failed | Should creat a new BigDecimal value to compare the result    | Change the test code to:       BigDecimal bd = new BigDecimal("0.00");          assertEquals(bd, category.CategoryBudget());      assertEquals(bd, category.CategorySpend()); |
| 5    | 21/04/19 11:08 | assertEquals("New Category", category.CategoryName());      assertEquals(bd, category.CategoryBudget());         assertEquals(bd, category.CategorySpend()); | "New Category" 0.00 0.00 | "New Category" 0.00 0.00 | Passed |                                                              |                                                              |

#### Function: BoCCategory(String newTitle)

##### Contributor: Jing ZHANG

| Test | Time           | Inputs                                   | Expected Outcome                                             | Test Outcome                                                 | Result | Failure reason                                               | Change                                                       |
| ---- | -------------- | ---------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | 21/04/20 19:02 | "Cloth"                                  | category.CategoryName = "Cloth"; category.CategoryBudget = 0.00; category.CategoryBudget = 0.00; | category.CategoryName = "Cloth"; category.CategoryBudget = 0.00;  category.CategoryBudget = 0.00; | Passed |                                                              |                                                              |
| 2    | 21/04/20 19:10 | "This string is more than 15 characters" | "Title could not be more than 15 characters, please enter again:" | category.CategoryName = "This string is more than 15 characters"; category.CategoryBudget =   0.00;  category.CategoryBudget = 0.00; | Failed |                                                              |                                                              |
| 3    | 21/04/20 19:12 | NULL                                     | "Title could not be NULL, please enter again:"               | category.CategoryName = NULL; category.CategoryBudget = 0.00;  category.CategoryBudget = 0.00; | Failed |                                                              |                                                              |
| 4    | 21/04/22 18:40 | Unknown                                  | category.CategoryName = "Unknown"; category.CategoryBudget = 0.00; category.CategoryBudget = 0.00; | category.CategoryName = "Unknown"; category.CategoryBudget = 0.00; category.CategoryBudget = 0.00; | Passed |                                                              |                                                              |
| 5    | 21/04/28 20:25 | "This string is more than 15 characters" | "Title could not be more than 15 characters, please enter again:" | "Title could not be more than 15 characters, please enter again:" | Passed | \|when inputting the string more than 15 characters, the program won't throw out the expectation. | Change the source code, use do while to to avoid user input illegal category name |
| 6    | 21/04/28 20:25 | NULL                                     | "Title could not be NULL, please enter again:"               | "Title could not be NULL, please enter again:"               | Passed | \|when inputting null, the program won't throw out the expectation. | Change the source code, use do while to to avoid user input illegal category name |

#### Function: CategoryName() 

##### Contributor: Siyu YAO

| Test | Time           | Inputs                                                       | Expected Outcome         | Test Outcome    | Result | Failure reason | Change |
| ---- | -------------- | ------------------------------------------------------------ | ------------------------ | --------------- | ------ | -------------- | ------ |
| 1    | 21/04/19 21:35 | Creat two objects, one by defult construct, another by construct with String as parameter. Test althouth they have different id address, CategoryName() will return same String value. | NotSame  Equals          | NotSame  Equals | Passed |                |        |
| 2    | 21/04/20 20:54 | name = "food"; setCategoryName(name); String get = category.CategoryName(); | set name and get is Same | Same            | Passed |                |        |

#### Function: CategoryBudget()

##### Contributor: Xingyan QU

Should return a BigDecimal of the category’s budget.

| Test | Time           | Inputs  | Expected Outcome | Test Outcome | Result | Falure reason | Change                                     |
| ---- | -------------- | ------- | ---------------- | ------------ | ------ | ------------- | ------------------------------------------ |
| 1    | 21/04/20 8:45  | 2220.00 | budget = 2220.00 | 2220.00      | Passed |               |                                            |
| 2    | 21/04/28 18:50 | 2220.00 | budget = 2220.00 | 2220.00      | Passed |               | fix code to check validation of user input |

#### Function: CategorySpend()

##### Contributor: Xingyan QU

Should return a BigDecimal of the category’s current spend total.
Here I set budget to be 3000.00


| Test | Time          | Inputs                                   | Expected Outcome | Test Outcome | Result | Failure reason                               | Change                                  |
| ---- | ------------- | ---------------------------------------- | ---------------- | ------------ | ------ | -------------------------------------------- | --------------------------------------- |
| 1    | 21/4/22 8:35  | new spend of 234.00, a remove of 200.00  | 34.00            | 34.00        | Passed |                                              |                                         |
| 2    | 21/4/22 8:26  | new spend of 234.00, a remove of 300.00  | 234.00           | -66.00       | Failed | couldn't handle properly when remove > spend |                                         |
| 3    | 21/4/22 8:44  | new spend of 234.00, a remove of -300.00 | 234.00           | 534.00       | Failed | couldn't handle properly when remove <0      |                                         |
| 4    | 21/4/22 19:02 | new spend of -234.00, a remove of 200.00 | 0.00             | -234.00      | Failed | couldn't handle properly when spend<0        |                                         |
| 5    | 21/4/28 19:26 | new spend of 234.00, a remove of 300.00  | 234.00           | -66.00       | passed |                                              | fix source code to handle this properly |
| 6    | 21/4/28 19:49 | new spend of 234.00, a remove of -300.00 | 234.00           | 534.00       | passed |                                              | fix source code to handle this properly |
| 7    | 21/4/28 20:02 | new spend of -234.00, a remove of 200.00 | 0.00             | -234.00      | passed |                                              | fix source code to handle this properly |

#### Function: public void setCategoryName(String newName)  AND  public String CategoryName()

##### Contributor: Siyu YAO

| Test | Time           | Inputs                                                       | Expected Outcome                                 | Test Outcome                                                 | Result            | Failure reason                                        | Change                                                       |
| ---- | -------------- | ------------------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------------------ | ----------------- | ----------------------------------------------------- | ------------------------------------------------------------ |
| 1    | 21/04/19 17:44 | @ValueSource(strings = { "food", "shopping", "transportation"}) | food shopping transportation                     | food shopping transportation                                 | Passed 3          |                                                       |                                                              |
| 2    | 21/04/19 20:31 | "this is a sentence more than 15 characters"                 | NotEquals, should alart the user                 | Equals                                                       | Faileed           | The setCategoryName method couldn't handle this cases | Change the test code to: _try catch exception_ and change the java class code to:  _throws Exception_ |
| 3    | 21/04/19 20:47 | @ValueSource(strings = { "food", "shopping", "transportation","this is a sentence more than 15 characters"} | Pass all four tests                              | Errors in "food" "shopping" "transportation", Passed the last one | Errors 3 Passed 1 | "Unhandled exception type exception"                  | Change back the test code and java class code to last modified |
| 4    | 21/04/19 20:51 | "this is a sentence more than 15 characters"                 | NotEquals, should alart the user                 | Equals                                                       | Failed            | The setCategoryName method couldn't handle this cases | **Need improve the java class code**                         |
| 5    | 21/04/19 20:57 | "Unknown"                                                    | NotEquals, should alart the user                 | Equals                                                       | Failed            | The setCategoryName method couldn't handle this cases | **Need improve the java class code**                         |
| 6    | 21/04/20 20:16 | "   "                                                        | CategoryName is not blank, should alart the user | Blank                                                        | Failed            | The setCategoryName method couldn't handle this cases | **Need improve the java class code**                         |

#### Function: setCategoryBudget(BigDecimal newValue)

##### Contributor: Jing ZHANG

| Test | Time           | Inputs | Expected Outcome                      | Test Outcome                          | Result | Failure reason                                               | Change                                                       |
| ---- | -------------- | ------ | ------------------------------------- | ------------------------------------- | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | 21/04/21 18:32 | 1234   | category.CategoryBudget = 1234        | category.CategoryBudget = 1234.00     | Passed |                                                              |                                                              |
| 2    | 21/04/21 18:32 | 0.00   | "Illegal budget, please enter again:" | category.CategoryBudget = 0.00        | Failed | When the user input the wrong numeric, the program have not ask the user to input again |                                                              |
| 3    | 21/04/21 18:32 | -1234  | "Illegal budget, please enter again:" | category.CategoryBudget = 0.00        | Failed | When the user input the wrong numeric, the program have not ask the user to input again |                                                              |
| 4    | 21/04/28 20:05 | 0.00   | "Illegal budget, please enter again:" | "Illegal budget, please enter again:" | Failed | When the user input the wrong numeric, the program have not ask the user to input again | Use do while to to avoid user input illegal budget value, if user input illegal budget value, should enter again |
| 5    | 21/04/28 20:25 | -1234  | "Illegal budget, please enter again:" | "Illegal budget, please enter again:" | Failed | When the user input the wrong numeric, the program have not ask the user to input again | Use do while to to avoid user input illegal budget value, if user input illegal budget value, should enter again |

#### Function: addExpense(BigDecimal valueToAdd)

##### Contributor: Xingyan QU

This function should take a BigDecimal and ad it to the current toal spend for the category.
Here I set budget to be 3000.00

| Test | Time           | Inputs                  | Expected Outcome | Test Outcome | Result | Falure reason                               | Change                          |
| ---- | -------------- | ----------------------- | ---------------- | ------------ | ------ | ------------------------------------------- | ------------------------------- |
| 1    | 21/04/21 12:20 | add a new spend 2300.00 | 2300.00          | 2300.00      | Passed |                                             |                                 |
| 2    | 21/04/21 12:31 | add a new spend -5.00   | 2300.00          | 2295.00      | Failed | couldn't handle the negative spend properly |                                 |
| 3    | 21/04/21 12:56 | add a new spend 6000.00 | 8295.00          | 8295.00.00   | Passed |                                             |                                 |
| 4    | 21/04/28 12:34 | add a new spend -5.00   | 2300.00          | 2300.00      | Passed |                                             | fix code to check invalid input |

#### Function: removeExpense(BigDecimal valueToRemove)

##### Contributor: Xingyan QU

This function sould take a BigDecimal and subtract it from the current total spend for the category.
Here I set budget to be 3000.00, plus before each round of test, add a new spend of 500.00.

| Test | Time           | Inputs  | Expected Outcome | Test Outcome | Result | Falure reason                                                | Change                                                       |
| ---- | -------------- | ------- | ---------------- | ------------ | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | 21/04/21 18:34 | 5.00    | 495.00           | 495.00       | Passed |                                                              |                                                              |
| 2    | 21/04/21 18:50 | -5.00   | 995.00           | 1000.00      | Failed | the source code didn't handle the invalid input where the remove amount is negative |                                                              |
| 3    | 21/04/21 18:55 | 6000.00 | 1500.00          | -4500.00     | Failed | the source code didn't handle the invalid input where the remove amount bigger than the total spend |                                                              |
| 4    | 21/04/29 8:40  | -5.00   | 995.00           | 995.00       | Passed |                                                              | fix source code to handle the invalid input where the remove amount is negative |
| 5    | 21/04/29 8:46  | 6000.00 | 1495.00          | 1495.00      | Passed |                                                              | fix source code to handle the invalid input where the remove amount bigger than the total spend |


#### Function: resetBudgetSpend() 

##### Contributor: Jing ZHANG

| Test | Time           | Inputs | Expected Outcome               | Test Outcome                   | Result | Failure reason | Change |
| ---- | -------------- | ------ | ------------------------------ | ------------------------------ | ------ | -------------- | ------ |
| 1    | 21/04/21 18:50 | 1234   | category.CategoryBudget = 0.00 | category.CategoryBudget = 0.00 | Passed |                |        |
| 2    | 21/04/21 18:50 | 0.00   | category.CategoryBudget = 0.00 | category.CategoryBudget = 0.00 | Passed |                |        |

#### Function: getRemainingBudget()

##### Contributor: Jing ZHANG

| Test | Time           | Inputs    | Expected Outcome | Test Outcome | Result | Failure reason | Change |
| ---- | -------------- | --------- | ---------------- | ------------ | ------ | -------------- | ------ |
| 1    | 21/04/21 19:20 | 1111 1000 | 111              | 111          | Passed |                |        |
| 2    | 21/04/21 19:25 | 1000 1000 | 0                | 0            | Passed |                |        |
| 3    | 21/04/21 19:50 | 1000 2000 | -1000            | -1000        | Passed |                |        |

#### Function: @Override   public String toString()

##### Contributor: Siyu YAO

| Test | Time           | Inputs                                                    | Expected Outcome                                       | Test Outcome                                            | Result | Failure reason                                               | Change                         |
| ---- | -------------- | --------------------------------------------------------- | ------------------------------------------------------ | ------------------------------------------------------- | ------ | ------------------------------------------------------------ | ------------------------------ |
| 1    | 21/04/20 19:33 | name = "testname", budget = "3000.00", spent1 = "2573.42" | testname(¥3000.00) - Est. ¥2573.42 (¥426.58 Remaining) | testname(¥3000.00) - Est. ¥2573.42 (¥426.58 Remaining)  | Passed |                                                              |                                |
| 2    | 21/04/20 19:39 | name = "testname", budget = "3000.00", spent1 = "3281.07" | testname(¥3000.00) - Est. ¥3281.07 (¥281.07 Overspent) | testname(¥3000.00) - Est. ¥3281.07 (¥-281.07 Remaining) | Failed | The toString methord cannot handle if the spent is more than budget and return the wrong format | **Need improve the java code** |

### Class: BoC App

#### Function: AddTransaction(Scanner in)

##### Contributor: Jiachen ZHANG

| Test | Time          | Inputs                                       | Expected Outcome                                             | Test Outcome                                                 | Result | Failure reason     | Change                                                       |
| ---- | ------------- | -------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ------------------ | ------------------------------------------------------------ |
| 1    | 21/4/27 19:00 | title = "abc" , value = "600" , Category = 1 | What is the title of the transaction? What is the value of the transaction? [abc(1000)was added to 1] | What is the title of the transaction? What is the value of the transaction? [Transaction added] | Failed | they are not equal | add optionally a category, show “[Transaction Name](¥value)was added to [Category Name]” |
| 2    | 21/4/28 19:00 | title = "abc" , value = "600" , Category = 1 | What is the title of the transaction? What is the value of the transaction? "What is the category ID of the transaction?" "(Press \"Enter\" will set to \"Unknow\" automatically)" "[abc](¥1000) was added to [1]" | What is the title of the transaction? What is the value of the transaction? "What is the category ID of the transaction?" "(Press \"Enter\" will set to \"Unknow\" automatically)" "[abc](¥1000) was added to [1]" | Passed |                    |                                                              |
| 3    | 21/4/28 19:00 | title = "abc" , value = "600" , Category = 1 | What is the title of the transaction? What is the value of the transaction? "What is the category ID of the transaction?" "(Press \"Enter\" will set to \"Unknow\" automatically)" "[abc](¥1000) was added to [Unknow]" | What is the title of the transaction? What is the value of the transaction? "What is the category ID of the transaction?" "(Press \"Enter\" will set to \"Unknow\" automatically)" "[abc](¥1000) was added to [Unknow]" | Passed |                    |                                                              |


#### Function: ChangeTransactionCategory(Scanner in)

##### Contributor: Siyu YAO

| Test | Time           | Inputs                                                       | Expected Outcome                                             | Test Outcome                                                 | Result | Failure reason                                               | Change                                                  |
| ---- | -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ------------------------------------------------------------ | ------------------------------------------------------- |
| 1    | 21/04/26 20:52 | new Scanner ("\n1\n2\n");   Created two ArrayList object to store UserCategories before and after method calls;   ArrayLista.equals(ArrayListb) | NotEquals                                                    | Equals                                                       | Failed |                                                              | Change to compare the categories' spend not equal       |
| 2    | 21/04/26 21:20 | new Scanner ("\n1\n2\n");                                    | The categories' spend should not equal before and after method calls | Equals                                                       | Failed | Two categories are both created after the method calls       | Change one categorire to be created before mathod calls |
| 3    | 21/04/27 15:57 | new Scanner ("\n1\n2\n");                                    | The categories' spend should not equal before and after method calls | NotEquals                                                    | Passed |                                                              |                                                         |
| 4    | 21/04/27 16:40 | new Scanner ("\n1\n2\n"), 1, 2; new Scanner ("\n2\n2\n"), 2, 2 | categorieSpend and transactionCategory should not equal before and after method calls | NotEquals                                                    | Passed |                                                              |                                                         |
| 5    | 21/04/27 17:20 | new Scanner ("\n1\n2\n"), 1, 2; new Scanner ("\n2\n2\n"), 2, 2;   assertThat(outContent.toString(), containsString(confirmation)); | The printed information should contains some confirmation information | Not contain                                                  | Failed | The method assertThat is deprecated                          | import static org.hamcrest.MatcherAssert.assertThat;    |
| 6    | 21/04/27 17:24 | new Scanner ("\n1\n2\n"), 1, 2; new Scanner ("\n2\n2\n"), 2, 2;   assertThat(outContent.toString(), containsString(confirmation)); | The printed information should contains some confirmation information | Not contain                                                  | Failed | The program cannot print the confirmation because it didn't have the relevant code. | **Need to improve the Java code, add new function**     |
| 7    | 21/04/29 1:04  | new Scanner ("\n1\n2\n"), 1, 2; new Scanner ("\n2\n2\n"), 2, 2;   assertThat(outContent.toString(), containsString(confirmation)); | The printed information should contains some confirmation information | The printed information should contains some confirmation information | Passed |                                                              |                                                         |





#### Function:  AddCategory(Scanner in)

##### Contributor: Jing ZHANG

| Test | Time           | Inputs                           | Expected Outcome                                             | Test Outcome                                                 | Result | Failure reason                                        | Change                                     |
| ---- | -------------- | -------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ----------------------------------------------------- | ------------------------------------------ |
| 1    | 21/04/26 22:12 | title = 'Cloth' cbudget = 100.00 | new_CategoryName = 'Cloth' new_CategoryBudget = 100.00       | Passed                                                       |        |                                                       |                                            |
| 2    | 21/04/28 12:12 | title = 'Cloth' cbudget = 100.00 | What is the title of the category?  What is the budget for this category?  [Category added]  1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)  2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)  3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)  4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)  5) Cloth(¥100.00) - ¥0.00 (¥100.00 Remaining) | What is the title of the category?  What is the budget for this category?  [Category added]  1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)  2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)  3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)  4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)  5) Cloth(¥100.00) - ¥0.00 (¥100.00 Remaining) | Failed | The output of function CategoryOverview() has problem |                                            |
| 3    | 21/04/28 23:26 | title = 'Cloth' cbudget = 100.00 | What is the title of the category?  What is the budget for this category?  [Category added]  1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)  2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)  3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)  4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)  5) Cloth(¥100.00) - ¥0.00 (¥100.00 Remaining) | What is the title of the category?  What is the budget for this category?  [Category added]  1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)  2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)  3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)  4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)  5) Cloth(¥100.00) - ¥0.00 (¥100.00 Remaining) | Failed |                                                       | The problem of other method has been fixed |



#### Function:  ListTransactions()

##### Contributor: Xingyan Qu

This function should : loop through all the transactions, listing them out to the user in format: - E.g. “SanJiang shopping (groceries) - ¥186.90

| Test | Time           | Inputs | Expected Outcome                                             | Test Outcome                                                 | Result | Failure reason                      | Change                                                  |
| ---- | -------------- | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ----------------------------------- | ------------------------------------------------------- |
| 1    | 21/04/26 18:30 | "T"    | 1) Rent(Unknown) - ¥850.00<br/>2) Phone Bill(Bills) - ¥37.99<br/>3) Electricity Bill(Bills) - ¥75.00<br/>4) Sainsbury's Checkout(Groceries) - ¥23.76<br/>5) Tesco's Checkout(Groceries) - ¥7.24<br/>6) RockCity Drinks(Social) - ¥8.50<br/>7) The Mooch(Social) - ¥13.99 | 1) Rent - ¥850.00<br/>2) Phone Bill - ¥37.99<br/>3) Electricity Bill - ¥75.00<br/>4) Sainsbury's Checkout - ¥23.76<br/>5) Tesco's Checkout - ¥7.24<br/>6) RockCity Drinks - ¥8.50<br/>7) The Mooch - ¥13.99 | fail   | wrong fomat : lack of category name | need fix this in ** Class: BoCTransaction ** toString() |



#### Function: CategoryOverview()

##### Contributor: Xingyan Qu

This function should loop through the transactions creating summaries for each category, and then print out a list of categories and how much has been spent in that category in total, e.g.
			Bills (Budget: ¥2000.00) - ¥1532.98 (¥467.02 Remaining)
			Groceries (Budget:1800.00）- ¥2412.53 (¥342.53 Overspent)

| Test | Time           | Inputs | Expected Outcome                                             | Test Outcome                                                 | Result | Falure  reason | Change                                   |
| ---- | -------------- | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | -------------- | ---------------------------------------- |
| 1    | 21/04/26 18:55 | "O"    | 1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining) | 1) Unknown(¥0.00) - Est. ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining) | fail   | wrong fomat    |                                          |
| 2    | 21/04/29 10:05 | "O"    | 1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining) | 1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining) | passed |                | fix to get correct format in source code |

 

#### Function:  ListTransactionsForCategory(int chosenCategory) 

##### Contributor: Xingyan Qu

This function should take a category ID as a parameter, and uses it to filter the transactions for the given category. The list of transactions should be like the list transactions function, plus stating a category first.


| Test | Time           | Inputs | Expected Outcome                                             | Test Outcome                                                 | Result | Failure reason                                               | Change                                                       |
| ---- | -------------- | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | 21/04/26 20:43 | "1"    | Unknown:<br/>1) Rent(Unknown) - ¥850.00                      | 2) Phone Bill - ¥37.99<br/>3) Electricity Bill - ¥75.00      | fail   | wrong fomat : lack of category name and didn't stating the category first，wrong index |                                                              |
| 2    | 21/04/26 20:43 | "2"    | Bills:<br/>2) Phone Bill(Bills) - ¥37.99<br/>3) Electricity Bill(Bills) - ¥75.00 | 4) Sainsbury's Checkout - ¥23.76<br/>5) Tesco's Checkout - ¥7.24 | fail   | wrong fomat : lack of category name and didn't stating the category first，wrong index |                                                              |
| 3    | 21/04/26 20:43 | "3"    | Groceries:<br/>4) Sainsbury's Checkout(Groceries) - ¥23.76<br/>5) Tesco's Checkout(Groceries) - ¥7.24 | 6) RockCity Drinks - ¥8.50<br/>7) The Mooch - ¥13.99         | fail   | wrong fomat : lack of category name and didn't stating the category first，wrong index |                                                              |
| 4    | 21/04/26 20:43 | "4"    | Social:<br/>6) RockCity Drinks(Social) - ¥8.50<br/>7) The Mooch(Social) - ¥13.99 | Exception                                                    | fail   | wrong index                                                  |                                                              |
| 5    | 21/04/28 19:21 | "1"    | Unknown:<br/>1) Rent(Unknown) - ¥850.00                      | Unknown:<br/>1) Rent(Unknown) - ¥850.00                      | pass   |                                                              | change source code: give a check on user's input and print error message if invalid. If valid ,state the category name first,fix index |
| 6    | 21/04/28 19:21 | "2"    | Bills:<br/>2) Phone Bill(Bills) - ¥37.99<br/>3) Electricity Bill(Bills) - ¥75.00 | Bills:<br/>2) Phone Bill(Bills) - ¥37.99<br/>3) Electricity Bill(Bills) - ¥75.00 | pass   |                                                              | change source code: give a check on user's input and print error message if invalid. If valid ,state the category name first,fix index |
| 7    | 21/04/28 19:21 | "3"    | Groceries:<br/>4) Sainsbury's Checkout(Groceries) - ¥23.76<br/>5) Tesco's Checkout(Groceries) - ¥7.24 | Groceries:<br/>4) Sainsbury's Checkout(Groceries) - ¥23.76<br/>5) Tesco's Checkout(Groceries) - ¥7.24 | pass   |                                                              | change source code: give a check on user's input and print error message if invalid. If valid ,state the category name first,fix index |
| 8    | 21/04/28 19:21 | "4"    | Social:<br/>6) RockCity Drinks(Social) - ¥8.50<br/>7) The Mooch(Social) - ¥13.99 | Social:<br/>6) RockCity Drinks(Social) - ¥8.50<br/>7) The Mooch(Social) - ¥13.99 | pass   |                                                              | change source code: give a check on user's input and print error message if invalid. If valid ,state the category name first,fix index |

#### Function: main(String[] args)

##### Contributor: Xingyan Qu

| Test | Time             | Inputs                                       | Expected Outcome                                             | Test Outcome                                                 | Result | Falure reason                                                | Change                                    |
| ---- | ---------------- | -------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ------------------------------------------------------------ | ----------------------------------------- |
| 1    | 21/04/27 13:22   | "T"+"\r"+"X"                                 | 1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/><br/>What do you want to do?<br/> T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/>1) Rent(Unknown) - ¥850.00<br/>2) Phone Bill(Bills) - ¥37.99<br/>3) Electricity Bill(Bills) - ¥75.00<br/>4) Sainsbury's Checkout(Groceries) - ¥23.76<br/>5) Tesco's Checkout(Groceries) - ¥7.24<br/>6) RockCity Drinks(Social) - ¥8.50<br/>7) The Mooch(Social) - ¥13.99<br/><br/>What do you want to do?<br/> O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/>Goodbye! | 1) Unknown(¥0.00) - Est. ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)<br/><br/>What do you want to do?<br/> T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/>1) Rent - ¥850.00<br/>2) Phone Bill - ¥37.99<br/>3) Electricity Bill - ¥75.00<br/>4) Sainsbury's Checkout - ¥23.76<br/>5) Tesco's Checkout - ¥7.24<br/>6) RockCity Drinks - ¥8.50<br/>7) The Mooch - ¥13.99<br/><br/>What do you want to do?<br/> O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/>Goodbye! | fail   | wrong format in CategoryOverview() and ListTransactions()    |                                           |
| 2    | 21/04/28 13:05   | "N"+"\r"+"study"+"\r"+"900"+"\r"             | "1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/>What do you want to do?<br/>T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/>What is the title of the category?<br/>What is the budget for this category?<br/>[Category added]:<br/>1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/>5) study(¥900) - ¥0.00 (¥900.00 Remaining)<br/><br/>What do you want to do?<br/>O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/> | 1) Unknown(¥0.00) - Est. ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)<br/><br/>What do you want to do?<br/> T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/>What is the title of the category?<br/>What is the budget for this category?<br/>[Category added]<br/>1) Unknown(¥0.00) - Est. ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)<br/>5) study(¥900) - Est. ¥0.00 (¥900.00 Remaining)<br/><br/>What do you want to do?<br/>O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it | fail   | wrong format in CategoryOverview() and ListTransactions(), also lack of confirmation and didn't show the result |                                           |
| 3    | 21/04/28   18:35 | "N"+"\r"+"study"+"\r"+"900"+"\r"             | "1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/>What do you want to do?<br/>T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/>What is the title of the category?<br/>What is the budget for this category?<br/>[Category added]:<br/>1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/>5) study(¥900) - ¥0.00 (¥900.00 Remaining)<br/><br/>What do you want to do?<br/>O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/> | "1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/>What do you want to do?<br/>T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/>What is the title of the category?<br/>What is the budget for this category?<br/>[Category added]:<br/>1) Unknown(¥0.00) - ¥850.00 (¥-850.00 Remaining)<br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/>5) study(¥900) - ¥0.00 (¥900.00 Remaining)<br/><br/>What do you want to do?<br/>O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/> | Passed |                                                              | fix problem   stated above in source code |
| 4    | 21/04/28 13:21   | "A"+"\r"+"drink"+"\r"+"3"+"\r"+"50"+"\r"+"3" | 1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)<br/><br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/><br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/><br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/><br/><br/><br/>What do you want to do?<br/><br/> T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/><br/>What is the title of the transaction?<br/><br/>What is the category of the transaction?<br/><br/>(Press "Enter" will set to "Unknown" automatically)<br/><br/><br/>What is the value of the transaction?<br/><br/>drink(¥50) was added to Groceries<br/><br/><br/><br/>What do you want to do?<br/> <br/>O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/><br/>Groceries:<br/><br/>4) Sainsbury's Checkout(Groceries) - ¥23.76<br/><br/>5) Tesco's Checkout(Groceries) - ¥7.24<br/><br/>8) drink(Groceries) - ¥50<br/><br/><br/><br/>What do you want to do?<br/><br/> O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/> | 1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)<br/><br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/><br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/><br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/><br/><br/><br/>What do you want to do?<br/><br/> T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/><br/>What is the title of the transaction?<br/><br/>What is the value of the transaction?<br/><br/>[Transaction added]<br/><br/><br/><br/>What do you want to do?<br/><br/> O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/><br/>Invalid index<br/><br/><br/><br/>What do you want to do?<br/><br/> O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/><br/>Groceries:<br/><br/>4) Sainsbury's Checkout(Groceries) - ¥23.76<br/><br/>5) Tesco's Checkout(Groceries) - ¥7.24<br/><br/><br/><br/>What do you want to do?<br/><br/> O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it | fail   | wrong format in CategoryOverview(),ListTransactions() and confirmation , didn't provide user the option to assign a category |                                           |
| 5    | 21/04/28 14:26   | "A"+"\r"+"drink"+"\r"+"3"+"\r"+"50"+"\r"+"3" | 1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)<br/><br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/><br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/><br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/><br/><br/><br/>What do you want to do?<br/><br/> T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/><br/>What is the title of the transaction?<br/><br/>What is the category of the transaction?<br/><br/>(Press "Enter" will set to "Unknown" automatically)<br/><br/><br/>What is the value of the transaction?<br/><br/>drink(¥50) was added to Groceries<br/><br/><br/><br/>What do you want to do?<br/> <br/>O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/><br/>Groceries:<br/><br/>4) Sainsbury's Checkout(Groceries) - ¥23.76<br/><br/>5) Tesco's Checkout(Groceries) - ¥7.24<br/><br/>8) drink(Groceries) - ¥50<br/><br/><br/><br/>What do you want to do?<br/><br/> O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/> | 1) Unknown(¥0.00) - ¥850.00 (¥850.00 Overspent)<br/><br/>2) Bills(¥120.00) - ¥112.99 (¥7.01 Remaining)<br/><br/>3) Groceries(¥75.00) - ¥31.00 (¥44.00 Remaining)<br/><br/>4) Social(¥100.00) - ¥22.49 (¥77.51 Remaining)<br/><br/><br/><br/>What do you want to do?<br/><br/> T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it<br/><br/>What is the title of the transaction?<br/><br/>What is the category of the transaction?<br/><br/>(Press "Enter" will set to "Unknown" automatically)<br/><br/><br/>What is the value of the transaction?<br/><br/>drink(¥50) was added to Groceries<br/><br/><br/><br/>What do you want to do?<br/> <br/>O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/><br/>Groceries:<br/><br/>4) Sainsbury's Checkout(Groceries) - ¥23.76<br/><br/>5) Tesco's Checkout(Groceries) - ¥7.24<br/><br/>8) drink(Groceries) - ¥50<br/><br/><br/><br/>What do you want to do?<br/><br/> O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it<br/> | Passed |                                                              | fix problem stated above                  |

