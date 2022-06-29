package object;

import general.Functions;
import org.openqa.selenium.By;
import org.testng.Assert;

import static general.CommonAssertions.textAssertion;
import static general.Functions.*;


public class Login {

    public static By usernameCss = By.cssSelector("#user-name");
    public static By passwordCss = By.cssSelector("#password");

    public static By loginbtnCss = By.cssSelector("#login-button");
    static By error = By.xpath("//h3[@data-test=\"error\"]");
    static By ProductpageCss = By.xpath("//span[text()=\"Products\"]");
    public static By menu_button = By.xpath("//button[@id=\"react-burger-menu-btn\"]");
    public static By logoutButton= By.xpath("//a[@id=\"logout_sidebar_link\"]");




    public static void logout(){
        click(menu_button);
        click(logoutButton);
    }

    public static void login(String username,String password ){
        clear(usernameCss);

        sendKeys((usernameCss),username);
        clear(passwordCss);
        sendKeys((passwordCss),password);
        click((loginbtnCss));

    }

    public static void validLoginAssertion(String actual){
        textAssertion(ProductpageCss,actual);
    }

    public static void invalidLoginAssertion(String actual) {

        String text = Functions.elementBy(error).getText();
        Assert.assertEquals(text,actual);
    }

}
