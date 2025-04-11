
package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;

public class Prerequisites {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://example.com"); // Replace with actual URL
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
