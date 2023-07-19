package logout;

import base.BaseTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SecureAreaPage;


public class LogoutTests extends BaseTests {

    @Test
    @DisplayName("TC01-Logout 1 Successfully!")
    public void testLogoutSucessfull(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickLogoutButton();
        System.out.println("Logout 1 successfully!");
    }



}
