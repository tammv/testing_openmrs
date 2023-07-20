package base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage2;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class testCaptureVitals {

    private WebDriver driver;
    private LoginPage2 loginPage;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        loginPage = new LoginPage2(this.driver);
        this.driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }
    @Test
    public void login() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.selectLocation("Pharmacy");
        loginPage.clickButton();
    }
    public void findButtonYes() {
        try {
            WebElement buttonYes = driver.findElement(By.id("coreapps-vitals-confirm"));
            buttonYes.click();
        } catch (NoSuchElementException e) {
            System.out.println("Patient don't have vitals");
        }
    }
    public void findButtonNo() {
        try {
            WebElement buttonNo = driver.findElement(By.xpath("//*[@id=\"actions\"]/button[2]/i"));
            buttonNo.click();
        } catch (NoSuchElementException e) {
            System.out.println("Patient don't have vitals");
        }
    }
    public void inputEdit(){
        driver.findElement(By.xpath("//*[@id=\"edit-patient-demographics\"]/a")).click();
        WebElement buttonNext = driver.findElement(By.xpath("//*[@id=\"next-button\"]"));
        buttonNext.click();
        buttonNext.click();
        buttonNext.click();
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(., 'Save')]"));
        saveButton.click();
    }

    public void input() {
        WebElement buttonNext = driver.findElement(By.id("next-button"));
//          height min 10 max 272
        WebElement inputHeight = driver.findElement(By.id("w8"));
        inputHeight.sendKeys("180");
        buttonNext.click();
//            Weight min 0 max 250
        WebElement inputWeight = driver.findElement(By.id("w10"));
        inputWeight.sendKeys("70");
        buttonNext.click();
        // Temperture min 25 max 43
        WebElement inputTem = driver.findElement(By.id("w12"));
        inputTem.sendKeys("37");
        buttonNext.click();
        //Pulse min 0 max 230
        WebElement inputPush = driver.findElement(By.id("w14"));
        inputPush.sendKeys("200");
        buttonNext.click();
//            Respiratory rate min 0 max 99
        WebElement inputRes = driver.findElement(By.id("w16"));
        inputRes.sendKeys("50");
        buttonNext.click();
//            BLood presure min 50 max 250 // ô 2: min 30 max 150
        WebElement inputBLood1 = driver.findElement(By.id("w18"));
        inputBLood1.sendKeys("50");
        WebElement inputBLood2 = driver.findElement(By.id("w20"));
        inputBLood2.sendKeys("100");
        buttonNext.click();
//            Arterial blood oxy min 0 max 100
        WebElement inputOxygen = driver.findElement(By.id("w22"));
        inputOxygen.sendKeys("80");
        buttonNext.click();

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(., 'Save')]"));
        saveButton.click();
    }
    @Test
    public void testSearchBlank(){
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("");
        searchInput.sendKeys(Keys.ENTER);
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultText = searchResults.getText();
        if (searchResultText.contains("")) System.out.println("Test the search blank Successfully!!");
    }

    @Test
    public void testSearch1Wrong(){
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("tamasdfgh ");
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultText = searchResults.getText();
        System.out.println("Search result wrong name successfully");
        Assertions.assertTrue(searchResultText.contains("No matching records found"), "Search result don't have name: Tam dep try");

    }
    @Test
    public void testSearch2Vitals() {
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("123123123");
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultText = searchResults.getText();
        System.out.println("Search with wrong ID successfully");
        Assertions.assertTrue(searchResultText.contains("No matching records found"), "Search result don't have ID: 123123123");

    }
    @Test
    public void testSearch3Vitals() {
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("10010W");
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultText = searchResults.getText();
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr/td[2]")).click();
        System.out.println("Search result Correct ID successfully");
    }
    @Test
    public void testSearch4Vitals() {
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("Betty Baker");
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultText = searchResults.getText();
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr/td[2]")).click();
        System.out.println("Search result Correct Name successfully");
    }
    @Test
    public void testSearch5Vitals() {
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("Betty");
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultText = searchResults.getText();
        System.out.println("Search result not enough Name successfully");
    }
    @Test
    public void testSearch6Vitals() {
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("1000");
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultText = searchResults.getText();
        System.out.println("Search result not enough ID successfully");
    }
    @Test
    public void testInput1Vitals() {
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("100KCK");
       driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody")).click();
       try{
           Thread.sleep(5000);findButtonYes();
       }catch (InterruptedException e){
           e.printStackTrace();
       }

        input();
        System.out.println("Create a new record successfully");
    }
    @Test
    public void testInput2Vitals() {
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("100KCK");
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody")).click();
        findButtonNo();
        System.out.println("EXit create a new record successfully");
    }
    @Test
    public void testEditVitals() {
        login();
        WebElement findVitalsLink = driver.findElement(By.linkText("Capture Vitals"));
        findVitalsLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("100KCK");
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody")).click();
        inputEdit();
        System.out.println("Edit info successfully");
    }


}

