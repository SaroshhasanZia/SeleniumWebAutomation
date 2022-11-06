package listeners;


import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.net.MalformedURLException;

import static commons.Waits.waitInit;
import static config.browserFactory.BrowserDriver.driverUnload;
import static config.browserFactory.BrowserDriver.initDriver;
import static reports.ExtentLogger.*;
import static reports.ExtentReport.*;

public class Listener implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
        createTest(result.getName());
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        pass(result.getName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        fail(result.getName() + " got failed! " +
                "\n" + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skip(result.getName() + " is skipped");

    }


    @Override
    public void onStart(ISuite suite) {
        try {
            initDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        waitInit();
        initReport();


    }

    @Override
    public void onFinish(ISuite suite) {
        tearDownReport();
        driverUnload();
    }


}
