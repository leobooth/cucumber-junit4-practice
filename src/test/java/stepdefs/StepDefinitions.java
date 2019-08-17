package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {
    WebDriver driver = null;

    @Before
    public void setupChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Google Drive\\SeleniumPractice\\Projects\\cucumber-junit4-practice\\.idea\\browserDrivers\\ChromeDriver\\v76.0.3809.68\\chromedriver_win32\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
    }

    @After
    public void closeChromeBrowser() {
        driver.quit();
    }

    @Given("^I navigate to the following URL: (.*)$")
    public void navigate_to_URL(String url) {
        driver.navigate().to(url);
//        driver.manage().window().maximize();
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
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(isDoneLoading);
        } catch (Throwable error) {
            Assert.fail("The webpage failed to load within " + timeoutInSeconds + " seconds.");
        }
    }

    @Then("^the webpage title should be \"(.*)\"$")
    public void verify_webpage_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
