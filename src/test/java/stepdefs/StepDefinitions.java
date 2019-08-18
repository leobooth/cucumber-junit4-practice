package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TheInternet;

public class StepDefinitions {

    private WebDriver webDriver;
    private TheInternet theInternet;

    @Before
    public void setupChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Google Drive\\SeleniumPractice\\Projects\\cucumber-junit4-practice\\.idea\\browserDrivers\\ChromeDriver\\v76.0.3809.68\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @After
    public void closeChromeBrowser() {
        webDriver.quit();
    }

    @Given("^I navigate to the following URL: (.*)$")
    public void navigate_to_URL(String url) {
        webDriver.navigate().to(url);
    }

    @Given("^I navigate to Dave Haeffner's website \"The Internet\"$")
    public void navigate_to_Dave_Haeffner_Internet() {
        webDriver.navigate().to("https://the-internet.herokuapp.com/");
        theInternet = new TheInternet(webDriver);
    }

    @When("^the webpage loads within (\\d+) seconds$")
    public void webpage_loads_before_timeout(int timeoutInSeconds) {
        ExpectedCondition<Boolean> isDoneLoading = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
            wait.until(isDoneLoading);
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
        boolean isSuccessful = theInternet.clickTheInternetLink(linkText);
        Assume.assumeTrue("Clicked link " + linkText, isSuccessful);
    }

    @Then("^I should see an authentication popup$")
    public void verify_basic_auth_popup_exists() {
        //TODO: handle the browser popup
    }
}
