package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManagePages {
    public ManagePages(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
