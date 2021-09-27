Feature: Login Page 

Scenario: Login Page Tilte
Given The user is on the Login Page
When The user gets the title of the Page
Then The title of the page should be "Login - My Store"

Scenario: Forgot Password Link
Given The user is on the Login Page
Then The Forgot Password link should be displayed
When The user clicks on the Forgot Password link 
And The user gets the title of the Page
Then The title of the page should be "Forgot your password - My Store"

Scenario: Login with correct credentials
Given The user is on the Login Page
When The user enters username "banerjee.anupamkol@gmail.com"
And  The user enters password "Parents@#$12345"
And The user clicks on Sign In button
And The user gets the title of the Page
Then The title of the page should be "My account - My Store" 