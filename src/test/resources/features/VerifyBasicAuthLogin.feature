@BeforeVerifyDHInternet
@RunMe
Feature: verify login using basic authentication

  Scenario: cancel basic authentication
    Given I navigate to Dave Haeffner's website "The Internet"
      And I click the link "Basic Auth" on The Internet homepage
     #TODO: handle the browser popup
     When I click the Cancel button in the Basic Auth popup
#     Then the Basic Auth popup should not be visible

