package general;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static commons.Waits.waitInit;
import static config.browserFactory.BrowserDriver.driverQuit;
import static config.browserFactory.BrowserDriver.initDriver;

import static general.EnvGlobals.*;
import static general.Functions.*;

public class BaseTest {

    public static String dbhost = EnvGlobals.dbhost;
    public static String dbUser = EnvGlobals.dbUser;
    public static String dbPassword = EnvGlobals.dbPassword;
    public static String query = "Select * from automation_report WHERE id=274181";

    public static String updateQuery = ("UPDATE sonardb.automation_report SET Project_Name='AutomationTest', Platform='QA', Build='Test', Environment='QA', Component_id=1, Commit_Number='12345', Branch_Name='B', Execution_Date='2020-02-25 00:00:00', Total_Cases=4, Passed=4, Failed=0, Skipped=0, Execution_Start_Time='2020-02-28 14:36:33', Execution_End_Time='2020-02-28 14:36:35', Coverage=NULL, IsCoverageFromTestRail=0, Repository_Name=NULL WHERE id=274181;");

//    public static ExtentTest test;
//    public static ExtentReports report;
//    public static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws SQLException, MalformedURLException {

//        initDriver();
//        waitInit();


//        //browser();

        // selectQuery(query, dbhost, dbUser, dbPassword);

//        browseUrl(URL);
//        maximizeBrowser();


    }


    @BeforeMethod
    public void beforeMethod(Method testMethod) throws MalformedURLException {

//        initDriver();
//        System.out.println("before Mehthod");
//        createTest(testMethod.getName());

    }


//    @AfterMethod
//    public void afterMethod(ITestResult result) {
//        if (result.getStatus() == ITestResult.SUCCESS) {
//            String methodName = result.getMethod().getMethodName();
//            String logText = "Test Case: " + methodName + "passed";
//            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//            getExtentTest().log(Status.PASS, m);
//        } else if (result.getStatus() == ITestResult.FAILURE) {
//            String methodName = result.getMethod().getMethodName();
//            String logText = "Test Case: " + methodName + "failed";
//            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
//            getExtentTest().log(Status.FAIL, m);
//        }
//
//        driverQuit();
//
//
//    }


    @BeforeTest
    public void beforeTest() {


    }


    @AfterTest
    public void afterTest() {
//        report.flush();
        System.out.println("after test called");


    }


    @AfterSuite
    public void afterSuite() {
//        closeAllTab();

//        EndReport();
//
//        System.out.println("driver closed");
    }


}
