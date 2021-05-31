@tag
Feature: Checking the Overall working of Yoga app in different scenarios
  

  @tag1
  Scenario: checking the overall Yoga application
    Given open the chrome browser and application
		When I check the links
    Then Close the chrome browser
    
   @tag2
  Scenario: checking the overall Yoga application
    Given open the firefox browser and application
		When I check the links in firefox browser
    Then Close the firefox browser
    
  @tag3
  Scenario: checking the overall Yoga application
    Given open the chrome browser and application
		Then Check the message received
    Then Close the chrome browser