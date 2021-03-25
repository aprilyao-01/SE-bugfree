## Scenario of Bank of China 01
Title|What categories did son spend his money on?
Overview|*People:* Jack Yang, 39 years old, father of three children
|*Activity:* View the summary for his son's individual account
|*Context:* At home
|*Technology:* iPone
Initial assumption| User information has been recorded in the app, and this user is a multi account user
Rationale| An illustration of the Multi-account-users view the summary by categories and by types
Detail|1. He opens the app and login
｜2. The app displayed details of _his own account_ with the head bar _"My-account"_
|3. He slides to the interface _"Multi-account"_
|4. The app required him to enter a specific password to prove he was a manager
|5. After verified he chose his son's account
|6. He chose the function _"See Total Bills"_, and chose _"By Categories"_
｜7. The app shows a _pie chart_ to show the total expenses of the account. In the middle of the pie chart is the _total_ amount of expenses. _Different colors_ represent different categories of expenses, with a line next to each color indicating that category of expenses
|8. He clicks the button with the underline _"See by types"_
|9. The app ask him to input a type name, and he input "game"
|10. Based on the input, the app searches through the categories and the notes added at the time of the bookkeeping, and presents a list that records the date, category, and corresponding amount spent
|11. The father exit the app
What can go wrong|1. Sign-account user do not the the "Multi-account" head bar, unless the manually add account or link to existing accounts
｜2. The user is not the manager of the multi account, so they only see who's account is in the group, but cannot see the details
|3. If user input the wrong manager password, the app will give a warning and wait 10 minutes after three consecutive mistakes before trying again
｜4. If user input types that cannot be searched, the app will display a empty list with prompt "nothing have been found in this type, try another"
System state on completion| The user has logged in the app, there is no record of any new or modified, and the system remains unchanged