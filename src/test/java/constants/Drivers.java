package constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {
    public static final String PACKAGE = "webdriver.chrome.driver";
    public static final String PATH = "C:\\Users\\zforz\\IdeaProjects\\qa2_Zhomartkhan_Talgatuly_SE-2016\\src\\test\\resources\\drivers\\chromedriver.exe";

    public static WebDriver getChrome(final String url) {
        System.setProperty(Drivers.PACKAGE, Drivers.PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }
}
