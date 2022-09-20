package pages.google;

import org.openqa.selenium.WebDriver;
import pages.Pages;

public class ResultPage extends Pages {

    public ResultPage(final WebDriver driver) {
        super(driver);
    }

    public String title() {
        return driver.getTitle();
    }

    public ResultPage manage() {
        return new ResultPage(driver);
    }
}
