package Workflows;

import Base.BaseFunctions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Login extends BaseFunctions {

    public Login() {

    }

    public void isLoginPage(String title) {
        try {
            driverWait.until(ExpectedConditions.visibilityOf(bootUI.loginPage.signInTitle));
            driverWait.until(ExpectedConditions.textToBePresentInElement(bootUI.loginPage.signInTitle, title));
            System.out.println("Report: login page loaded successfully!");
        } catch (Exception e) {
            System.out.println("Couldn't load login page, see error: " + e.getMessage());
            Assert.fail();
        }
    }

    public void login(String email, String password) {
        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(bootUI.loginPage.emailField));
            driverWait.until(ExpectedConditions.elementToBeClickable(bootUI.loginPage.passwordField));
            bootUI.loginPage.emailField.sendKeys(email);
            System.out.println("Report: inserted the following email successfully: " + email);
            bootUI.loginPage.passwordField.sendKeys(password);
            System.out.println("Report: inserted the following email successfully: " + password);
        } catch (Exception e) {
            System.out.println("Couldn't insert email or password in login page, see error: " + e.getMessage());
            Assert.fail();
        }
    }
}
