package stepdefs.DHInternet;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.DHInternet.DHInternetPage;
import testEnvironment.BrowserSettings;

public class DHInternetSteps {

    private WebDriver webDriver;
    private DHInternetPage dHInternet;

    @Before("@BeforeVerifyDHInternet")
    public void beforeVerifyDHInternet() {
        webDriver = BrowserSettings.setDriver("CHROME");
        BasePage.setWebDriver(webDriver);
        dHInternet = new DHInternetPage();
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }

    @Given("^I navigate to Dave Haeffner's website \"The Internet\"$")
    public void navigateToDaveHaeffnerInternet() {
        dHInternet.go(dHInternet.getURL());
    }

    @When("^the webpage loads within (\\d+) seconds$")
    public void webpage_loads_before_timeout(int timeoutInSeconds) {
        ExpectedCondition<Boolean> isDoneLoading = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        try {
            WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
            wait.until(isDoneLoading);
            // sleep is used to allow humans to see the page
            Thread.sleep(1000);
        } catch (Throwable error) {
            Assert.fail("The webpage failed to load within " + timeoutInSeconds + " seconds.");
        }
    }

    @Then("^the webpage title should be \"(.*)\"$")
    public void verifyWebpageTitle(String expectedTitle) {
        String actualTitle = webDriver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("^I click the link \"(.*)\" on The Internet homepage$")
    public void clickTheInternetHomepageLink(String linkText) {
        boolean isSuccessful = dHInternet.clickTheInternetLink(linkText);
        Assume.assumeTrue("Clicked link " + linkText, isSuccessful);
    }

    @Then("^I should see an authentication popup$")
    public void verifyBasicAuthPopupExists() {
        //TODO: handle the browser popup
    }
}
