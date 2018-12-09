package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NotesPage;
import utils.Log;

import java.lang.reflect.Method;

public class NotesTest{

    private WebDriver driver;

    @BeforeClass
    public void getCtx(ITestContext ctx) {
        driver = (WebDriver) ctx.getAttribute("driver");
    }

    @Test
    public void newNoteTest(Method method) {
        Log.info(method.getName() + " test is starting.");
        HomePage homePage = new HomePage(driver);
        NotesPage notesPage = new NotesPage(driver);

        notesPage.clickAddNewNoteButton()
                .addNewNote("Vinh creates a new note","Any description here");

        Log.info("Verify a new note is created successfully");
        notesPage.verfiyTextOnPage("Vinh creates a new note");
    }
}
