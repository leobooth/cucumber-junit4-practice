package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver webDriver;

    public static void setWebDriver(WebDriver webDriver) {
        BasePage.webDriver = webDriver;
    }

    public void go(String url) {
        webDriver.navigate().to(url);
    }

    public boolean isWebElementAtXPathVisible(String xpath, int waitTimeInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, waitTimeInSeconds);
        try {
            WebElement visibleWebElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            if(visibleWebElement != null){
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException | TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}