package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static utils.ProjectPropertiesUtil.getProperties;

public final class BrowserDriver {


    public static void initDriver() throws MalformedURLException {

        if (Objects.isNull(DriverManager.getDriver())) {

            if ("chrome".equals(getProperties("browser"))) {
                WebDriver driver = WebDriverManager.chromedriver().create();
                DriverManager.setDriver(driver);
            } else {
                throw new IllegalArgumentException("Only chrome browser supported");
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
