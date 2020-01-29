Feature: facebook
Scenario Outline: <Testcase>
Given launch browser and open facebook
When enterusers "firstname" and "lastname"
Then click submit button 
Examples:
|Testcase|
|UC_9_10_UeberweisungLimit|
