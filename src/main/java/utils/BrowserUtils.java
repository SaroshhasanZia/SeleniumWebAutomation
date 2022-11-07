package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utils.WaitUtils.waitUntilElementIsClickable;
import static driver.DriverManager.getDriver;


public class BrowserUtils {


    public static void browseUrl(String url) {
        getDriver().get(url);
    }


    public static String getXpath(String xpath, String value) {
        return String.format(xpath, value);

    }

    public static void maximizeBrowser() {
        getDriver().manage().window().maximize();
    }

    public static WebElement elementBy(By value) {
        return getDriver().findElement(value);
    }


    public static void click(By element) {

        try {
            waitUntilElementIsClickable(element);
            {
                elementBy(element).click();

            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("element not located: " + element);

        }

    }


    public static void sendKeys(By element, String text) {
        try {
            waitUntilElementIsClickable(element);
            {
                elementBy(element).sendKeys(text);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void selectElement(By locator, String value) {

        try {
            waitUntilElementIsClickable(locator);
            {
                Select items = new Select(elementBy(locator));
                items.selectByValue(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("element not located");
        }


    }


    public static void hoverAndClick(By locatorOne, By locatortwo) {
        Actions actions = new Actions(getDriver());
        WebElement menu = getDriver().findElement(locatorOne);
        actions.moveToElement(menu);

        WebElement subMenu = getDriver().findElement(locatortwo);
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }


    public static void navigateBack() {

        getDriver().navigate().back();
    }


    public static String removeNonNumericCharacters(String value) {
        return value.replaceAll("[^\\d.]", "");
    }

    public static String getTextFromElement(By by) {

        return elementBy(by).getText();
    }

    public static String getTextFromElementByInnerText(By by) {
        return elementBy(by).getAttribute("innerText");
    }

}


