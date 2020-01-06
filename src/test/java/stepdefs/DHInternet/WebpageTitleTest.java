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
import pages.DHInternet;
import testEnvironment.BrowserSettings;

public class WebpageTitleTest {

    private WebDriver webDriver;
    private DHInternet DHInternet;

    @Before("@BeforeVerifyWebpageTitle")
    public void beforeVerifyWebpageTitle() {
        webDriver = BrowserSettings.setDriver("CHROME");
        BasePage.setWebDriver(webDriver);
        DHInternet = new DHInternet();
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }

    @Given("^I navigate to Dave Haeffner's website \"The Internet\"$")
    public void navigate_to_Dave_Haeffner_Internet() {
        DHInternet.go();
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
    public void verify_webpage_title(String expectedTitle) {
        String actualTitle = webDriver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("^I click the link \"(.*)\" on The Internet homepage$")
    public void click_the_internet_homepage_link(String linkText) {
        boolean isSuccessful = DHInternet.clickTheInternetLink(linkText);
        Assume.assumeTrue("Clicked link " + linkText, isSuccessful);
    }

    @Then("^I should see an authentication popup$")
    public void verify_basic_auth_popup_exists() {
        //TODO: handle the browser popup
    }
}
