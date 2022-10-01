package cases.dodo;

import constants.Drivers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Test_Dodo {
    private static WebDriver driver;
    private static final String BASE_URL = "https://dodopizza.kz/astana";
    private static final String CASHBACK_TITLE = "Вкусный кэшбэк";

    @BeforeClass
    public static void setup() {
        driver = Drivers.getChrome(BASE_URL);
    }

    @Test
    public void testDodocoins() throws InterruptedException {
        Thread.sleep(2500);
        WebElement element = driver.findElement(By.cssSelector("#react-app > header > div.right > a:nth-child(1)"));
        element.click();
        assertTrue(driver.getTitle().contains(CASHBACK_TITLE));
    }

    @Test
    public void testPaws() throws InterruptedException {
        Thread.sleep(2500);
        WebElement element = driver.findElement(By.cssSelector("#react-app > div.sc-1fsi0ov-0.hRveMR"));
        element.click();
        Thread.sleep(3000);
        assertNotNull(element);
    }

    @Test
    public void testCart() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.cssSelector("#react-app > nav > div > div.xlo7eb-3.dQDTpi > button"));
        element.click();
        Thread.sleep(1500);
        assertNotNull(element);
    }

    @Test
    public void testCartAdd() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1500);
        WebElement element = driver.findElement(By.cssSelector("#pizzas > article:nth-child(5) > footer > button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.cssSelector("#pizzas > article:nth-child(4) > footer > button")).click();
        Thread.sleep(1500);
        element = driver.findElement(By.cssSelector("body > div:nth-child(12) > div > div.sc-1dazsw3-2.pnLpo > div > div > div.gsrbdo-8.dQwDFJ > div.gsrbdo-18.dlfBaI > button"));
        element.click();
        Thread.sleep(1500);
        element = driver.findElement(By.cssSelector("#react-app > nav > div > div.xlo7eb-3.dQDTpi > button"));
        element.click();
        element = driver.findElement(By.cssSelector("body > div:nth-child(12) > div > div.sc-1v5x861-1.iMYFrd > div > div > div:nth-child(1) > main"));
        assertNotNull(element);
    }

    @Test
    public void testCardRemove() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1500);
        WebElement element = driver.findElement(By.cssSelector("#pizzas > article:nth-child(5) > footer > button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.cssSelector("#pizzas > article:nth-child(4) > footer > button")).click();
        Thread.sleep(1500);
        element = driver.findElement(By.cssSelector("body > div:nth-child(12) > div > div.sc-1dazsw3-2.pnLpo > div > div > div.gsrbdo-8.dQwDFJ > div.gsrbdo-18.dlfBaI > button"));
        element.click();
        Thread.sleep(1500);
        element = driver.findElement(By.cssSelector("#react-app > nav > div > div.xlo7eb-3.dQDTpi > button"));
        element.click();
        Thread.sleep(1500);
        element = driver.findElement(By.cssSelector("body > div:nth-child(12) > div > div.sc-1v5x861-1.iMYFrd > div > div > div:nth-child(1) > main > section:nth-child(2) > article > button"));
        element.click();
        element = driver.findElement(By.cssSelector("body > div:nth-child(12) > div > div.sc-1v5x861-1.iMYFrd > div > div > div:nth-child(1) > main"));
        assertNotNull(element);
    }
}
