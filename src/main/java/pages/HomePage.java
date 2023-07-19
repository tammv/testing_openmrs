package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;

    private By logoutButton = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public SecureAreaPage clickLogoutButton(){
        driver.findElement(logoutButton).click();
        return new SecureAreaPage(driver);
    }

//    public void pressEnterKey() {
//        driver.findElement(passwordTxt).sendKeys(Keys.ENTER);
//    }

//    public void clickSelectField() {
//        driver.findElement(selectField).click();
//    }

//    public void pressTab() {
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.TAB).perform();
//    }
//
//    public void pressBack() {
//        driver.navigate().back();
//    }
}
