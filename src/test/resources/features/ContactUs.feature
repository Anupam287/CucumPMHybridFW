Feature: ContactUs feature

Scenario Outline: Testing the ContactUs feature with different set of data
Given The user navigates to the ContactUs page
When The user enters the required data from the Sheetname "<Sheetname>" and Rownumber <Rownumber>
And The user clicks on the send button
Then The user is shown a succesful message "Your message has been successfully sent to our team."

Examples:
|Sheetname|Rownumber|
|ContactUs|0|
|ContactUs|1|

