package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import pages.LoginPage;
import pages.SecureAreaPage;


public class LoginTests extends BaseTests {

    @Test
    @DisplayName("TC01-Login Successfully!")
    public void testLoginSucessfull(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("TC02-Login Failed!")
    public void testLoginFail1(){
        loginPage.setUserName("");
        loginPage.setPassword("");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }

    @Test
    @DisplayName("TC03-Login Failed!")
    public void testLoginFail2(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("IncorrectPass");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }

    @Test
    @DisplayName("TC04-Login Failed!")
    public void testLoginFail3(){
        loginPage.setUserName("IncorrectUsn");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }

    @Test
    @DisplayName("TC05-Login Failed!")
    public void testLoginFail4(){
        loginPage.setUserName("");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }


    @Test
    @DisplayName("TC06-Login Failed!")
    public void testLoginFail5(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }

    //Pressing 'Tab'
    @Test
    @DisplayName("TC07-Login Successfully!")
    public void testLoginSucessfull2(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.pressTab();
//      SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        loginPage.pressEnterKey();
    }


    //Pressing back button doesn’t log out the user
    @Test
    @DisplayName("TC08-Login Successfully!")
    public void testLoginSucessfull3(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String textCheckS = secureAreaPage.getTextCheckS();
        Assertions.assertTrue(textCheckS.contains("Logged in as Super User (admin) at Inpatient Ward."), "Test check");
        loginPage.pressBack();
        Assertions.assertTrue(textCheckS.contains("Logged in as Super User (admin) at Inpatient Ward."), "Test check");
    }

    //pressing the 'Enter' key on the login page
    @Test
    @DisplayName("TC10-Login Successfully!")
    public void testLoginSucessfull5(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        loginPage.pressEnterKey();
    }


    //click eye icon display password
    @Test
    @DisplayName("TC09-Login Successfully!")
    public void testLoginSucessfull4(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickEyeIcon();
        SecureAreaPage secureAreaPage = new SecureAreaPage();
        String checkEye = secureAreaPage.getcheckEye();
        Assertions.assertTrue(checkEye.contains("Admin123"), "True");
    }





//    @Test
//    @DisplayName("Verify concurrent login with same credentials")
//    public void testConcurrentLogin() {
//        WebDriver driver1 = new ChromeDriver();
//        WebDriver driver2 = new OperaDriver();
//
//        LoginPage loginPage1 = new LoginPage(driver1);
//        LoginPage loginPage2 = new LoginPage(driver2);
//
//        driver1.get("https://opensource-demo.orangehrmlive.com/web/auth/login");
//        driver2.get("https://opensource-demo.orangehrmlive.com/web/auth/login");
//
//        loginPage1.setUserName("Admin");
//        loginPage1.setPassword("admin123");
//        SecureAreaPage secureAreaPage1 = loginPage1.clickLoginButton();
//
//
//        loginPage2.setUserName("Admin");
//        loginPage2.setPassword("admin123");
//        SecureAreaPage secureAreaPage2 = loginPage2.clickLoginButton();
//
//
//        Assertions.assertTrue(secureAreaPage1.isDisplayed(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")), "User is not logged in on browser 1");
//        Assertions.assertTrue(secureAreaPage2.isDisplayed(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")), "User is not logged in on browser 2");
//
//        driver1.quit();
//        driver2.quit();
//    }


}
