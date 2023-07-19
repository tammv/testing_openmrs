package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
