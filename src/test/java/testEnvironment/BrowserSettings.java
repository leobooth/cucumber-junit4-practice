package testEnvironment;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSettings {
    public static WebDriver WEBDRIVER;

    public static WebDriver setDriver(String browserName) {
        switch (browserName.toUpperCase()) {
            case "CHROME": {
                String chromeDriverPath = "D:\\SideProjects\\SeleniumPractice\\Projects\\cucumber-junit4-practice\\.idea\\browserDrivers\\ChromeDriver\\v79.0.3945.36\\chromedriver_win32\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                return new ChromeDriver();
            }
            default: {
                throw new InvalidArgumentException("Invalid browser name provided to getDriver()");
            }
        }
    }
}