package hw18;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private final By loginInput = By.id("username");
    private final By passInput = By.id("password");
    private final By loginData = By.cssSelector(".subheader em");
    private final By loginBtn = By.cssSelector("[class*=sign-in]");
    private final By headerMessage = By.id("flash");

    @BeforeMethod
    public void openLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(description = "Login with valid data")
    public void validLogin() {

        String messageToCheck = "You logged into a secure area!";
        String login = driver.findElements(loginData).get(0).getText();
        String pass = driver.findElements(loginData).get(1).getText();
        login(login, pass);
        Assert.assertTrue(readMessage().contains(messageToCheck));
    }

    @Test(description = "Login with invalid data")
    public void invalidLogin() {
        openLoginPage();
        login("wrong", "wrong");
        Assert.assertTrue(readMessage().contains("Your username is invalid!"));
    }

    private void login(String login, String pass) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passInput).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    private String readMessage() {
        return driver.findElement(headerMessage).getText();
    }
}
