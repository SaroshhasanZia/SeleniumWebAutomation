package TestCases;

import general.BaseTest;
import static general.Functions.*;
import static java.lang.Thread.sleep;
import static general.EnvGlobals.*;
import static object.MultipleTestCases.*;

import org.testng.annotations.Test;

import java.io.IOException;


public class MultipleTest extends BaseTest  {




    @Test(description="")
    public static void multipleTestCases() throws InterruptedException, IOException {

        login(username,password);
        contactSales();
        formFill();
        clickFacebookButton();
        switchToChildWindow();
        facebookAssertion();
        switchToParentWindow();


    }

}
