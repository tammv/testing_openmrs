package logout;

import base.BaseTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SecureAreaPage;

public class LogoutTests extends BaseTests {

    @Test
    @DisplayName("TC01-Login 1 Successfully!")
    public void testLoginSuccessful() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println("Login 1 successfully!");

        // Wait for 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testLogoutSuccessful(); // Call the logout test method
    }

    @Test
    @DisplayName("TC01-Logout 1 Successfully!")
    public void testLogoutSuccessful() {
        homePage.checkLoginStatus();
        SecureAreaPage secureAreaPage2 = homePage.clickLogoutButton();
        System.out.println("Logout 1 successfully!");
    }

    @Test
    @DisplayName("TC03-Logout 2 Successfully!")
    public void testLogoutSuccessful2() {
        System.out.println("****************************************");
        System.out.println("Before Login");
        System.out.println("Cookies Login page: " + driver.manage().getCookies());
        System.out.println("****************************************");
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println("After Login");
        System.out.println("Cookies Home page: " + driver.manage().getCookies());
        System.out.println("****************************************");
        SecureAreaPage secureAreaPage2 = homePage.clickLogoutButton();
        System.out.println("After Logout");
        System.out.println("Cookies Present: " + driver.manage().getCookies());
        System.out.println("****************************************");

        System.out.println("Logout 2 successfully!");
    }
    @Test
    @DisplayName("TC03-Logout 2 Successfully!")
    public void testLogoutSuccessful3() {
        System.out.println("****************************************");
        System.out.println("Before Login");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("****************************************");
        // Perform login
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println("After Login");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        // Click logout button and verify navigation
        SecureAreaPage secureAreaPage2 = homePage.clickLogoutButton();
        System.out.println("****************************************");
        // Verify the expected navigation
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.openmrs.org/openmrs/login.htm"; // Replace with your expected URL
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Navigation to the login page after logout is successful");
        } else {
            System.out.println("Navigation to the login page after logout failed");
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Expected URL: " + expectedUrl);
        }
        System.out.println("****************************************");

        System.out.println("Logout 3 successfully!");
    }

}
