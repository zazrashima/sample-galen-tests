package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Log;

public class LoginPage extends BasePage {
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Web Elements
    @FindBy(how = How.CSS, using =  "#login-page > p:nth-child(2) > input")
    WebElement usernameInput;

    @FindBy(how = How.CSS, using =  "#login-page > p:nth-child(3) > input")
    WebElement passwordInput;

    @FindBy(how = How.CSS, using =  "#login-page > p:nth-child(5) > button.btn.btn-lg.btn-primary.button-login")
    WebElement loginButton;

    // Page Methods
    public LoginPage loginToTestApp(String username, String password) {
        Log.info("Logging in");
        writeText(usernameInput, username);
        writeText(passwordInput, password);
        click(loginButton);
        return this;
    }
}