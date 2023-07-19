package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;
    private By statusLogin = By.xpath("//*[@id='content']/div[2]/div/h4");
    private By logoutButton = By.xpath("//*[@id='navbarSupportedContent']/ul/li[3]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SecureAreaPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new SecureAreaPage(driver);
    }

    public void checkLoginStatus() {
        WebElement statusElement = driver.findElement(statusLogin);
        String statusText = statusElement.getText();
        if (statusText.contains("Logged in as Super User (admin)")) {
            System.out.println("Logged in as Super User (admin)");
        }
    }
}
