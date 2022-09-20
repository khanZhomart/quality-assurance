package pages.aviasales;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Pages;

public class InitialPage extends Pages {

    @FindBy(id = "origin")
    private WebElement origin;

    @FindBy(id = "destination")
    private WebElement destination;

    public InitialPage(final WebDriver driver) {
        super(driver);
    }
}
