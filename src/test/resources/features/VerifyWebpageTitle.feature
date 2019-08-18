Feature: Verify webpage title

  Scenario: Get title from webpage
      Given I navigate to Dave Haeffner's website "The Internet"
        And the webpage loads within 30 seconds
       Then the webpage title should be "The Internet"