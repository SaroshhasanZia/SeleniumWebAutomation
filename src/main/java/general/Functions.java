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
import java.util.Random;
import java.util.Set;
import general.BaseTest.*;
import org.testng.Assert;


import static commons.Waits.waitUntilElementIsClickable;
import static config.DriverManager.DriverManager.getDriver;

import static org.openqa.selenium.By.*;


public class Functions {






//    public static WebDriver instantiateDriver(){
//        WebDriver driver = browser();
//        return driver;
//    }

//   public static WebDriver driver = getDriver();



    public static void browseUrl(String url){
        getDriver().get(url);
    }


    public static String getXpath(String xpath, String value){
        return String.format(xpath, value);

    }

    public static void maximizeBrowser(){
        getDriver().manage().window().maximize();
    }



    public static void quitBrowser(){
        getDriver().quit();
    }

    public static void closeBrowser(){
        getDriver().close();
    }

    public static  WebElement elementById(String value){
        WebElement element = getDriver().findElement(id ((String) value));
        return element;
    }

    public static < T > WebElement elementByXpath(T value){
        WebElement element = getDriver().findElement(xpath((String) value));
        return element;
    }
    public static WebElement FindElementByXpath(By Locator){
        WebElement element = getDriver().findElement(Locator);
        return element;
    }
    public static < T > WebElement elementBy(By value){
        WebElement element = getDriver().findElement(value);
        return element;
    }

    public static void clicks(By element){
        elementBy(element).click();
    }


    public static void click(By element){

        try{
            waitUntilElementIsClickable(element);
            {
                elementBy(element).click();

            }
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail("element not located: "+element);

        }


    }


    public static  void sendKeys(By element,String text ){
    try{
        waitUntilElementIsClickable(element);
        {
            elementBy(element).sendKeys(text);

        }
    }
    catch (Exception e){
        e.printStackTrace();
    }

    }

    public static void selectElement(By locator,String value){

        try{
            waitUntilElementIsClickable(locator);
            {
                Select items = new Select(elementBy(locator));
                items.selectByValue(value);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail("element not located");
        }


    }






//    public static void login(String username,String password ){
//        sendKeys((usernameCss),username);
//        sendKeys((passwordCss),password);
//        click((loginbtnCss));
//
//
//    }







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





    public static void hoverAndClick(By locatorOne, By locatortwo){
        Actions actions = new Actions(getDriver());
        WebElement menu = getDriver().findElement(locatorOne);
        actions.moveToElement(menu);

        WebElement subMenu = getDriver().findElement(locatortwo);
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }



    public static void ScrollTo(By locator){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", elementBy(locator));


    }

    public static void navigateBack(){

        getDriver().navigate().back();
    }

//    public static void scrollDown() {
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//        //hello this is a useless comment
//        String url = elementBy(facebookButton).getAttribute("href");
//        driver.navigate().to(url);
//
//
//    }

    public static void moveTo(By locator){

        Actions a = new Actions(getDriver());
        a.moveToElement(elementBy(locator));
        a.perform();

    }







//    }

    public static void scrollAndClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        int i = 0;

        while (i < 5) {

            js.executeScript("window.scrollBy(0,100)");
            try {
                clicks(locator);
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
        TakesScreenshot scr = (TakesScreenshot) getDriver();
        File scrFile = scr.getScreenshotAs(OutputType.FILE);
        File dest = new  File("/home/vend-sarosh/Documents/Web/Selenium/screenshots/file"+randomNumber()+".jpg");

        FileUtils.copyFile(scrFile, dest);




    }



    public static  void closeAllTab(){
        Set<String> w = getDriver().getWindowHandles();
        for (String i : w){
            getDriver().switchTo().window(i);
            getDriver().close();

        }
    }


    public static void switchToParentWindow() {
        ArrayList<String> tab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tab.get(0));
        }

    public static void switchToChildWindow() {
        ArrayList<String> tab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tab.get(1));
    }






    public static void clear(By element){
        elementBy(element).clear();
    }

    public static String removeNonNumericCharacters(String value){
        return value.replaceAll("[^\\d.]", "");
    }

    public static String getTextFromElement(By by){

        return elementBy(by).getText();
    }

    public static String getTextFromElementByInnerText(By by){
        return elementBy(by).getAttribute("innerText");
    }

}


