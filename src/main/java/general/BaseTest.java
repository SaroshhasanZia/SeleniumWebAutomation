package general;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static general.EnvGlobals.*;
import static general.functions.*;

public class BaseTest {

    public static String dbhost = EnvGlobals.dbhost;
    public static String dbUser = EnvGlobals.dbUser;
    public static String dbPassword = EnvGlobals.dbPassword;
    public static String query = "Select * from automation_report WHERE id=274181";

    public static String updateQuery = ("UPDATE sonardb.automation_report SET Project_Name='AutomationTest', Platform='QA', Build='Test', Environment='QA', Component_id=1, Commit_Number='12345', Branch_Name='B', Execution_Date='2020-02-25 00:00:00', Total_Cases=4, Passed=4, Failed=0, Skipped=0, Execution_Start_Time='2020-02-28 14:36:33', Execution_End_Time='2020-02-28 14:36:35', Coverage=NULL, IsCoverageFromTestRail=0, Repository_Name=NULL WHERE id=274181;");

    public static ExtentTest test;
    public static ExtentReports report;


    @BeforeMethod
    public static void beforeMethod() throws SQLException {
        System.out.println("Before Method executing");
//        updateQuery(updateQuery,dbhost,dbUser,dbPassword);
//        selectQuery(query,dbhost,dbUser,dbPassword);

        browseUrl(URL);
        maximizeBrowser();

    }

    @BeforeTest
    public static void beforeTest(){
        System.out.println("before test");
        report = new ExtentReports(System.getProperty("user.dir")+"/reports/ExtentReport-"+ new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss").format(Calendar.getInstance().getTime())+".html");

    }

    @AfterTest
    public static void afterTest(){
        report.flush();
    }



    @AfterSuite
    public static void afterMethod(){
    closeAllTab();


    System.out.println("driver closed");
    }


}
