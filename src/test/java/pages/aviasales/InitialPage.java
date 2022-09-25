package pages.aviasales;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class InitialPage extends Pages {

    @FindBy(id = "origin")
    private WebElement inputOrigin;

    @FindBy(id = "destination")
    private WebElement inputDestination;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div/div[1]/div[3]/div/div/form/div[3]/div/div[1]/div")
    private WebElement inputDepartureDate;

    @FindBy(css = "body > div.header.--blue > div > div > div.web-app__page-header-wrap > div > div.page-header__form-set > div.page-header__form > div > div > form > div.avia-form__field.--dates > div > div.trip-duration__dropdown > div > div > div.trip-duration__content-body.--calendar > div.trip-duration__calendar-wrapper > div > div > div > div.calendar__months > div:nth-child(2) > div.calendar__weeks-body > div:nth-child(4) > div:nth-child(1) > div")
    private WebElement nextMonthDay;

    @FindBy(id = "form-submit")
    private WebElement formSubmit;

    public InitialPage(final WebDriver driver) {
        super(driver);
    }

    public void setInputOrigin(final String origin) {
        inputOrigin.sendKeys(origin);
        leave(inputOrigin);
    }

    public void setInputDestination(final String destination) {
        inputDestination.sendKeys(destination);
        leave(inputDestination);
    }

    public void setInputDepartureDate() {
        inputDepartureDate.click();
//        waitUntil(presenceOfElementLocated(By.className("trip-duration__dropdown")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        nextMonthDay.click();
        nextMonthDay.click();
        formSubmit.click();
        leave(inputDepartureDate);
    }

    private void leave(WebElement element) {
        element.sendKeys(Keys.TAB);
    }

    private void waitUntil(ExpectedCondition<WebElement> condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(condition);
    }
}
