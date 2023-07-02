package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage {


    private WebDriver driver;
    private By statusAlert = By.xpath("//*[@id=\"error-message\"]");
    private By textCheckS = By.tagName("h4");
    private By checkEye = By.name("password");


    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public SecureAreaPage() {
    }

    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }
    public String getTextCheckS() { return driver.findElement(textCheckS).getText();}
    public String getcheckEye() {return driver.findElement(checkEye).getText();}

    public boolean isDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
