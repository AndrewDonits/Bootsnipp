package Base;

import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class BootsnippUI {

    public LoginPage loginPage;

    BootsnippUI(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

}
