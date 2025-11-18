package hw18;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ButtonsClickTest extends BaseTest {

    @Test(description = "Click buttons and write info of 4th column")
    public void printInfo() {
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        for (int i = 0; i <3; i++) {
            List<WebElement> buttons = driver.findElements(By.cssSelector("[class*=button]"));
            buttons.get(i).click();
        }

        List<WebElement> lines = driver.findElements(By.xpath("//tbody//tr"));
        List<String> valuesToDisplay = new ArrayList<>();
        for (WebElement line : lines) {
            String text = line.findElements(By.xpath("./td")).get(3).getText();
            valuesToDisplay.add(text);
        }
        System.out.printf("Values: %s", valuesToDisplay);
    }
}
