package cases;

import constants.Drivers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.google.ResultPage;
import pages.google.SearchPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test_Google_Search {
    private static WebDriver driver;
    private static SearchPage searchPage;
    private static ResultPage resultPage;

    private static final String BASE_URL = "https://google.kz/";

    @BeforeClass
    public static void setup() {
        System.setProperty(Drivers.PACKAGE, Drivers.PATH);
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        searchPage = new SearchPage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        driver.close();
    }

    @Test
    public void testSearch() {
        String expected = "aitu";
        ResultPage resultPage = searchPage.search(expected);
        assertTrue(resultPage.title().contains(expected));
    }
}
