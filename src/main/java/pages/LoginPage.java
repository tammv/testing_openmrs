package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    private WebDriver driver;
    private By userNameTxt = By.name("username");
    private By passwordTxt = By.name("password");
    private By loginButton = By.xpath("//*[@id=\"loginButton\"]");

    private By selectField = By.xpath("//*[@id=\"Inpatient Ward\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(String userName){
        driver.findElement(userNameTxt).sendKeys(userName);
    }
    public void setPassword(String password){
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public void clickSelectField() {
        driver.findElement(selectField).click();
    }

}
