package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyManager;

public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Page Variables
    private final String baseURL = PropertyManager.getInstance().getUrl();

    //Web Elements
    private final By signInButtonBy = By.xpath("//*[@id=\"welcome-page\"]/p[3]/button");
    private final By addNoteButtonBy = By.xpath("//*[@id=\"my-notes-page\"]/button");

    //Go to Homepage
    public HomePage goToHomePage() {
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public LoginPage gotoLoginPage() {
        click(signInButtonBy);
        return new LoginPage(driver);
    }

    //Click on Add Note button
    public HomePage clickAddNoteButton() {
        click(addNoteButtonBy);
        return this;
    }

}
