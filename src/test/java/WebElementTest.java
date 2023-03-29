import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import static org.slf4j.LoggerFactory.getLogger;


public class WebElementTest {

    static final Logger log = getLogger(MethodHandles.lookup().lookupClass());
    WebDriver driver;

    @BeforeClass
    static void setupClass() {
        WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    void setup() {
        driver = new SafariDriver();
    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {

    }

}
