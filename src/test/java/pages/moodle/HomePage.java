package pages.moodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Pages;

public class HomePage extends Pages {

    @FindBy(id = "action-menu-toggle-1")
    private WebElement profileMenu;

    public HomePage(final WebDriver driver) {
        super(driver);
    }

    public void logout() {
        profileMenu.click();
        driver.findElement(By.xpath("//*[@id=\"action-menu-1-menu\"]/a[6]")).click();
    }

    public boolean authorized() {
        return profileMenu.isEnabled();
    }
}
