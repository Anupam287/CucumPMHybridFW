Feature: Account Page Feature

Background:
Given The user is already logged into the application
|Username|Password|
|banerjee.anupamkol@gmail.com|Parents@#$12345|

@Accounts
Scenario: Account Page Title
Given The user is on the Account page
When The user gets the title of the Page
Then The title of the page should be "My account - My Store"

Scenario: Account section count
Given The user is on the Account page
Then The user gets the Account section
|Order history and details|
|My credit slips|
|My addresses|
|My personal information|
|My wishlists|
And The Account section count is 5 
