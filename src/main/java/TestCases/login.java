package TestCases;

import com.relevantcodes.extentreports.LogStatus;
import general.BaseTest;
import org.testng.annotations.Test;

import static general.CommonAssertions.*;
import static general.EnvGlobals.password;
import static general.EnvGlobals.username;
import static general.functions.*;
import static general.EnvGlobals.*;


public class login extends BaseTest {


@Test(description = "Login With valid Creds")
    public static void loginWithValidCreds() throws InterruptedException {

    test = report.startTest("Test to verify valid Login Creds");

    login(username,password);
    Thread.sleep(3000);
    try{
        validLoginAssertion("PRODUCTS");
        test.log(LogStatus.PASS,"Login with valid creds passed");
    }
    catch (Exception e){
        test.log(LogStatus.FAIL,"Login with valid creds Failed");

    }
    report.endTest(test);



    // closeBrowser();
}


    @Test(description = "Login With Invalid Creds")
    public static void loginWithInvalidCreds() throws InterruptedException {

        Thread.sleep(3000);
        login(username,passwordinv);
        Thread.sleep(3000);
        try{
            invalidLoginAssertion("Epic sadface: Username and password do not match any user in this service");
            test.log(LogStatus.PASS,"Login with invalid creds passed");
        }
        catch (Exception e){
            test.log(LogStatus.FAIL,"Login with invalid creds Failed");

        }
        report.endTest(test);

        //quitBrowser();
    }




}
