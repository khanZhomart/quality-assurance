package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Pages;

public class SearchPage extends Pages {

    @FindBy(tagName = "input")
    private WebElement inputSearch;

    public SearchPage(final WebDriver driver) {
        super(driver);
    }

    public ResultPage search(final String text) {
        inputSearch.sendKeys(text);
        inputSearch.submit();
        return new ResultPage(driver);
    }
}
