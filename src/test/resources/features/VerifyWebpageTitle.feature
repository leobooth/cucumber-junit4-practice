Feature: Verify webpage title

  Scenario: Get title from webpage
#      Given I navigate to the following URL: https://the-internet.herokuapp.com/
      Given I navigate to the following URL
       When the webpage loads within 30 seconds
       Then the webpage title should be "The Internet"