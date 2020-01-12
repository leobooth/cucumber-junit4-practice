package pages.DHInternet;

import org.openqa.selenium.InvalidArgumentException;
import pages.BasePage;

public class BasicAuthLoginPO extends BasePage {

    String BASIC_AUTH_HEADER_XPATH = ".//*[.='Basic Auth']";
    String BASIC_AUTH_SUCCESS_MESSAGE_XPATH = ".//*[contains(text(),'Congratulations!')]";

    public String getURL() {
        return "https://the-internet.herokuapp.com/basic_auth";
    }

    public String getBasicAuthURL(String displayedURL, String username, String password) {
        boolean isHttps = displayedURL.contains("https://");
        boolean isHttp = displayedURL.contains("http://");
        String basicAuthUrl = "";

        if(isHttp || isHttps) {
            if(isHttp) {
                basicAuthUrl = displayedURL.replace("http://",
                        "http://" + username + ":" + password + "@");
            } else {
                basicAuthUrl = displayedURL.replace("https://",
                        "https://" + username + ":" + password + "@");
            }
        } else {
            throw new InvalidArgumentException("The displayedURL argument does not contain http:// or https://");
        }

        return basicAuthUrl;
    }

    public boolean isBasicAuthHeaderVisible(int waitTimeInSeconds) {
        return isWebElementAtXPathVisible(BASIC_AUTH_HEADER_XPATH, waitTimeInSeconds);
    }

    public boolean isBasicAuthSuccessMessageVisible(int waitTimeInSeconds) {
        return isWebElementAtXPathVisible(BASIC_AUTH_SUCCESS_MESSAGE_XPATH, waitTimeInSeconds);
    }
}
