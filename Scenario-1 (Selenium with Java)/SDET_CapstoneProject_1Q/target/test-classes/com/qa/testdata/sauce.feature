Feature: Login to saucedemo.com

Scenario: Verify the title of the Page on successful login 
Given I am on the saucedemo login page 
When I enter my username and password 
And I click on the Submit button
Then I should see the title of the page as "Sauce Demo"

Scenario: Verify the title of the Page on unsuccessful login
 Given I am on the saucedemo login page
 When I enter invalid username and password
 And I click on the Submit button 
 Then I should see an error message