package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver webDriver;

    public static void setWebDriver(WebDriver webDriver) {
        BasePage.webDriver = webDriver;
    }
}