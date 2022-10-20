package keywords;

public class ActionPerformer {

    public static void perform(String keyword) {
        switch (keyword) {
            case "ENTER_USERNAME":
                Action.Login.username();
                break;
            case "ENTER_PASSWORD":
                Action.Login.password();
                break;
            case "CLICK_LOGIN":
                Action.Login.submit();
                break;
            case "NAVIGATE_TO_HOME":
                Action.Logout.home();
                break;
            case "CLICK_LOGOUT":
                Action.Logout.logout();
                break;
        }
    }
}
