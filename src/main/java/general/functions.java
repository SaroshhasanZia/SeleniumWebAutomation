package general;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static config.browserFactory.BrowserDriver.webDriver;
import static object.Locators.*;
import static org.openqa.selenium.By.*;


public class functions {








    public static WebDriver driver = webDriver();


    public static void browseUrl(String url){
        driver.get(url);
    }

    public static void maximizeBrowser(){
        driver.manage().window().maximize();
    }



    public static void quitBrowser(){
        driver.quit();
    }

    public static void closeBrowser(){
        driver.close();
    }

    public static < T > WebElement elementById(T value){
        WebElement element = driver.findElement(id ((String) value));
        return element;
    }

    public static < T > WebElement elementByXpath(T value){
        WebElement element = driver.findElement(xpath((String) value));
        return element;
    }
    public static WebElement FindElementByXpath(By Locator){
        WebElement element = driver.findElement(Locator);
        return element;
    }
    public static < T > WebElement elementBy(By value){
        WebElement element = driver.findElement(value);
        return element;
    }


    public static void click(WebElement element){

        element.click();
    }


    public static  void sendKeys(WebElement element,String text ){

        element.sendKeys(text);
    }

    public static < T > void selectElement(By locator,String value){

        Select items = new Select(elementBy(locator));
        items.selectByValue(value);
    }


    public static float[] itemsPrice(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        int size = elements.size();
        System.out.print("total size is "+size+"\n");
        float [] a = new float[size];
        int counter = 0;
        for(WebElement i : elements){
            a[counter]=Float.parseFloat(i.getText().replace("$",""));
            System.out.println("element at "+counter+" "+a[counter]);

            counter++;
        }
        return a;

    }






    public static List<Float> addToCart(By locator, int position){


        int index = itemsPrice(locator).length;
        float price=0;
        List<Float> a = new ArrayList<>();

        for (int i=1;i<=index;i++) {
            String path;
            String pathPrice;

            if (position == i) {
                path = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[" + i + "]/div[2]/div[2]/button[1]";
                pathPrice = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div["+i+"]/div[2]/div[2]/div[1]";
                price = Float.parseFloat(elementByXpath(pathPrice).getText().replace("$",""));
                a.add(price);

                click(elementByXpath(path));


            }

            else {System.out.println("position is out of index");}

        }

//        return price;
        return a;
    }


    public static void login(String username,String password ){
        sendKeys(elementBy(usernameCss),username);
        sendKeys(elementBy(passwordCss),password);
        click(elementBy(loginbtnCss));


    }

    public static int numberOfItems(By Locator){
        List<WebElement> elements = driver.findElements(Locator);
        int counter =0;
        for(WebElement items : elements){

            counter++;
        }
        return counter;

    }


    public static List<Float> priceItems(By Locator){
        List<WebElement> elements = driver.findElements(Locator);
        List<Float> a = new ArrayList<>();

        int counter =0;
        for(WebElement items : elements){
            a.add(Float.parseFloat(items.getText().replace("$", "")));

            counter++;
        }
        return a;

    }


    public static void selectQuery(String query,String host, String username, String password) throws SQLException {

        Connection con = DatabaseConnectivity.dbConnection(host, username, password);

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String columnOne = rs.getString(1);
                String columnTwo = rs.getString(2);
                System.out.println(columnOne + "  " + columnTwo);


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();

        }
    }

    public static void updateQuery(String query,String host, String username, String password) throws SQLException {

        Connection con = DatabaseConnectivity.dbConnection(host, username, password);

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();

            stmt.executeUpdate(query);

            }

        catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();

        }
    }


    public static void implicitWait(){
        Duration d = Duration.ofSeconds(10);
        driver.manage().timeouts().implicitlyWait(d);
    }

    public static void explicitWait(By locator){
        Duration d = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,d);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


    public static void hoverAndClick(By locatorOne, By locatortwo){
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(locatorOne);
        actions.moveToElement(menu);

        WebElement subMenu = driver.findElement(locatortwo);
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }



    public static void ScrollTo(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementBy(locator));


    }

    public static void navigateBack(){
        driver.navigate().back();
    }

    public static void scrollDown() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //hello this is a useless comment
        String url = elementBy(facebookButton).getAttribute("href");
        driver.navigate().to(url);


    }

    public static void moveTo(By locator){

        Actions a = new Actions(driver);
        a.moveToElement(elementBy(locator));
        a.perform();

    }

//    public static void scrollUntill(By locator){
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Duration d = Duration.ofSeconds(3);
//        WebDriverWait wait = new WebDriverWait(driver,d);
//        int i = 1;
//
//        while(i<5) {
//            js.executeScript("window.scrollBy(0,100)");
////            try {
////                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
////
////            }
////
////            catch (TimeoutException t){
////                throw new RuntimeException(t);
////            }
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//
//            if(element!=null){
//                break;
//            }
//            i += 1;
//
//
//
//
//
//        }






//    }

    public static void scrollAndClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        int i = 0;

        while (i < 5) {

            js.executeScript("window.scrollBy(0,100)");
            try {
                click(elementBy(locator));
                System.out.println("Element is clickable");
                break;
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element isn't clickable");
            }
            i+=1;
        }
    }


    public static int randomNumber(){
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int = rand.nextInt(1000);
        return rand_int;
    }




    public static void getScreenShot() throws IOException {
        TakesScreenshot scr = (TakesScreenshot) driver;
        File scrFile = scr.getScreenshotAs(OutputType.FILE);
        File dest = new  File("/home/vend-sarosh/Documents/Web/Selenium/screenshots/file"+randomNumber()+".jpg");

        FileUtils.copyFile(scrFile, dest);




    }

    public static  void closeAllTab(){
        Set<String> w = driver.getWindowHandles();
        for (String i : w){
            driver.switchTo().window(i);
            driver.close();

        }
    }


}


