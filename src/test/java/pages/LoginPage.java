package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
  // Constructor
  public LoginPage(WebDriver driver) {
    super(driver);
  }

  // Web Elements
  private By usernameBy = By.name("login.username");
  private By passwordBy = By.name("login.password");
  private By loginButtonBy = By.xpath("//*[@id=\"login-page\"]/p[3]/button[1]");

  // Page Methods
  public LoginPage loginToTestApp(String username, String password) {
    writeText(usernameBy, username);
    writeText(passwordBy, password);
    click(loginButtonBy);
    return this;
  }


}