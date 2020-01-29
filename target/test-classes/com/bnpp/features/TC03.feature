Feature: order mobile phone
Scenario Outline: Testcase 02
Given launch browser in chrome
When user enters mobile <"name"> in "samsung" field
Then user Enters name of mobilephone 

Examples:
|name|
|samsung|
|mi phone|
|nokia|