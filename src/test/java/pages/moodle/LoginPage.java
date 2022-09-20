package pages.moodle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Pages;

public class LoginPage extends Pages {

    @FindBy(css = "#page-wrapper > nav > ul.nav.navbar-nav.usernav > li.nav-item.align-items-center.pl-2 > div > span > a")
    private WebElement loginRedirect;

    @FindBy(name = "username")
    private WebElement inputUsername;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(id = "loginbtn")
    private WebElement loginButton;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public HomePage login(final String username, final String password) {
        loginRedirect.click();
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }
}
