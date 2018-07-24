Feature: Successfull Login
Scenario: User gets successfull login  by entering correct credentials
         Given Login page Url
         When User enters valid Creddentials
         Then User gets Login
   
Scenario: login with invalid credentials
Given Login page Url
When i enter invalid credentials
Then Error message should be displayed     