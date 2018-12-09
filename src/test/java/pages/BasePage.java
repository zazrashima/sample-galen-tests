package pages;

import org.awaitility.core.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.*;
import static org.awaitility.Duration.*;
import static java.util.concurrent.TimeUnit.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
class BasePage {
    final WebDriver driver;
    private final WebDriverWait wait;

    //Constructor
    BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    //Wait Wrapper Method
    private void waitVisibility(WebElement element) {
        await("Wait for element to be visible").atMost(10, SECONDS)
                .until(element::isDisplayed);
    }

    void visit(String route) {
        Log.info("Open " + route);
        driver.get(route);
        waitForPageLoad();
    }

    void click(WebElement element) {
        Log.info("Click on an element");
        waitVisibility(element);
        element.click();
    }

    void writeText(WebElement element, String text) {
        Log.info("Set text on an element");
        waitVisibility(element);
        element.sendKeys(text);
    }

    private String readText(WebElement element){
        Log.info("Retrieve text of an element");
        waitVisibility(element);
        return element.getText();
    }

    void assertEquals(WebElement element, String expectedText) {
        waitVisibility(element);
        assertThat(readText(element)).isEqualTo(expectedText);
    }

    public void waitForPageLoad() {
        Log.info("Wait until page is loaded successfully");
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public boolean verfiyTextOnPage(String textToVerify) {
        boolean textFound;
        try {
            driver.findElement(By.xpath("//*[contains(text(),${textToVerify})]"));
            textFound = true;
        } catch (Exception e) {
            textFound = false;
        }
        return textFound;
    }
}
