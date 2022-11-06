package utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static driver.DriverManager.getDriver;


public final class ScreenShotUtils {

    private ScreenShotUtils() {
    }

    public static String getBase64Image() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}

