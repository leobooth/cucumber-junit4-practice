package stepdefs.DHInternet;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.DHInternet.BasicAuthLoginPO;
import testEnvironment.BrowserSettings;

public class BasicAuthLoginSteps {

    private WebDriver webDriver;
    private BasicAuthLoginPO basicAuthLoginPO;

    @Before("@BeforeVerifyBasicAuthLogin")
    public void beforeVerifyBasicAuthLogin() {
        webDriver = BrowserSettings.setDriver("CHROME");
        BasePage.setWebDriver(webDriver);
        basicAuthLoginPO = new BasicAuthLoginPO();
    }

    @After("@AfterVerifyBasicAuthLogin")
    public void closeBrowser() {
        webDriver.quit();
    }

    @When("^I authenticate using Basic Auth with (valid|invalid) username and (valid|invalid) password$")
    public void navigateToDaveHaeffnerInternetUsingBasicAuth(String validOrInvalidUsername, String validOrInvalidPassword) {
        String popupURL = basicAuthLoginPO.getURL();
        String username = "";
        String password = "";

        if(validOrInvalidUsername.equalsIgnoreCase("valid")) {
            username = "admin";
        } else {
            username = "invalidUsername";
        }

        if(validOrInvalidPassword.equalsIgnoreCase("valid")) {
            password = "admin";
        } else {
            password = "invalidPassword";
        }

        basicAuthLoginPO.go(basicAuthLoginPO.getBasicAuthURL(
                popupURL, username, password));
    }

    @Then("^I should see an authentication popup$")
    public void verifyBasicAuthPopupExists() {
        //TODO: handle the browser popup
    }

    @Then("the Basic Auth success page (should|should not) be visible$")
    public void verifyBasicAuthSuccessPageIsOrIsNotVisible(String shouldOrShouldNot) {
        boolean isBasicAuthHeaderVisible = basicAuthLoginPO.isBasicAuthHeaderVisible(5);
        boolean isBasicAuthSuccessMessageVisible = basicAuthLoginPO.isBasicAuthSuccessMessageVisible(5);
        if (shouldOrShouldNot.equalsIgnoreCase("should")) {
            Assert.assertTrue(isBasicAuthHeaderVisible && isBasicAuthSuccessMessageVisible);
        } else {
            Assert.assertFalse(isBasicAuthHeaderVisible && isBasicAuthSuccessMessageVisible);
        }
    }
}
