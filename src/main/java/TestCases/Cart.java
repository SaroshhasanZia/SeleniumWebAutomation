package TestCases;

import general.BaseTest;
import org.testng.annotations.Test;


import static general.EnvGlobals.*;
import static object.Cart.*;


public class Cart extends BaseTest {


    @Test(description = "Asserting the Quantity and Price from the cart")
    public static void cartQuantity() throws InterruptedException {

        login(username,password);
        selectProductLowToHigh();
        itemsOrderAssertion();
        addItemsToCart();
        clickOnCart();
        assertingCartQuantity();
        logout();

    }
}
