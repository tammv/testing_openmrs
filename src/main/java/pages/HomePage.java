package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;

    private By logoutButton = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a");

    private By registerButton = By.xpath("/html/body/div[1]/div[3]/div[3]/div/a[4]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public SecureAreaPage clickRegisterButton(){
        driver.findElement(registerButton).click();
        return new SecureAreaPage(driver);
    }

}
