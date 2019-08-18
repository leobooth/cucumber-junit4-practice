Feature: verify login using basic authentication

  Scenario: login using basic authentication
    Given I navigate to Dave Haeffner's website "The Internet"
     When I click the link "Basic Auth" on The Internet homepage
     #TODO: handle the browser popup
