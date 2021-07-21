package Workflows;

import Base.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

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

    public void login(Map<String, String> emailsAndPasswords, int numberOfLogins, boolean isRequired, String title) {
        int i = numberOfLogins;
        while (i > 0) {
            boolean isLoginSuccess = false;
            try {
                isLoginPage(title);
                // verify if email and password fields are available
                driverWait.until(ExpectedConditions.elementToBeClickable(bootUI.loginPage.emailField));
                driverWait.until(ExpectedConditions.elementToBeClickable(bootUI.loginPage.passwordField));

                // Setting next email in the hash map
                bootUI.loginPage.emailField.clear();
                String email = emailsAndPasswords.keySet().toArray()[0].toString();
                bootUI.loginPage.emailField.sendKeys(email);
                System.out.println("Report: inserted the following email successfully: " + email);

                // Setting next password in the hash map
                bootUI.loginPage.passwordField.clear();
                String password = emailsAndPasswords.values().toArray()[0].toString();
                bootUI.loginPage.passwordField.sendKeys(password);
                System.out.println("Report: inserted the following email successfully: " + password);

                // Sign in
                driverWait.until(ExpectedConditions.elementToBeClickable(bootUI.loginPage.signInButton));
                bootUI.loginPage.signInButton.click();

                // verify login passed
                driverWait.until(ExpectedConditions.elementToBeClickable(bootUI.mainPage.createNewSnippets));
                isLoginSuccess = true;
            } catch (Exception e) {
                System.out.println("Couldn't pass login page successfully, see error: " + e.getMessage());
                if (isRequired) Assert.fail();
            } finally {
                if (isLoginSuccess) {
                    driverWait.until(ExpectedConditions.elementToBeClickable(
                            bootUI.mainPage.profileClosed.findElement(By.tagName("a")))).click();

                    driverWait.until(ExpectedConditions.elementToBeClickable(
                            bootUI.mainPage.profileOpen.findElement(By.tagName("ul")).findElement(
                                    By.xpath("//a[@href='https://bootsnipp.com/logout']")))).click();

                    driverWait.until(ExpectedConditions.elementToBeClickable(bootUI.loginPage.loginHeaderButton)).click();
                }
            }

            i--;
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

            driverWait.until(ExpectedConditions.elementToBeClickable(bootUI.loginPage.signInButton));
            bootUI.loginPage.signInButton.click();
        } catch (Exception e) {
            System.out.println("Couldn't insert email or password in login page, see error: " + e.getMessage());
            Assert.fail();
        }
    }

    public HashMap<String, String> getListOfEmails() {
        HashMap<String, String> emailsAndPasswords = new HashMap<String, String>();

        emailsAndPasswords.put("andonits5@gmail.com", "M@ymBHi2#ANshnX");
//        emailsAndPasswords.put("andonits1@gmail.com", "M@ymBHi2#ANshnX");
//        emailsAndPasswords.put("andonits2@gmail.com", "M@ymBHi2#ANshnX");
//        emailsAndPasswords.put("andonits3@gmail.com", "M@ymBHi2#ANshnX");
//        emailsAndPasswords.put("andonits4@gmail.com", "M@ymBHi2#ANshnX");
//        emailsAndPasswords.put("andonits6@gmail.com", "M@ymBHi2#ANshnX");
//        emailsAndPasswords.put("andonits7@gmail.com", "M@ymBHi2#ANshnX");
//        emailsAndPasswords.put("andonits8@gmail.com", "M@ymBHi2#ANshnX");

        return emailsAndPasswords;

    }
}
