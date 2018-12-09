package tests;

import keywords.helper.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;
import utils.PropertyManager;
import java.lang.reflect.Method;
import static org.testng.AssertJUnit.assertEquals;
import static org.awaitility.Awaitility.*;
import static org.awaitility.Duration.*;
import static java.util.concurrent.TimeUnit.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    private String username = PropertyManager.getInstance().getEmail();
    private String password = PropertyManager.getInstance().getPassword();
    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeClass
    public void getCtx(ITestContext ctx){
        driver = (WebDriver) ctx.getAttribute("driver");
    }

    @Test
    public void launch() {
        homePage = new HomePage(driver);
        homePage.goToHomePage()
                .clickLoginButton();
    }

    @Test
    public void loginTest(Method method) {
        Log.info(method.getName() + " test is starting.");
        loginPage = new LoginPage(driver);
        loginPage.loginToTestApp(username, password);
    }
}
