package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;
import static reports.ReportManager.unload;

public class ExtentReport {


    static ExtentReports extent;

    public static void initReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Web Automation Report");
            spark.config().setDocumentTitle("Tests");
            extent.attachReporter(spark);
        }
        else System.out.print("Report is NUll");
    }


    public static void tearDownReport() {
        if (Objects.nonNull(extent)) {
            extent.flush();
            unload();
        }
    }

    public static void createTest(String testName) {

        ReportManager.setExtentTest(extent.createTest(testName));
    }
}
