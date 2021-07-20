package PageObjects;

import Base.ManagePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ManagePages {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[@class='sign-up-title']")
    public WebElement signInTitle;

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;



}
