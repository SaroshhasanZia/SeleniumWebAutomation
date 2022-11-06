package TestCases;


import general.BaseTest;
import org.testng.annotations.Test;

import static general.EnvGlobals.password;
import static general.EnvGlobals.username;
import static general.EnvGlobals.*;
import static pages.Loginold.*;


public class Login extends BaseTest {


@Test(description = "Login With valid Creds")
    public static void loginWithValidCreds() throws InterruptedException {

    login(username,password);
    validLoginAssertion("PRODUCTS");
    logout();

}



@Test(description = "Login With Invalid Creds")
    public static void loginWithInvalidCreds() throws InterruptedException {

        login(username,passwordinv);
        invalidLoginAssertion("Epic sadface: Username and password do not match any user in this service");

    }




}
