package pages;

import org.openqa.selenium.By;

import static commons.CommonAssertions.textAssertion;
import static utils.BrowserUtils.*;
import static utils.ProjectPropertiesUtil.getProperties;

public class IntroScreen {

    private final By accountListNav = By.id("nav-link-accountList");
    private final String navListItems = "//a[@class='nav-link nav-item']//span[contains(text(),'%s')]";
    private final By signInPage = By.xpath("//div[@class='a-box']//h1");
    private final By listsPage = By.xpath("//div[@class='a-section al-intro-banner a-spacing-none']//span[contains(@class,'al-intro-banner-header')]");


    public void browseWebsite() {
        browseUrl(getProperties("URL"));
        maximizeBrowser();
    }

    public void hoverOnAccountAndListAndSelect(String item) {
        String path = getXpath(navListItems, item);
        By element = By.xpath(path);
        hoverAndClick(accountListNav, element);
    }

    public void verifyUserIsNavigatedToSignInPage() {
        textAssertion(signInPage, "Sign in");
    }

    public void backNavigation() {
        navigateBack();
    }

    public void verifyUserIsNavigatedToListPage() {
        textAssertion(listsPage, "Lists");
    }


}
