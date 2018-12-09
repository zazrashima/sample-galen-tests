package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Log;
import utils.PropertyManager;

public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Page Variables
    private final String baseURL = PropertyManager.getInstance().getUrl();

    //Web Elements
    @FindBy(how = How.CSS, using = "#welcome-page > p:nth-child(4) > button")
    private WebElement signInButton;

    //Go to Homepage
    public HomePage goToHomePage() {
        Log.info("Opening " + baseURL);
        visit(baseURL);
        return this;
    }

    //Go to LoginPage
    public HomePage clickLoginButton() {
        Log.info("Click Login button");
        click(signInButton);
        return this;
    }

}
