package config.browserFactory;

import general.EnvGlobals;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static config.DriverManager.DriverManager.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class BrowserDriver {

//    public static WebDriver driver;




    public static void initDriver() throws MalformedURLException {

        if(Objects.isNull(getDriver())) {

            switch (EnvGlobals.browser) {


                case "chrome":

                    WebDriver driver = WebDriverManager.chromedriver().create();
                    setDriver(driver);
                    break;

                case "edge":
                    File fileE = new File("driver/msedgedriver");
                    System.setProperty("webdriver.edge.driver", fileE.getAbsolutePath());
                    driver = new EdgeDriver();
                    setDriver(driver);
                    break;

                case "firefox":
                    if (EnvGlobals.execution.equalsIgnoreCase("remote")) {
                        DesiredCapabilities cap = new DesiredCapabilities();
                        cap.setBrowserName(BrowserType.FIREFOX);
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                        setDriver(driver);

                    } else {

                        File filef = new File("driver/geckodriver");
                        System.setProperty("webdriver.gecko.driver", filef.getAbsolutePath());
                        DesiredCapabilities capb = new DesiredCapabilities();
                        capb.setBrowserName(BrowserType.FIREFOX);
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capb);
                        setDriver(driver);
                    }
                    break;

            }
        }
//        return getDriver();
    }

    public static void driverQuit(){
        if(nonNull(getDriver())) {
            getDriver().quit();
            unloadDriver();
        }
    }



}
