package Base;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;

public class BootsnippUI {

    public LoginPage loginPage;
    public MainPage mainPage;

    BootsnippUI(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.mainPage = new MainPage(driver);
    }

}
