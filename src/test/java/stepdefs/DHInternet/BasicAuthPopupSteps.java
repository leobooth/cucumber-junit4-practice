package stepdefs.DHInternet;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import testEnvironment.BrowserSettings;

public class BasicAuthPopupSteps {

    private WebDriver webDriver;
    private BasicAuthPopupSteps BasicAuthPopupSteps;

    @Before("@BeforeVerifyBasicAuthPopup")
    public void beforeVerifyDHInternet() {
        webDriver = BrowserSettings.setDriver("CHROME");
        BasePage.setWebDriver(webDriver);
        BasicAuthPopupSteps = new BasicAuthPopupSteps();
    }
}
