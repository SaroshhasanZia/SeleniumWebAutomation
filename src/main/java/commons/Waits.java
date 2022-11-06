package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.browserFactory.DriverManager.getDriver;

public class Waits {

    static WebDriverWait wait;

    public static void waitInit() {
        Duration d = Duration.ofSeconds(6);

        wait = new WebDriverWait(getDriver(), d);
    }

    public static void implicitWait() {
        Duration d = Duration.ofSeconds(10);
        getDriver().manage().timeouts().implicitlyWait(d);
    }

    public static void waitUntilElementIsClickable(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public static void waitUntilElementIsVisible(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}
