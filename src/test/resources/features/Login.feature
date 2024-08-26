Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User has navigates to login page
When User enters valid email address <username> into the emmail field
And User enters valid password <password> into the password feild
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username						|password	|
|dhandd1@gmail.com	|12345		|
|dhandd2@gmail.com	|12345		|
|dhandd3@gmail.com	|12345		|

Scenario: Login with invalid credentials
Given User has navigates to login page
When User enters invalid email address into the email field
And User enters invalid password "DD12345678" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User has navigates to login page
When User enters valid email address "dhoredhananjay5@gmail.com" into the emmail field
And User enters invalid password "DD12345678" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User has navigates to login page
When User enters invalid email address into the email field
And User enters valid password "DD12345" into the password feild
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User has navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch 

