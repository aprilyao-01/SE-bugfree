# Test Report
## Contents
* [Introduction](#introduction)
* [Version History Log](#version-history-log)
* [Team Management](#team-management)
    * [Team member & Contribution](#Team-member-&-contribution)
    * [Timeline](#timeline)
        * [Self-learning JUnit](#self-learning-junit)
        * [Writing JUnit Test](#writing-junit-test)
        * [Writing Integration Test](#writing-integration-test)
        * [Fixing and Improving Code](#fixing-and-improving-code)
        * [Final Checking](#final-checking)
    * [Team Strategy](#team-strategy)
    * [Problems & Solutions](#problems-&-solutions)
* [Test Plan](#test-plan)
    * [BoCTransaction](#class-boctransaction)
    * [BoCCategory](#class-boccategory)
    * [BoCApp](#class-bocapp)
* [Conclusion](#conclusion)

## Introduction
Hi! Here is BUGFREE! On April 15th, Donna turned to us and hope we could devised tests to fix the bad code for the project with Bank of China (BoC). After reading the class description and the codes, we found that many features have not been implemented or have some problems need to be fix. Moreover, the code is not so efficient and maintainable and need to be refactored.Thus, we started our first meeting, and arranging our timeline for testing and fixing the code. 

This report is aims to present test scenarios and results, summary the whole process and conclude for our teamwork. In this report, first we will talk about our team management, including the contribution of each members, the process of our team work(i.e. timeline), our team strategies and the problems we faced during this process. The second part is our test plan, including the test information, test time etc.

## Version History Log
|Major Version|Release Date|Significant changes|Issues/Bugs|
|-------------|------------|-------------------|-----------|
|Coursework03-v1.1|2021/04/20 17:04|Create a Java Project||
|Coursework03-v1.2|2021/4/23 13:52|Roughly finish the JUnit test for BoCCategory||
|Coursework03-v1.3|2021/4/24 17:32|Roughly finish the JUnit test for BoCTransaction||
|Coursework03-v1.4|2021/04/24 20:45|Roughly complete JUnit test|Java project can not be run in local computer|
|Coursework03-v2.0|2021/04/24 20:45|Complete the JUnit test & solve the problem that JUnit could not run in local computer||
|Coursework03-v2.1|2021/4/27 21:37|Complete part of the Integration Test||
|Coursework03-v2.2|2021/4/28 19:08|Roughly complete the Integration Test||
|Coursework03-v3.1|2021/4/29 01:03|Finishing the Integration test & Fixing part of the code in three source code||
|Coursework03-v4.1|2021/4/29 01:57|The code in BoCCategory and BoCTransaction has been fixed||
|Coursework03-v4.2|2021/4/29 01:57|Roughly fix the BoCApp and some bug||

## Team Management
### Team member & Contribution
Here is our team members!
|Name|Contributions|
|----|-------------|
|Jing ZHANG (Ankie)|Write JUnit test, test plan and fix code for the 2, 7, 10, 11 methods in BoCCategory<br>Write Integration test, test plan and fix code for the 7st method in BoCApp<br>Write Team Management part of test report|
|Jiachen ZHANG (Zack)|Write JUnit test, test plan and fix code for the 1~7 methods in BoCTransaction<br>Write Integration test, test plan and fix code for the 6th method in BoCApp|
|Siyu YAO (April)|Write JUnit test, test plan and fix code for the 1, 3, 6, 12 methods in BoCCategory<br>Write Integration test, test plan and fix code for the 5th method in BoCApp|
|Wangji WEI (Eagle)|Write JUnit test, test plan and fix code for the 8~12 methods in BoCTransaction <br>Pair coding with Amanda to write Integration test for main method in BoCApp <br>Fix code for the 4, 5, 8, 9 methods in BoCCategory|
|Xingyan QU (Amanda)|Write JUnit test, test plan for the 4, 5, 8, 9 methods in BoCCategory <br>Write Integration test, test plan and fix code for 2~4 method in BoCApp<br>Pair coding with Eagle to write Integration test for main method|
-------------------------------------
### Timeline

In total, we have whole two weeks to finish the work. And we have separated it into **5 phases**, **self-learning JUnit**, **writing JUnit test**, **writing integration test**, **fixing and improving code** and **final checking**.

#### Self-learning JUnit 
##### 21/4/15 - 21/4/19

1. 21/4/15 - Coursework released: In the lab that the coursework 3 has released, after discussion, we found that we still not familiar with how to write JUnit test. Then we decided to self-learning how to write JUnit test.
2. 21/4/19 - **1st Group Meeting**: 
* Shared and discussed what we have learned.
* Analysis the requirements of coursework 3 and the class description.
* Arrange the whole timeline and set the milestones.
* Separated into two groups in order to do the JUnit test for BoCCategory and BoCTransaction.
3. The first milestone - "Self-learning JUnit" was successfully closed on 21/4/19.

#### Writing JUnit Test 
##### 21/4/19 - 21/4/24

1. Writing JUnit test by individual and discussed in group for the problems we faces when writing JUnit.
2. 21/4/22 - **2nd Group Discussion**:
* Discussed the problems we met when writing JUnit test, also for some uncleared requirements.
* Delay the deadline of JUnit test to 21/4/24, re-arrange the timeline of the following week.
3. 21/4/23 - **3rd Group Discussion**:
* Discussed the work we have down.
* agree on the format, i.e. how to comments. 
* Distribute workload of Integration test, set a time for the deadline of each work and the next discussion.
4. 21/4/24 The second milestone - "Writing JUnit Test " was successfully closed on 21/4/24.

#### Writing Integration Test
##### 21/4/24 - 21/4/28

1. Writing Integration test.
2. Decided to use branch for effective work.
3. 21/4/26 - **4st Group Discussion**:
* Discussed the problem we faced when writing the Integration Test.
* Due to the estimate the deadline of the Integration test wrongly, we delay the deadline to 21/4/28, re-arrange the timeline of the following week.
4. 21/4/28 The third milestone - "Writing Integration Test" was successfully closed on 21/4/24.

#### Fixing and Improving Code
##### 21/4/26 - 21/4/29

1. From 21/4/26 - 21/4/28, we finished the code fixing and improving for the code we have already tested in BoCCategory and BoCTransaction.
2. 21/4/28 - **5st Group Discussion**:
* Discussed the problem we faced when fixing and improving the code.
3. 21/4/29 

#### Final Checking
##### 21/4/29

1. We review all the code we have write(including the JUnit test code, Integration test code and the source code we change), to find and fix some format problems or other simple mistakes.
2.  
-------------------------------------
### Team Strategy
A good team usually have their own team strategy to improve work efficiency and quality.

At the beginning, we choose to divided those tasks into small pieces and assign to individuals, and decided to held regular meeting to discuss the problems we meet. However, during the process, we found that it may caused some merge conflicts like when we pull our tests together. Thus, we decided to step up communication within the team and call for more use of GitLab. Also, we start to work as a REAL group ("although we have divided into two groups when writing JUnit test, at first we don't often discuss as a group"), e.g. when someone faced problems. then it will raise issues to GitLab for help, and we also have regular time for everyone to do their own work in the same room, so we could discuss immediately if any of us have problems. Also, we have tried to implement paired coding for effective work. In writing the Integration test for main method in BoCApp, Xingyan(Amanda) and Wangji(Eagle) has doing the paired coding, since the main method is quite difficult to test.

-------------------------------------
### Problems & Solutions
|Problems|Solutions|
|--------|---------|
|Test code could not run in local computer|This is because the test code was placed in the normal folder rather than a source folder.<br>Thus we have change the test code in the right source folder|
|The test under @Test is be ignored|Because of the importing of two different libraries that cause some conflicts, thus we remove the library that cause conflicts|
|Confused about how handle a series of input in testing private method|Use Stream<Arguments>|


-------------------------------------
### Test Plan 


### Conclusion
In this report, the whole working process has been shown. 
In the team management part, it tells the detailed workload distribution and the timeline of our working process, including the meeting we held, what decisions has been made during these process etc. This part also list some main problems we feced and the solutions we found. This could help us review what we have done through this whole process, what mistakes we have made, and which solutions we took, also to see where could be improve at the next time .
In the test plan part, which include the time, inputs, expected outcome, test outcome and result, also with the failure and what change has been made.

After finishing this coursework, we understand that it is not that easy to work with a team. In order to work as a team, each of us should listen and understand each other, and fight for the same goal, seek for better way to improve the work efficiency and quality.



