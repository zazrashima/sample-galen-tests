package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.NotesPage;
import utils.Log;
import utils.PropertyManager;

import java.lang.reflect.Method;

public class NotesTest{

    private HomePage homePage;
    private NotesPage notesPage;
    private WebDriver driver;

    @BeforeClass
    public void getCtx(ITestContext ctx) {
        driver = (WebDriver) ctx.getAttribute("driver");
    }

    @Test
    public void newNoteTest(Method method) {
        Log.info(method.getName() + " test is starting.");
        notesPage = new NotesPage(driver);
        homePage = new HomePage(driver);
        notesPage.waitForPageLoaded();

        Log.info("Clicking on Add Note button ");
        homePage.clickAddNoteButton();

        Log.info("Creating a new note ");
        notesPage.addNewNote("Vinh creates a new note","Any description here");

        Log.info("Verifying a new note is created successfully");
        notesPage.verfiyTextOnPage("Vinh creates a new note");
    }
}
