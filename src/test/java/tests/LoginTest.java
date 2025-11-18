package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SecurePage;

public class LoginTest extends BaseTest {
    @Test
    public void successLogin() {
        openMainPage()
                .goToLoginPage()
                .setUserName("tomsmith")
                .setPass("SuperSecretPassword!")
                .clickLogin();

        SecurePage securePage = new SecurePage(driver);
        Assert.assertTrue(securePage.getSecureMessage().contains("You logged into a secure area!"));
    }
}
