package pages.DHInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class DHInternetPO extends BasePage {

    private String THE_INTERNET_EXAMPLE_LINK_TEMPLATE = ".//h2[.='Available Examples']//following-sibling::ul/li/a[contains(text(),'LINK_TEXT')]";

    public String getURL() {
        return "https://the-internet.herokuapp.com/";
    }

    public boolean clickTheInternetLink(String linkText) {
        String xpath = THE_INTERNET_EXAMPLE_LINK_TEMPLATE.replace("LINK_TEXT", linkText);
        WebElement webElement = webDriver.findElement(By.xpath(xpath));
        boolean isClickSuccesful = false;

        try {
            webElement.click();
            isClickSuccesful = true;
        } catch (Exception e) {
            System.out.println(e);
            isClickSuccesful = false;
        }

        return isClickSuccesful;
    }
}
