package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createDriver() {

        //Create a Firefox driver. All test classes use this.
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
