package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage {


    private WebDriver driver;
    private By statusAlert = By.xpath("/html/body/div[1]/div[3]/form/section/div/fieldset[1]/div[1]/p[1]/span[2]");
    private By statusAlertGender = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[2]/p/span");
    private By statusAlertDay = By.xpath("/html/body/div[1]/div[3]/form/section/div/fieldset[3]/p[2]/span");
    private By statusAlertYear = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[3]/p[4]/span");

    private By statusAlertBirth = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[3]/p[1]/span");

    private By textCheckS = By.tagName("span");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }

    public String getAlertTextGender() {
        return driver.findElement(statusAlertGender).getText();
    }

    public String getAlertTextDay() {
        return driver.findElement(statusAlertDay).getText();
    }

    public String getAlertTextYear() {
        return driver.findElement(statusAlertYear).getText();
    }

    public String getAlertTextBirth() {
        return driver.findElement(statusAlertBirth).getText();
    }

    public String getTextCheckS() { return driver.findElement(textCheckS).getText();}

    public boolean isDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
