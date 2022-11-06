package config.browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Objects;

import static config.browserFactory.DriverManager.*;
import static java.util.Objects.nonNull;
import static utils.ProjectPropertiesUtil.getProperties;

public final class BrowserDriver {

    private static WebDriver driver;


    public static void initDriver() throws MalformedURLException {

        if (Objects.isNull(getDriver())) {

            switch (getProperties("browser")) {


                case "chrome":

                    driver = WebDriverManager.chromedriver().create();
                    setDriver(driver);
                    break;

                case "firefox":

                    driver = WebDriverManager.firefoxdriver().create();
                    setDriver(driver);
                    break;

            }
        }
    }

    public static void driverUnload() {
        if (nonNull(getDriver())) {
            getDriver().quit();
            unloadDriver();
        }
    }


}
