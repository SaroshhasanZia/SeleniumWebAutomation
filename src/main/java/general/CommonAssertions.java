package general;
import org.openqa.selenium.By;
import org.testng.Assert;

import static general.Functions.getTextFromElement;
import static general.Functions.removeNonNumericCharacters;

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

    public static void textAssertion(By element,String expected) {

        String text = Functions.elementBy(element).getText();
        Assert.assertEquals(text,expected);

    }


    public static void intValueAssertion(By element,int expected) {

        String text = getTextFromElement(element);
        int value = Integer.parseInt(removeNonNumericCharacters(text));
        Assert.assertEquals(value,expected);

    }

    public static void floatValueAssertion(By element,float expected) {

        String text = getTextFromElement(element);
        Float value = Float.parseFloat(removeNonNumericCharacters(text));
        Assert.assertEquals(value,expected);

    }



    public static void elementsTextAssertion(By element1,By element2) {

        String actual = Functions.elementBy(element1).getText();
        String expected = Functions.elementBy(element2).getText();
        Assert.assertEquals(actual,expected);
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
