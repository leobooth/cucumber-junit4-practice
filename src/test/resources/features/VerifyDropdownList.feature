@RunMe
Feature: verify dropdown list

  Scenario: select an option from a dropdown list
    Given I navigate to Dave Haeffner's website "The Internet"
    When I click the link "Dropdown" on The Internet homepage
     #TODO: handle the browser popup