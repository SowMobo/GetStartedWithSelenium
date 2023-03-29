
import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.slf4j.LoggerFactory.getLogger;

import java.nio.file.Path;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class NavigationTest {
    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;

        @BeforeClass
    public void setupClass() {
        Optional<Path> browserPath = WebDriverManager.safaridriver().getBrowserPath();
        assumeThat(browserPath).isPresent();
    }

    @BeforeMethod
    public void setup() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(chromeOptions);
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("--remote-allow-origins=*");
        driver = new SafariDriver();
    }

    @Test
    public void test() {
        // Exercise
        String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(sutUrl);
        String title = driver.getTitle();
        log.debug("The title of {} is {}", sutUrl, title);

        // Verify
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with JavaFX");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
