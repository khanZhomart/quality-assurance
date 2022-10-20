package constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {
    public static final String PACKAGE = "webdriver.chrome.driver";
    public static final String PATH = "src/test/resources/drivers/chromedriver.exe";

    public static WebDriver getChrome() {
        System.setProperty(Drivers.PACKAGE, Drivers.PATH);
        return new ChromeDriver();
    }
}
