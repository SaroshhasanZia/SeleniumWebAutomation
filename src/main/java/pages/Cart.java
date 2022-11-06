package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static config.DriverManager.DriverManager.getDriver;
import static general.CommonAssertions.isSortedFromHightoLow;
import static general.Functions.*;



public class Cart {


    public static By cartQuantity = By.xpath("//div[@class='cart_item']//div[@class='cart_quantity']");
    public static By allItemsPriceCss = By.cssSelector("div.page_wrapper div.inventory_container div.inventory_list div.inventory_item div.inventory_item_description div.pricebar > div.inventory_item_price");
    public static By usernameCss = By.cssSelector("#user-name");
    public static By passwordCss = By.cssSelector("#password");

    public static By loginbtnCss = By.cssSelector("#login-button");
    static By error = By.xpath("//h3[@data-test=\"error\"]");
    static By ProductpageCss = By.xpath("//span[text()=\"Products\"]");
    public static By menu_button = By.xpath("//button[@id=\"react-burger-menu-btn\"]");
    public static By logoutButton= By.xpath("//a[@id=\"logout_sidebar_link\"]");
    public static By priceFilterBtnCss = By.cssSelector("div.page_wrapper div.header_container:nth-child(1) div.header_secondary_container div.right_component span.select_container > select.product_sort_container");
    public static By allItemsPrice = By.xpath("//div[@class='pricebar']//div[@class='inventory_item_price']");
    public static By cartPage = By.xpath("//div[@class='shopping_cart_container']");
    public static By cartItemsPrice = By.xpath("//div[@class='inventory_item_price']");




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

    public static void selectProductLowToHigh(){
        click(priceFilterBtnCss);
        selectElement(priceFilterBtnCss, "lohi");
    }

    public static void itemsOrderAssertion(){
        Assert.assertEquals(true,isSortedFromHightoLow(itemsPrice(allItemsPriceCss)));

    }
    public static int numberOfItems(By Locator){
        List<WebElement> elements = getDriver().findElements(Locator);
        int counter =0;
        for(WebElement items : elements){

            counter++;
        }
        return counter;

    }
    public static float[] itemsPrice(By locator) {
        List<WebElement> elements = getDriver().findElements(locator);
        int size = elements.size();

        float [] a = new float[size];
        int counter = 0;
        for(WebElement i : elements){
            a[counter]=Float.parseFloat(i.getText().replace("$",""));


            counter++;
        }
        return a;

    }

    public static List<Float> addToCart(By locator, int position){


        int index = itemsPrice(locator).length;
        float price=0;
        List<Float> a = new ArrayList<>();

        for (int i=1;i<=index;i++) {

            String pathPrice;

            if (position == i) {
                By path = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[" + i + "]/div[2]/div[2]/button[1]") ;
                pathPrice = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div["+i+"]/div[2]/div[2]/div[1]";
                price = Float.parseFloat(elementByXpath(pathPrice).getText().replace("$",""));
                a.add(price);

                click((path));
                break;


            }

            else {System.out.println("position is out of index");}

        }

//        return price;
        return a;
    }


    public static void addItemsToCart(){
       addToCart(allItemsPriceCss,1);
       addToCart(allItemsPriceCss,2);
    }

    public static void clickOnCart(){
        click(cartPage);
    }
    public static List<Float> priceItems(By Locator){
        List<WebElement> elements = getDriver().findElements(Locator);
        List<Float> a = new ArrayList<>();

        int counter =0;
        for(WebElement items : elements){
            a.add(Float.parseFloat(items.getText().replace("$", "")));

            counter++;
        }
        return a;

    }

    public static void assertingCartQuantity(){
        Assert.assertEquals(2,numberOfItems(cartQuantity));
    }

    public static void assertingCartPrice(){
        float num = (float) Array.get(itemsPrice(allItemsPriceCss),0);
        float numtwo = (float) Array.get(itemsPrice(allItemsPriceCss),0);
        Assert.assertEquals(priceItems(cartItemsPrice).get(0),num);
        Assert.assertEquals(priceItems(cartItemsPrice).get(1),numtwo);





    }
}
