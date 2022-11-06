package config.browserFactory;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
    }

    private static ThreadLocal<WebDriver> thread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return thread.get();
    }

    public static void setDriver(WebDriver value) {
        thread.set(value);
    }

    public static void unloadDriver() {
        thread.remove();
    }


}
