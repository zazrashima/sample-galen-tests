package keywords.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import tests.BaseTest;
import utils.Log;

public class Element extends BaseTest {

    public static boolean isElementVisible(By by) {
        try {
            if (driver.findElement(by).isDisplayed())
                return true;
        }
        catch (NoSuchElementException nse) {
            Log.info("Element is not present");
            return false;
        }
        return false;
    }
}

