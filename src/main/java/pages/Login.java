package pages;

import org.openqa.selenium.By;

import static commons.CommonAssertions.textAssertion;
import static utils.BrowserUtils.*;
import static utils.ProjectPropertiesUtil.getProperties;

public class Login {

    private final By AppSignInOption = By.id("nav-link-accountList-nav-line-1");
    private final By emailTextBox = By.id("ap_email");
    private final By continueBtn = By.id("continue");
    private final By alertMsg = By.className("a-list-item");


    public void browseWebsite() {
        browseUrl(getProperties("URL"));
        maximizeBrowser();
    }
    public void clickAppSignInOption() {
        click(AppSignInOption);
    }
    public void enterEmail(String email) {
        sendKeys(emailTextBox, email);
    }
    public void clickContinueBtn() {
        click(continueBtn);
    }
    public void VerifyUsingUnregisteredEmail(String text) {
        textAssertion(alertMsg, text);
    }
}
