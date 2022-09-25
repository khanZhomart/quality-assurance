package pages.google;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Pages;

public class SearchPage extends Pages {

    @FindBy(tagName = "input")
    private WebElement inputSearch;

    public SearchPage(final WebDriver driver) {
        super(driver);
    }

    public ResultPage search(final String text) {
        inputSearch.sendKeys(text);
        inputSearch.sendKeys(Keys.ENTER);
        return new ResultPage(driver);
    }
}
