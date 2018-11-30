package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.NotesPage;
import utils.Log;
import utils.PropertyManager;

import java.lang.reflect.Method;

public class NotesTest extends BaseTest {

    private String username = PropertyManager.getInstance().getEmail();
    private String password = PropertyManager.getInstance().getPassword();

    @Test(priority = 0, description = "Successful Login Scenario with valid username and password")
    public void newNote(Method method) {
        Log.info(method.getName() + " test is starting.");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        NotesPage notesPage = new NotesPage(driver);

        Log.info("Opening Sample Website for Galen Framework website");
        homePage.goToHomePage();

        Log.info("Opening Login page");
        homePage.gotoLoginPage();

        Log.info("Trying to login.");
        loginPage.loginToTestApp(username, password);

        Log.info("Verifying login.");
        loginPage.verfiyTextOnPage("My Notes");

        Log.info("Clicking on Add note button");
        homePage.clickAddNoteButton();

        Log.info("Adding a new note.");
        notesPage.addNewNote("Vinh creates a new note", "Sample Description");

        Log.info("Verify a new note is created successfully");
        notesPage.verfiyTextOnPage("Vinh creates a new note");
    }

}
