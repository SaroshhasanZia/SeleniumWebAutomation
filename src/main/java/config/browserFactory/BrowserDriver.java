package config.browserFactory;

import general.EnvGlobals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

public class BrowserDriver {

    public static WebDriver driver;

    public static WebDriver webDriver() {



        if(driver != null){
            driver = driver;
        }
        else {
            WebDriver _driver = browser();
            driver = _driver;
        }
        return driver;
    }





    public static WebDriver browser(){
        switch (EnvGlobals.browser){

            case "chrome":
                File fileC = new File("driver/chromedriver");
                System.setProperty("webdriver.chrome.driver", fileC.getAbsolutePath());
                System.out.println(fileC.getAbsolutePath());
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); //!!!should be enabled for Jenkins
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);

                break;

            case "edge":
                File fileE = new File("driver/msedgedriver");
                System.setProperty("webdriver.edge.driver", fileE.getAbsolutePath());
                driver = new EdgeDriver();
                break;

            case "firefox":
                File filef = new File("driver/geckodriver");
                System.setProperty("webdriver.gecko.driver", filef.getAbsolutePath());
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }



}