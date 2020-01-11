package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver webDriver;

    public static void setWebDriver(WebDriver webDriver) {
        BasePage.webDriver = webDriver;
    }

    public void go(String url) {
        webDriver.navigate().to(url);
    }
}