package object;

import org.openqa.selenium.By;

public class Locators {

    public static By cartQuantity = By.xpath("//div[@class='cart_item']//div[@class='cart_quantity']");
    public static By allItemsPriceCss = By.cssSelector("div.page_wrapper div.inventory_container div.inventory_list div.inventory_item div.inventory_item_description div.pricebar > div.inventory_item_price");
    public static By usernameCss = By.cssSelector("#user-name");
    public static By passwordCss = By.cssSelector("#password");

    public static By loginbtnCss = By.cssSelector("#login-button");
    public static By priceFilterBtnCss = By.cssSelector("div.page_wrapper div.header_container:nth-child(1) div.header_secondary_container div.right_component span.select_container > select.product_sort_container");
    public static By allItemsPrice = By.xpath("//div[@class='pricebar']//div[@class='inventory_item_price']");
    public static By cartPage = By.xpath("//div[@class='shopping_cart_container']");
    public static By cartItemsPrice = By.xpath("//div[@class='inventory_item_price']");

    public static By menuButton = By.id("react-burger-menu-btn");
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
    public static By mobileTestingCheck = By.xpath("//label[@for=\"mktoCheckbox_30797_1\"]");
    public static By hearAboutUsTextBox = By.xpath("//textarea[@id=\"How_did_you_hear_about_Sauce_Labs__c\"]");
    public static By commentTextBox = By.xpath("//textarea[@id=\"Sales_Contact_Comments__c\"]");
    public static By consentCheckBox = By.xpath("//input[@name=\"sauceLabsContactConsent\"]");
    public static By facebookButton = By.xpath("//a[@href=\"https://www.facebook.com/saucelabs\"]");



}
