import Base.BaseFunctions;
import Workflows.Login;
import org.testng.annotations.Test;

import java.util.HashMap;


public class LoginSanity extends BaseFunctions {

    Login loginPage = new Login();

    @Test
    public void Test01_LoginPage() {
        loginPage.isLoginPage("Welcome back! Please sign in");
        loginPage.login("email@email.com", "123456");
    }

    @Test
    public void Test01_LoginPageWithManyUsers() {
        HashMap<String, String> users = loginPage.getListOfEmails();
        loginPage.login(users, 5, false, "Welcome back! Please sign in");
    }
}
