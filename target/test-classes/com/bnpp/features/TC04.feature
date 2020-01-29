Feature: create account on fb
@testcase
Scenario: user_details
Given launch broser and open fb
When fb page open
Then Enter "firstname" in "FNfield"
Then Enterl "lastname" in "LNfield"
Then Enterm "mobno" in "contactfield"
Then click "day" and "selectDate"
Then clickmm "month" and "selectMonth"
Then clickyy "year" and "selectYear"
Then select "male"
Then click "signUp"

@testcase1
Scenario: user_details
Given launch broser and open fb
When fb page open
Then Enter "firstname" in "FNfield"
Then Enterl "lastname" in "LNfield"
Then Enterm "mobno" in "contactfield"
Then click "day" and "selectDate"
Then clickmm "month" and "selectMonth"
Then clickyy "year" and "selectYear"
Then select "male"




	