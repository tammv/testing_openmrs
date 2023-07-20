package register;

import base.BaseTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SecureAreaPage;

public class RegisterTests extends BaseTests {

    @Test
    @DisplayName("TC01-Register 1 Successfully!")
    public void testRegisterSucessfull() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        registerPage.setgivenName("Ngoc Thanh");
        registerPage.setmiddleName("Ngoc");
        registerPage.setfamilyName("Vo");
        registerPage.clickNextButton();
        registerPage.clickGenderButton();
        registerPage.clickNextButton();
        registerPage.setDay("20");
        registerPage.selectMonth("October");
        registerPage.setYear("2002");
        registerPage.clickNextButton();
        registerPage.setAddress("Da Nang");
        registerPage.clickNextButton();
        registerPage.setPhone("0833763962");
        registerPage.clickNextButton();
        registerPage.clickNextButton();
        registerPage.clickConfirmButton();
    }

    @Test
    @DisplayName("TC02-Register Leave name blank!")
    public void testRegister01() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        SecureAreaPage secureAreaPage3 = registerPage.clickNextButton();
        String alertText = secureAreaPage3.getAlertText();
        Assertions.assertTrue(alertText.contains("Required"), "Required");
    }

    @Test
    @DisplayName("TC02-Register Verify Name by number")
    public void testRegister02() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        registerPage.setgivenName("123");
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid name"), "Invalid name");
        System.out.println("fail");
    }

    @Test
    @DisplayName("TC03-Register Verify without selecting gender")
    public void testRegister03() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        registerPage.setgivenName("Ngoc Thanh");
        registerPage.setmiddleName("Ngoc");
        registerPage.setfamilyName("Vo");
        registerPage.clickNextButton();
        SecureAreaPage secureAreaPage3 = registerPage.clickNextButton();
        String alertTextt = secureAreaPage3.getAlertTextGender();
        Assertions.assertTrue(alertTextt.contains("Required"), "Required");
    }

    @Test
    @DisplayName("TC04-Verify the date of birth in letters")
    public void testRegister04() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        registerPage.setgivenName("Ngoc Thanh");
        registerPage.setmiddleName("Ngoc");
        registerPage.setfamilyName("Vo");
        registerPage.clickNextButton();
        registerPage.clickGenderButton();
        registerPage.clickNextButton();
        registerPage.setDay("abc");
        SecureAreaPage secureAreaPage3 = registerPage.clickNextButton();
        String alertTextt = secureAreaPage3.getAlertTextDay();
        Assertions.assertTrue(alertTextt.contains("Must be a number"), "Must be a number");
    }

    @Test
    @DisplayName("TC05-Verify the date of birth in letters")
    public void testRegister05() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        registerPage.setgivenName("Ngoc Thanh");
        registerPage.setmiddleName("Ngoc");
        registerPage.setfamilyName("Vo");
        registerPage.clickNextButton();
        registerPage.clickGenderButton();
        registerPage.clickNextButton();
        registerPage.setDay("20");
        registerPage.selectMonth("October");
        registerPage.setYear("abc");
        SecureAreaPage secureAreaPage3 = registerPage.clickNextButton();
        String alertTextt = secureAreaPage3.getAlertTextYear();
        Assertions.assertTrue(alertTextt.contains("Must be a number"), "Must be a number");
    }

    @Test
    @DisplayName("TC06-Verify without entering date of birth")
    public void testRegister06() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        registerPage.setgivenName("Ngoc Thanh");
        registerPage.setmiddleName("Ngoc");
        registerPage.setfamilyName("Vo");
        registerPage.clickNextButton();
        registerPage.clickGenderButton();
        registerPage.clickNextButton();
        SecureAreaPage secureAreaPage3 = registerPage.clickNextButton();
        String alertTextt = secureAreaPage3.getAlertTextBirth();
        Assertions.assertTrue(alertTextt.contains("Required"), "Required");
    }

    @Test
    @DisplayName("TC07-Verify input year of birth is equal to 1")
    public void testRegister07() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        registerPage.setgivenName("Ngoc Thanh");
        registerPage.setmiddleName("Ngoc");
        registerPage.setfamilyName("Vo");
        registerPage.clickNextButton();
        registerPage.clickGenderButton();
        registerPage.clickNextButton();
        registerPage.setDay("20");
        registerPage.selectMonth("October");
        registerPage.setYear("1");
        SecureAreaPage secureAreaPage3 = registerPage.clickNextButton();
        String alertTextt = secureAreaPage3.getAlertTextYear();
        Assertions.assertTrue(alertTextt.contains("Minimum: 1903"), "Minimum: 1903");
    }

    @Test
    @DisplayName("TC08-Verify February input verification has 30 days")
    public void testRegister08() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        registerPage.setgivenName("Ngoc Thanh");
        registerPage.setmiddleName("Ngoc");
        registerPage.setfamilyName("Vo");
        registerPage.clickNextButton();
        registerPage.clickGenderButton();
        registerPage.clickNextButton();
        registerPage.setDay("30");
        registerPage.selectMonth("February");
        registerPage.setYear("2002");
        SecureAreaPage secureAreaPage3 = registerPage.clickNextButton();
        String alertTextt = secureAreaPage3.getAlertTextBirth();
        Assertions.assertTrue(alertTextt.contains("There are only 28 days in february for the specified year"), "There are only 28 days in february for the specified year");
    }

    @Test
    @DisplayName("TC09-Verify February input validation has 29 days for non-leap year")
    public void testRegister09() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage2 = homePage.clickRegisterButton();
        registerPage.setgivenName("Ngoc Thanh");
        registerPage.setmiddleName("Ngoc");
        registerPage.setfamilyName("Vo");
        registerPage.clickNextButton();
        registerPage.clickGenderButton();
        registerPage.clickNextButton();
        registerPage.setDay("29");
        registerPage.selectMonth("February");
        registerPage.setYear("2002");
        SecureAreaPage secureAreaPage3 = registerPage.clickNextButton();
        String alertTextt = secureAreaPage3.getAlertTextBirth();
        Assertions.assertTrue(alertTextt.contains("There are only 28 days in february for the specified year"), "There are only 28 days in february for the specified year");
    }
}

