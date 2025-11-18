package hw13;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HowerAndPrintUserNameTest extends BaseTest {
    private final By imagesToHoverImg = By.cssSelector(".figure img");
    private final By userNameToShow = By.xpath("./following-sibling::div[@class='figcaption']/h5");

    @Test(description = "Print username into console Test")
    public void printName() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<String> userNames = new ArrayList<>();

        for (WebElement el : driver.findElements(imagesToHoverImg)) {
            action.moveToElement(el).perform();
            String val = el.findElement(userNameToShow).getText();
            userNames.add(val);
        }
        Assert.assertEquals(userNames.size(), 3);
        System.out.println(String.format("User names to show: %s", userNames));
    }

}
