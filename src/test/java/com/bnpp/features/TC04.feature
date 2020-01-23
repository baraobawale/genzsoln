Feature: create account on fb
Scenario: user_details
Given launch broser and open fb
When fb page open
Then Enter "firstname" in "FNfield"
Then Enterl "lastname" in "LNfield"
Then Enterm "mobno" in "contactfield"
