package cases;

import constants.Cities;
import constants.Credentials;
import constants.Drivers;
import dev.failsafe.internal.util.Durations;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_Flight_Booking {
    private static WebDriver driver;

    private static final String BASE_URL = "https://www.chocotravel.com/";

    @BeforeClass
    public static void setup() {
        driver = Drivers.getChrome(BASE_URL);
    }

    @Test
    public void testBooking() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(2000L);

        Thread.sleep(2000L);
        WebElement inputFromCity=driver.findElement(By.xpath("//*[@id=\"search_form\"]/div[1]/div[5]/div[1]/div[3]/a[1]"));
        inputFromCity.click();

        Thread.sleep(1000L);
        WebElement inputToCity=driver.findElement(By.xpath("//*[@id=\"city_2_user\"]"));
        inputToCity.sendKeys("Шымкент");

        Thread.sleep(5000L);
        WebElement buttonThereDate=driver.findElement(By.xpath("//*[@id=\"new-calendar-form\"]/div"));
        buttonThereDate.click();
        Thread.sleep(5000L);
        WebElement thereDate=driver.findElement(By.xpath("//*[@id=\"calendar-app\"]/section/div/div[2]/div[2]/div[2]/div[3]/button[25]"));
        thereDate.click();
        WebElement noNeedTicket=driver.findElement(By.xpath("//*[@id=\"calendar-app\"]/section/div/div[1]/button"));
        noNeedTicket.click();

        Thread.sleep(5000L);
        WebElement buttonSearch=driver.findElement(By.xpath("//*[@id=\"search_form\"]/div[1]/div[5]/button[2]"));
        buttonSearch.click();

        Thread.sleep(10000L);
        WebElement tickboxTwo=driver.findElement(By.xpath("//*[@id=\"search-page-app\"]/div/div[2]/div[2]/div[1]/div/div/div[3]/div[1]/div[1]"));
        tickboxTwo.click();

        WebElement choose=driver.findElement(By.xpath("//*[@id=\"search-page-app\"]/div/div[2]/div[4]/div[1]/div[6]/div[2]/button"));
        choose.click();

        Thread.sleep(10000L);

        WebElement surname=driver.findElement(By.xpath("//*[@id=\"choco-spa-app\"]/section/div[2]/div[2]/div/div[2]/div/div/div[1]/div/label/input"));
        WebElement name=driver.findElement(By.xpath("//*[@id=\"choco-spa-app\"]/section/div[2]/div[2]/div/div[2]/div/div/div[2]/div/label/input"));
        WebElement gender=driver.findElement(By.xpath("//*[@id=\"choco-spa-app\"]/section/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div/div/label[2]"));
        WebElement birthday=driver.findElement(By.xpath("//*[@id=\"choco-spa-app\"]/section/div[2]/div[2]/div/div[2]/div/div/div[4]/div/label/input"));
        WebElement numberOfDoc=driver.findElement(By.xpath("//*[@id=\"choco-spa-app\"]/section/div[2]/div[2]/div/div[2]/div/div/div[6]/div/label/input"));
        WebElement expDate=driver.findElement(By.xpath("//*[@id=\"choco-spa-app\"]/section/div[2]/div[2]/div/div[2]/div/div/div[7]/div/label/input"));
        WebElement iin=driver.findElement(By.xpath("//*[@id=\"choco-spa-app\"]/section/div[2]/div[2]/div/div[2]/div/div/div[8]/div/label/input"));

        surname.sendKeys(Credentials.FIRST_NAME);
        name.sendKeys(Credentials.LAST_NAME);
        gender.click();
        birthday.sendKeys(Credentials.BIRTH_DATE);
        numberOfDoc.sendKeys(Credentials.Docs.DOC_NO);
        expDate.sendKeys(Credentials.Docs.DOC_EXPIRATION_DATE);
        iin.sendKeys(Credentials.Docs.DOC_UIN);

        Thread.sleep(5000L);
        WebElement tickboxCon=driver.findElement(By.xpath("//*[@id=\"choco-spa-app\"]/section/div[2]/div[6]/div[1]/div/div/div/label"));
        tickboxCon.click();
    }
}
