@tag

Feature: Login the application from Ecommerce website

Background:
Given 
I landed pn Ecommerce page


@tag1
Scenario Outline: Positive test to Login the application

Given:  Logged in with username <name> and password <password>
When: I add to product <productname> to cart
And:  Checkout <productname> and submit the order
Then: "Thankyou for the order." message is display on confirmationpage

Examples:
|name                 |password   |productname  |
|rahulshetty@gmail.com    |Iamking@000|ZARA COAT 3|