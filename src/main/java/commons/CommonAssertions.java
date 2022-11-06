package commons;

import commons.Functions;
import org.openqa.selenium.By;
import org.testng.Assert;

import static commons.Functions.getTextFromElement;
import static commons.Functions.removeNonNumericCharacters;

public class CommonAssertions {


    public static void textAssertion(By element, String expected) {

        String text = Functions.elementBy(element).getText();
        Assert.assertEquals(text, expected);

    }


    public static void intValueAssertion(By element, int expected) {

        String text = getTextFromElement(element);
        int value = Integer.parseInt(removeNonNumericCharacters(text));
        Assert.assertEquals(value, expected);

    }

    public static void floatValueAssertion(By element, float expected) {

        String text = getTextFromElement(element);
        Float value = Float.parseFloat(removeNonNumericCharacters(text));
        Assert.assertEquals(value, expected);

    }


    public static void elementsTextAssertion(By element1, By element2) {

        String actual = Functions.elementBy(element1).getText();
        String expected = Functions.elementBy(element2).getText();
        Assert.assertEquals(actual, expected);
    }


}
