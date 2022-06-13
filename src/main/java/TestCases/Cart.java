package TestCases;

import general.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


import static general.CommonAssertions.isSortedFromLowtoHigh;
import static general.functions.*;
import static general.EnvGlobals.*;
import static object.Locators.*;

public class Cart extends BaseTest {


    @Test(description = "Asserting the Quantity and Price from the cart")
    public static void cartQuantity() throws InterruptedException {
    login(username,password);
    Thread.sleep(2000);
    click(elementBy(priceFilterBtnCss));
    selectElement(priceFilterBtnCss, "hilo");

    System.out.println(isSortedFromLowtoHigh(itemsPrice(allItemsPriceCss)));
        System.out.println(addToCart(allItemsPriceCss,1).get(0));
        System.out.println(addToCart(allItemsPriceCss,2).get(0));
        System.out.println(priceItems(cartItemsPrice).get(0));
        System.out.println(priceItems(cartItemsPrice).get(1));

        Thread.sleep(5000);
        System.out.println();
    click(FindElementByXpath(cartPage));
    Assert.assertEquals(2,numberOfItems(cartQuantity));




    }
}
