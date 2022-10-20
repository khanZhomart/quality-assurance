package cases;

import constants.Constants;
import keywords.Action;
import keywords.ActionPerformer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ExcelReader;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Test_Moodle {

    @BeforeTest
    public static void setup() {
        Action.open(Constants.LOGIN_URL);
    }

    @AfterTest
    public static void tearDown() {
        Action.close();
    }

    @Test(testName = "Testing the login functionality", priority = 1)
    public void testLogin() {
        ExcelReader.keywords("LOGIN").forEach(ActionPerformer::perform);
        assertTrue(Action.Login.authorized());
    }

    @Test(testName = "Testing the logout functionality", priority = 2)
    public void testLogout() {
        ExcelReader.keywords("LOGOUT").forEach(ActionPerformer::perform);
        assertFalse(Action.Login.authorized());
    }
}
