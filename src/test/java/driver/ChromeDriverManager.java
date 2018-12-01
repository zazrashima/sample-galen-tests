package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        //Create a Chrome driver. All test classes use this.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
