package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Log;

public class NotesPage extends BasePage {
    //Constructor
    public NotesPage(WebDriver driver) {
        super(driver);
    }

    // Web Elements
    @FindBy(how = How.CSS, using =  "#ad-note-page > p:nth-child(2) > input")
    WebElement titleInput;

    @FindBy(how = How.CSS, using =  "#ad-note-page > p:nth-child(3) > textarea")
    WebElement descriptionInput;

    @FindBy(how = How.CSS, using =  "#my-notes-page > button")
    WebElement addNoteButton;

    @FindBy(how = How.CSS, using =  "#ad-note-page > p:nth-child(5) > button.btn.btn-lg.btn-primary")
    WebElement addNewNoteButton;

    //Page Methods
    public NotesPage addNewNote (String title, String description) {
        Log.info("Add a new note");writeText(titleInput, title);
        writeText(descriptionInput, description);
        click(addNewNoteButton);
        return this;
    }

    public NotesPage clickAddNewNoteButton()
    {
        addNoteButton.click();
        return this;
    }

}
