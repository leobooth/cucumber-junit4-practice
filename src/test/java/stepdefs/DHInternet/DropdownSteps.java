package stepdefs.DHInternet;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.DHInternet.DHInternetPO;
import testEnvironment.BrowserSettings;

public class DropdownSteps {

  private WebDriver webDriver;
  private DHInternetPO dhInternetPO;

  @Before("@BeforeVerifyDropdown")
  public void beforeVerifyDHInternet() {
    webDriver = BrowserSettings.setDriver("CHROME");
    BasePage.setWebDriver(webDriver);
    dhInternetPO = new DHInternetPO();
  }

  @After("@AfterVerifyDropdown")
  public void closeBrowser() {
    webDriver.quit();
  }

}
