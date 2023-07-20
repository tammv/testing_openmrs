package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class RegisterPage {
    private WebDriver driver;
    //name
    private By givenTxt = By.name("givenName");
    private By middleNameTxt = By.name("middleName");
    private By familyNameTxt = By.name("familyName");
    //gender
    private By genderButton = By.xpath("/html/body/div/div[3]/form/section/div/fieldset[2]/p/select/option[1]");
    //date of birth
    private By dayTxt = By.name("birthdateDay");
    private By selectMonth = By.name("birthdateMonth");
    private By yearTxt = By.name("birthdateYear");
    //address
    private By addressTxt = By.xpath("/html/body/div/div[3]/form/section[2]/div/fieldset[1]/p[2]/input");
    //phone
    private By phoneTxt = By.xpath("/html/body/div/div[3]/form/section[2]/div/fieldset[2]/p/input");
    //confirm
    private By confirmButton = By.xpath("/html/body/div/div[3]/form/div[1]/div[5]/p[1]/input");

    private By nextButton = By.xpath("//*[@id=\"next-button\"]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setgivenName(String givenName) {
        driver.findElement(givenTxt).sendKeys(givenName);
    }

    public void setmiddleName(String middleName) {
        driver.findElement(middleNameTxt).sendKeys(middleName);
    }

    public void setfamilyName(String familyName) {
        driver.findElement(familyNameTxt).sendKeys(familyName);
    }

    public void setDay(String day) {
        driver.findElement(dayTxt).sendKeys(day);
    }

    public void setAddress(String address) {
        driver.findElement(addressTxt).sendKeys(address);
    }

    public void setPhone(String phone) {
        driver.findElement(phoneTxt).sendKeys(phone);
    }

    public void selectMonth(String month) {
        WebElement selectMonthElement = driver.findElement(selectMonth);
        Select select = new Select(selectMonthElement);
        select.selectByVisibleText(month);
    }
 
    public void setYear(String year) {
        driver.findElement(yearTxt).sendKeys(year);
    }

    public SecureAreaPage clickGenderButton() {
        driver.findElement(genderButton).click();
        return new SecureAreaPage(driver);
    }

    public SecureAreaPage clickNextButton() {
        driver.findElement(nextButton).click();
        return new SecureAreaPage(driver);
    }

    public SecureAreaPage clickConfirmButton() {
        driver.findElement(confirmButton).click();
        return new SecureAreaPage(driver);
    }

}
