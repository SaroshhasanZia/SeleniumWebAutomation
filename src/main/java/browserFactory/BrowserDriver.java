package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class BrowserDriver {

    private static ChromeDriver driver;

    public static WebDriver webDriver() {
        File file = new File("driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeDriver driver = new ChromeDriver();
        return driver;

//        if(driver != null){
//            driver = driver;
//        }
//        else {
//            ChromeDriver _driver = new ChromeDriver();
//            driver = _driver;
//        }
//        return driver;
//    }


    }}
