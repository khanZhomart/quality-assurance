package keywords;

import constants.Constants;
import constants.Drivers;
import constants.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ObjectRepository;

public class Action {
    private static final ObjectRepository repo;
    private static final WebDriver driver;

    static {
        driver = Drivers.getChrome();
        repo = new ObjectRepository();
    }

    public static class Login {

        public static void username() {
            driver
                    .findElement(By.name(repo.get(Properties.USERNAME)))
                    .sendKeys(Constants.USERNAME);
        }

        public static void password() {
            driver
                    .findElement(By.name(repo.get(Properties.PASSWORD)))
                    .sendKeys(Constants.PASSWORD);
        }

        public static void submit() {
            driver
                    .findElement(By.id(repo.get(Properties.LOGIN_BTN)))
                    .click();
        }

        public static boolean authorized() {
            driver
                    .navigate()
                    .to(Constants.PROFILE_URL);
            return driver.getTitle().contains(Constants.USER_FULLNAME);
        }
    }

    public static class Logout {

        public static void home() {
            driver
                    .navigate()
                    .to(Constants.BASE_URL);
        }

        public static void logout() {
            driver
                    .findElement(By.id(repo.get(Properties.PROFILE_DROPDOWN)))
                    .click();
            driver
                    .findElement(By.xpath(repo.get(Properties.LOGOUT_BTN)))
                    .click();
        }
    }

    public static void open(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void close() {
        driver.quit();
    }
}
