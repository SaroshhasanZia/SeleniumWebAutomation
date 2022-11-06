import org.testng.annotations.Test;
import pages.HomePage;
import pages.IntroScreen;
import pages.Login;

public class Tests {

    private static String email = "saroshhasanzia@gmail.com";
    private static String alertMessage = "We cannot find an account with that email address";
    private static String navBarSelection = "Today's Deals";
    private static String dealsCategory = "2";
    private static String category = "2";
    private static String itemNumber = "1";
    private static String itemQuantity = "3";
    private static String itemsAddedSuccesMsg = "Added to Cart";


    @Test(description = "Verify user can’t login with valid but not registered email")
    public static void userLoginWithUnregisteredEmail(){
        Login l = new Login();
        l.browseWebsite();
        l.clickAppSignInOption();
        l.enterEmail(email);
        l.clickContinueBtn();
        l.VerifyUsingUnregisteredEmail(alertMessage);
    }

    @Test(description = "Verify that items are added to cart correctly")
    public static void toVerifyItemsAreAddedToCartCorrectly() throws InterruptedException {
        HomePage h= new HomePage();
        h.browseWebsite();
        h.navigationBarSelection(navBarSelection);
        h.clickOnDealsCategory(dealsCategory);
        Thread.sleep(2000);
        h.selectCategory(category);
        h.selectItem(itemNumber);
        h.getItemTitle();
        h.getItemPrice();
        h.selectQuantity(itemQuantity);
        h.clickOnAddToCartBtn();
        h.verifyItemIsAddedSuccessfully(itemsAddedSuccesMsg);
        h.clickOnCart();
        h.verifyItemName();
        h.verifyItemPrice();
        h.verifyTotalQuantity();
        h.verifyTotalAmount();
    }

    @Test(description = "Verify that you cannot see “Your Orders” and “Your Addresses” pages if you are\n" +
            "not logged in. But you can see “Your Lists” intro screen")
    public static void toVerifyAccountListItems(){
        IntroScreen i = new IntroScreen();
        i.browseWebsite();
        i.hoverOnAccountAndListAndSelect("Your Orders");
        i.verifyUserIsNavigatedToSignInPage();
        i.backNavigation();
        i.hoverOnAccountAndListAndSelect("Your Addresses");
        i.verifyUserIsNavigatedToSignInPage();
        i.backNavigation();
        i.hoverOnAccountAndListAndSelect("Your Lists");
        i.verifyUserIsNavigatedToListPage();

    }


}
