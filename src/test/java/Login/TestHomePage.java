package Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestHomePage {
    private WebDriver driver;


    @BeforeClass
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(description = "Go to home page")
    public void goToPage() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("[href*=login]")).click();
        List<WebElement> dataToCheck = driver.findElements(By.cssSelector(".subheader em"));
        String login = dataToCheck.get(0).getText();
        driver.findElement(By.id("username")).sendKeys(login);
        driver.findElement(By.cssSelector("[class*=sign-in]")).click();
        WebElement flesh = driver.findElement(By.id("flash"));
        Assert.assertTrue(flesh.getText().contains("Your password is invalid!"));
    }

    @Test(description = "Check status codes in page")
    public void checkStatusCodes() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
        List<WebElement> listStatusCodes = driver.findElements(By.cssSelector("ul li a"));
        Assert.assertEquals(listStatusCodes.size(), 4);
        List<String> listCodes = new ArrayList<>();
        listStatusCodes.forEach(el ->
                listCodes.add(el.getText())
        );
        Assert.assertTrue(listCodes.containsAll(List.of("200","301","404","500")));
    }

    @AfterClass(alwaysRun = true)
    public void postConditions() {
        driver.quit();
    }
}
