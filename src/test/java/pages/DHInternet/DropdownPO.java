package pages.DHInternet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DropdownPO extends BasePage {

  @FindBy(xpath = ".//select[@id='dropdown']")
  WebElement DROPDOWN;


}
