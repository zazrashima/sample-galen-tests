package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotesPage extends BasePage {
    //Constructor
    public NotesPage(WebDriver driver) {
        super(driver);
    }

    // Web Elements
    private By titleNoteInputBy = By.xpath("//*[@id=\"ad-note-page\"]/p[1]/input");
    private By descriptionNoteInputBy = By.xpath("//*[@id=\"ad-note-page\"]/p[2]/textarea");
    private By addNoteButtonBy = By.xpath("//*[@id=\"ad-note-page\"]/p[3]/button[1]");

    //Page Methods
    public NotesPage addNewNote (String title, String description) {
        writeText(titleNoteInputBy, title);
        writeText(descriptionNoteInputBy, description);
        click(addNoteButtonBy);
        return this;
    }

}
