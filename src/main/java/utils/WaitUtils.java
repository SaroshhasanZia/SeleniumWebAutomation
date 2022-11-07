package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverManager.getDriver;

public class WaitUtils {

    static WebDriverWait wait;

    public static void waitInit() {
        Duration d = Duration.ofSeconds(6);
        wait = new WebDriverWait(getDriver(), d);
    }

    public static void waitUntilElementIsClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
