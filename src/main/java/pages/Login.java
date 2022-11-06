package pages;

import org.openqa.selenium.By;

import static commons.CommonAssertions.textAssertion;
import static commons.Functions.*;
import static utils.ProjectPropertiesUtil.getProperties;

public class Login {

    private By AppSignInOption = By.id("nav-link-accountList-nav-line-1");
    private By emailTextBox = By.id("ap_email");
    private By continueBtn = By.id("continue");
    private By alertMsg = By.className("a-list-item");


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
