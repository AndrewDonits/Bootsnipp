import Base.BaseFunctions;
import Workflows.Login;
import org.testng.annotations.Test;

public class Sanity extends BaseFunctions {

    @Test
    public void Test01_LoginPage() {
        Login login = new Login();
        login.isLoginPage("Welcome back! Please sign in");
        login.login("email@email.com", "123456");
    }
}
