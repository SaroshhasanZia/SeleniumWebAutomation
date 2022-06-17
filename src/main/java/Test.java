import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static general.functions.browseUrl;

public class Test {



    @org.testng.annotations.Test
    public static void test() {




        File fileC = new File("driver/chromedriver");

        System.setProperty("webdriver.chrome.driver", fileC.getAbsolutePath());
        System.out.println(fileC.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); //!!!should be enabled for Jenkins
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.google.com");

    }
    ///home/vend-sarosh/Documents/Web/Selenium/src/main/java/Test.java
}
