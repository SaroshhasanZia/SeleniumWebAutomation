package object;

import org.openqa.selenium.By;
import org.testng.Assert;

import static general.Functions.*;
import static general.Functions.click;
import static java.lang.Thread.sleep;



public class MultipleTestCases {

    public static By about = By.id("about_sidebar_link");
    public static By contact = By.xpath("//div[@class='nav-menu']//div[@data-hover-content='Contact']//a[@data-ta='click']");
    public static By contactSales = By.xpath("//ul[@class='nav-menu-list']//li[@class='nav-menu-list-item']//span[text()='Contact Sales']");
    public static By inputFirstName = By.xpath("//input[@id='FirstName']");
    public static By inputLastName = By.xpath("//input[@id='LastName']");
    public static By inputCompanyName = By.xpath("//input[@id='Company']");
    public static By inputBusinessEmail = By.xpath("//input[@id='Email']");
    public static By companySizeDropdown = By.xpath("//select[@id=\"Company_Size__c\"]");
    public static By countryDropdown = By.xpath("//select[@id=\"Country\"]");
    public static By inputPhoneNumber = By.xpath("//input[@id=\"Phone\"]");
    public static By scrollForInterest = By.xpath("//label[@for=\"productInterest\"]");
    public static By mobileTestingCheck = By.xpath("//div[contains(@class,\"mktoLogicalField mktoCheckboxList\")]//input[6]\n");
    public static By hearAboutUsTextBox = By.xpath("//textarea[@id=\"How_did_you_hear_about_Sauce_Labs__c\"]");
    public static By commentTextBox = By.xpath("//textarea[@id=\"Sales_Contact_Comments__c\"]");
    public static By consentCheckBox = By.xpath("//input[@name=\"sauceLabsContactConsent\"]");
    public static By facebookButton = By.xpath("//i[@class=\"svg svg-facebook\"]");
    public static By usernameCss = By.cssSelector("#user-name");
    public static By passwordCss = By.cssSelector("#password");
    public static By menuButton = By.id("react-burger-menu-btn");

    public static By loginbtnCss = By.cssSelector("#login-button");
    static By error = By.xpath("//h3[@data-test=\"error\"]");
    static By ProductpageCss = By.xpath("//span[text()=\"Products\"]");
    public static By menu_button = By.xpath("//button[@id=\"react-burger-menu-btn\"]");
    public static By logoutButton= By.xpath("//a[@id=\"logout_sidebar_link\"]");
    public static String name = "Sarosh";
    public static String lastName = "Hasan Zia";
    public static String CompanyName = "VD";
    public static String email = "sarosh@vd.com";
    public static String companySize = "101-500";
    public static String country = "Pakistan";
    public static String phoneNumber = "090078601";
    public static String hearAboutUs = "Testing QA demo ";
    public static String comments = " Testing comments ";
    public static By loc = By.xpath("//div[@class=\"navFooterLinkCol navAccessibility\"]//div[text()=\"Get to Know Us\"]");
    public static By facebookPage = By.xpath("//h1[text()=\"Sauce Labs\"]");




    public static void logout(){
        click(menu_button);
        click(logoutButton);
    }

    public static void login(String username,String password ){
        clear(usernameCss);

        sendKeys((usernameCss),username);
        clear(passwordCss);
        sendKeys((passwordCss),password);
        click((loginbtnCss));

    }

    public static void contactSales(){
        click((menuButton));
        click((about));
        hoverAndClick(contact,contactSales);
    }


    public static void formFill() throws InterruptedException {
        sendKeys((inputFirstName),name);
        sendKeys((inputLastName),lastName);
        sendKeys((inputCompanyName),CompanyName);
        sendKeys((inputBusinessEmail),email);
        selectElement(companySizeDropdown,companySize);
        selectElement(countryDropdown,country);
        sendKeys((inputPhoneNumber),phoneNumber);
        ScrollTo(scrollForInterest);
//      sleep(3000);
        //  explicitWait(mobileTestingCheck);
        scrollAndClick((mobileTestingCheck));
        sendKeys((hearAboutUsTextBox),hearAboutUs);
        sendKeys((commentTextBox),comments);
        scrollAndClick(consentCheckBox);
        sleep(5000);
    }

    public static void clickFacebookButton() throws InterruptedException {
        navigateBack();
        scrollAndClick(facebookButton);
        sleep(5000);
    }

    public static void facebookAssertion(){
        String facebookurl = driver.getCurrentUrl();
        String expect = "https://www.facebook.com/saucelabs";
        Assert.assertEquals(facebookurl,expect);
    }
}
