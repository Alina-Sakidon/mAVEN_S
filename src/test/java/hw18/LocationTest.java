package hw18;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LocationTest extends BaseTest {
    private final By geoBtn = By.cssSelector("[onclick='getLocation()']");
    private final By latitude = By.id("lat-value");
    private final By longitude = By.id("long-value");
    private List<String> values = new ArrayList<>();


    @Test(description = "Read geolocation")
    public void findGeolocation() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(geoBtn).click();
        readGeoValues();
        Assert.assertEquals(values.size(), 2);
        System.out.println(String.format("Your location is ->>> latitude: %s, longitude: %s ", values.get(0), values.get(1)));
    }

    private List<String> readGeoValues() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement latEl = wait.until(ExpectedConditions.visibilityOfElementLocated(latitude));
            WebElement lonEl = wait.until(ExpectedConditions.visibilityOfElementLocated(longitude));

            values.add(latEl.getText());
            values.add(lonEl.getText());
        } catch (TimeoutException e) {
            Assert.fail("Duration of waiting wor greater then expected");
        }
        return values;
    }
}
