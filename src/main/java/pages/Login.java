package pages;

import org.openqa.selenium.By;

import static general.CommonAssertions.textAssertion;
import static general.EnvGlobals.URL;
import static general.Functions.*;

public class Login {

   private By AppSignInOption = By.id("nav-link-accountList-nav-line-1");
   private By emailTextBox = By.id("ap_email");
   private By continueBtn = By.id("continue");
   private By alertMsg = By.className("a-list-item");




   public void browseWebsite(){
       browseUrl(URL);
       maximizeBrowser();
   }
   public void clickAppSignInOption(){
       click(AppSignInOption);
   }


   public void enterEmail(String email){
       sendKeys(emailTextBox,email);
   }

   public void clickContinueBtn(){
       click(continueBtn);
   }

   public void VerifyUsingUnregisteredEmail(String text){
       textAssertion(alertMsg,text);
   }


}
