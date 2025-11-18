package hw14;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private final By startBtn = By.xpath("//button[contains(text(), 'Start')]");
    private final By helloMesField = By.xpath("//div[@id='finish']");

    @BeforeMethod
    public void precondition() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test
    public void checkMessage() {
        driver.findElement(startBtn).click();
        String mes = wait.until(ExpectedConditions.visibilityOf(driver.findElement(helloMesField))).getText();
        System.out.println(String.format("Value to print: %s", mes));
    }

    @Test(description = "Print text from page using custom expected condition")
    public void printAndCheckMes() {
        driver.findElement(startBtn).click();
        System.out.println(String.format("Value to print: %s", wait.until(visibilityOfMessage()).getText()));
    }

    private ExpectedCondition<WebElement> visibilityOfMessage() {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver input) {
                WebElement el = wait.until(ExpectedConditions.visibilityOf(driver.findElement(helloMesField)));
                return el.findElement(By.tagName("h4"));
            }
        };
    }
}
