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

import static org.junit.jupiter.api.Assertions.assertEquals;


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

    //click eye icon display password
    @Test
    @DisplayName("TC09-Login Successfully!")
    public void testLoginSucessfull4(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickEyeIcon();
        String displayedPassword = loginPage.getcheckEye();
        String expectedPassword  = "Admin123";
        assertEquals(displayedPassword, expectedPassword);
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





}
