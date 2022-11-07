package commons;


import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BrowserUtils;

import static utils.BrowserUtils.getTextFromElement;
import static utils.BrowserUtils.removeNonNumericCharacters;

public class CommonAssertions {


    public static void textAssertion(By element, String expected) {

        String text = BrowserUtils.elementBy(element).getText();
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
}
