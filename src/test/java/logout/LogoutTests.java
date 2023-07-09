package logout;

import base.BaseTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.SecureAreaPage;

public class LogoutTests extends BaseTests{

    @Test
    @DisplayName("TC01-Logout Successfully!")
    public void testLogoutSucessfull(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        secureAreaPage = loginPage.clickLogoutButton();
    }

//check not remember acc after logout
    @Test
    @DisplayName("TC01-Remember Account!")
    public void testRememberAccount(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        secureAreaPage = loginPage.clickLogoutButton();
        loginPage.verifyRemember();
    }


}
