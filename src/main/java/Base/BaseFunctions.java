package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseFunctions {

    public static WebDriver driver;
    public static WebDriverWait driverWait;
    public static Actions action;
    public static String URL = "https://bootsnipp.com/login";
    public static BootsnippUI bootUI;

    /**
     * כאן את יכולה לשים כל מיני דברים שאת רוצה שירוצו לפני כל הטסטים
     * לא בטוח שחובה לטסטים שאת עושה במבחן הזה
     */
    @BeforeClass
    public void beforeClass() {

    }

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/andon/IdeaProjects/Bootsnipp/src/main/Configuration/chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driverWait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        bootUI = new BootsnippUI(driver);
    }

    /**
     * כאן את יכולה לשים כל מיני דברים שאת רוצה שירוצו אחרי כל טסט
     * לא בטוח שחובה לטסטים שאת עושה במבחן הזה
     */
    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
