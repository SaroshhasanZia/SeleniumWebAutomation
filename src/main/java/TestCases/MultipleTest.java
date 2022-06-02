package TestCases;

import general.BaseTest;
import static general.functions.*;
import static java.lang.Thread.sleep;
import static object.Locators.*;
import static general.EnvGlobals.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class MultipleTest extends BaseTest {
    public static String name = "Sarosh";
    public static String lastName = "Hasan Zia";
    public static String CompanyName = "VD";
    public static String email = "sarosh@vd.com";
    public static String companySize = "101-500";
    public static String country = "Pakistan";
    public static String phoneNumber = "090078601";
    public static String hearAboutUs = "Testing QA demo ";
    public static String comments = " Testing comments ";



    @Test(description="")
    public static void multipleTestCases() throws InterruptedException {
        implicitWait();
        login(username,password);
        click(elementBy(menuButton));
        click(elementBy(about));
        hoverAndClick(contact,contactSales);
        sendKeys(elementBy(inputFirstName),name);
        sendKeys(elementBy(inputLastName),lastName);
        sendKeys(elementBy(inputCompanyName),CompanyName);
        sendKeys(elementBy(inputBusinessEmail),email);
        selectElement(companySizeDropdown,companySize);
        selectElement(countryDropdown,country);
        sendKeys(elementBy(inputPhoneNumber),phoneNumber);
        ScrollTo(scrollForInterest);
      sleep(3000);
        click(elementBy(mobileTestingCheck));
        sendKeys(elementBy(hearAboutUsTextBox),hearAboutUs);
        sendKeys(elementBy(commentTextBox),comments);
        click(elementBy(consentCheckBox));
        navigateBack();
        scrollDown();

        sleep(3000);
        //click(elementBy(facebookButton));



    }



}
