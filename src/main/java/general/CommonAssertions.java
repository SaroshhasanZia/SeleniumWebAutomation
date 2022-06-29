package general;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CommonAssertions {


    static By error = By.xpath("//h3[@data-test=\"error\"]");
    static By ProductpageCss = By.cssSelector("div.page_wrapper div:nth-child(1) div.header_container:nth-child(1) div.header_secondary_container > span.title");

//    public static void invalidLoginAssertion(String actual) {
//
//        String text = functions.elementBy(error).getText();
//        Assert.assertEquals(text,actual);
//    }

//    public static void validLoginAssertion(String actual){
//        textAssertion(ProductpageCss,actual);
//    }

    public static void textAssertion(By actualCss,String actual) {

        String text = Functions.elementBy(actualCss).getText();
        Assert.assertEquals(text,actual);
    }


    public static boolean isSortedFromLowtoHigh(float[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1])
                return false;
        }
        return true;
    }


    public static boolean isSortedFromHightoLow(float[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }



}
