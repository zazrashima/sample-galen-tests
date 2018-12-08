package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Web Elements
    private final By usernameBy = By.name("login.username");
    private final By passwordBy = By.name("login.password");
    private final By loginButtonBy = By.xpath("//*[@id=\"login-page\"]/p[3]/button[1]");

    // Page Methods
    public LoginPage loginToTestApp(String username, String password) {
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }
}