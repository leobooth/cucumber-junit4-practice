package pages.DHInternet;

import org.openqa.selenium.InvalidArgumentException;
import pages.BasePage;

public class BasicAuthPopupPage extends BasePage {

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
}
