package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static utils.ProjectPropertiesUtil.getProperties;

public final class BrowserDriver {

    private static WebDriver driver;


    public static void initDriver() throws MalformedURLException {

        if (Objects.isNull(DriverManager.getDriver())) {

            switch (getProperties("browser")) {


                case "chrome":

                    driver = WebDriverManager.chromedriver().create();
                    DriverManager.setDriver(driver);
                    break;

                case "firefox":

                    driver = WebDriverManager.firefoxdriver().create();
                    DriverManager.setDriver(driver);
                    break;

            }
        }
    }

    public static void driverUnload() {
        if (nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }


}
