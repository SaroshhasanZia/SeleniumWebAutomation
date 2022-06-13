package TestCases;

import general.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static browserFactory.BrowserDriver.webDriver;

import static general.CommonAssertions.*;
import static general.EnvGlobals.password;
import static general.EnvGlobals.username;
import static general.functions.*;
import static general.EnvGlobals.*;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;


public class login extends BaseTest {


@Test(description = "Login With valid Creds")
    public static void loginWithValidCreds() throws InterruptedException {

    Thread.sleep(3000);
    login(username,password);
    Thread.sleep(3000);
    validLoginAssertion("PRODUCTS");


   // closeBrowser();
}


    @Test(description = "Login With Invalid Creds")
    public static void loginWithInvalidCreds() throws InterruptedException {

        Thread.sleep(3000);
        login(username,passwordinv);
        Thread.sleep(3000);
        invalidLoginAssertion("Epic sadface: Username and password do not match any user in this service");
        //quitBrowser();
    }




}
