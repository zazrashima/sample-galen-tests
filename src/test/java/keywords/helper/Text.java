package keywords.helper;

import org.openqa.selenium.By;
import tests.BaseTest;

public class Text extends BaseTest {
    public static boolean verfiyTextOnPage(String textToVerify) {
        boolean textFound = false;
        try {
            driver.findElement(By.xpath("//*[contains(text(),${textToVerify})]"));
            textFound = true;
        } catch (Exception e) {
            textFound = false;
        }
        return textFound;
    }
}
