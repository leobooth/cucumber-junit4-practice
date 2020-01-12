@BeforeVerifyBasicAuthLogin
@AfterVerifyBasicAuthLogin
@RunMe
Feature: verify login using basic authentication

  Scenario: attempt login with invalid username and password
     When I authenticate using Basic Auth with invalid username and invalid password
     Then the Basic Auth success page should not be visible

  Scenario: attempt login with valid username and password
    When I authenticate using Basic Auth with valid username and valid password
    Then the Basic Auth success page should be visible