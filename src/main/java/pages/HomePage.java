package pages;

import org.openqa.selenium.By;

import static commons.CommonAssertions.*;
import static commons.Functions.*;
import static commons.Waits.implicitWait;
import static utils.ProjectPropertiesUtil.getProperties;

public class HomePage {

    private String navBar = "//a[@class='nav-a  ' and contains(text(), \"%s\")]";
    private String dealsCategory = "//div[@id='anonCarousel1']//li[@aria-posinset=\"%s\"]";
    private String categoryList = "//div[@class='Grid-module__gridDisplayGrid_2X7cDTY7pjoTwwvSRQbt9Y']/div[%s]";
    private String itemsList = "//div[@id='octopus-dlp-asin-stream']//li[%s]";
    private By quantityDropDown = By.id("quantity");
    private By addToCartBtn = By.xpath("//input[@id='add-to-cart-button']");
    private By cart = By.id("nav-cart");
    private By addedToCart = By.xpath("//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']//span");
    public float itemPrice;
    public String itemName;
    private By itemTitle = By.xpath("//span[@id='productTitle']");
    private By itemPricePath = By.xpath("//div[@id='corePrice_feature_div']//span//span[@class='a-offscreen']");
    private By itemTitleOnCart = By.xpath("//span[@class='a-list-item']/a//span//span//span[contains(@class,'a-truncate-cut')]");
    private By itemPriceOnCart = By.xpath("//span[contains(@class,'sc-product-price')]");
    private By SubTotalItemsInCart = By.id("sc-subtotal-label-activecart");
    private By totalItemsPrice = By.xpath("//span[@id='sc-subtotal-amount-activecart']//span");
    private By itemQunatityInCart = By.xpath("//span[@class='a-button a-button-dropdown quantity']//span[@class='a-dropdown-prompt']");


    public void browseWebsite() {
        browseUrl(getProperties("URL"));
        maximizeBrowser();
    }


    public void navigationBarSelection(String value) {
        String path = getXpath(navBar, value);
        By element = By.xpath(path);
        click(element);
    }

    public void clickOnDealsCategory(String value) {
        String path = getXpath(dealsCategory, value);
        By element = By.xpath(path);
        click(element);

    }


    public void selectCategory(String value) {
        String path = getXpath(categoryList, value);
        By element = By.xpath(path);
        click(element);
    }

    public void selectItem(String value) {

        //Item seletion by xpath
        String path = getXpath(itemsList, value);
        By element = By.xpath(path);
        click(element);
    }

    public void getItemTitle() {

        itemName = elementBy(itemTitle).getText();

    }

    public void getItemPrice() {
        String item = removeNonNumericCharacters(getTextFromElementByInnerText(itemPricePath));
        itemPrice = Float.parseFloat(item);
    }


    public void selectQuantity(String quantity) {
        selectElement(quantityDropDown, quantity);
    }

    public void clickOnAddToCartBtn() {
        click(addToCartBtn);
    }

    public void clickOnCart() {
        click(cart);
    }

    public void verifyItemIsAddedSuccessfully(String text) {
        textAssertion(addedToCart, text);
    }

    public void verifyItemName() {
        textAssertion(itemTitleOnCart, itemName);

    }

    public void verifyItemPrice() {
        floatValueAssertion(itemPriceOnCart, itemPrice);
    }

    public void verifyTotalQuantity() {

        int quantity = Integer.parseInt(removeNonNumericCharacters(getTextFromElement(itemQunatityInCart)));

        intValueAssertion(SubTotalItemsInCart, quantity);

    }

    public void verifyTotalAmount() {

        int quantity = Integer.parseInt(removeNonNumericCharacters(getTextFromElement(itemQunatityInCart)));
        float total = quantity * itemPrice;
        floatValueAssertion(totalItemsPrice, total);
    }


}
