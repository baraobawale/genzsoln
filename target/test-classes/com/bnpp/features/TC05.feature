Feature: order mobile in flipkart add to cart

@scenario1
Scenario: place_order_verify_into_cart
When user launches browser and open Flipkart
Then user close login "Pop-ups"
Then Enter "mobilename" in "Search_field" and "PressEnter" seach button
Then click on "MobileName" and verify "namemobile" name
Then click on "AddtoCart"
Then verify "mobilename" is added into cart 

@scenario2
Scenario: place_order_verify_into_cart
When user launches browser and open Flipkart
Then user close login "Pop-ups"
Then Enter "mobilename" in "Search_field" and "PressEnter" seach button
Then click on "MobileName" and verify "namemobile" name
Then click on "AddtoCart"
Then verify "mobilename" is added into cart 

