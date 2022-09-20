package cases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.moodle.HomePage;
import pages.moodle.LoginPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Test_Moodle_Login {
    private static WebDriver driver;

    private static final String BASE_URL = "https://moodle.astanait.edu.kz/";
    private static final String USERNAME = "201670";
    private static final String PASSWORD = "Jomatalg01#";

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jtalg\\IdeaProjects\\qa2\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        driver.close();
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        assertTrue(homePage.authorized());
    }
}
