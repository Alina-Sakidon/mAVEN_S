package hw13;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {
    private final By firstDropdown = By.xpath("//a[text()[contains(., 'Dropdown')]]");
    private final By secondDropdown = By.xpath("//a[text()[contains(., 'Secondary Menu')]]");
    private final By secondaryActionLink = By.linkText("Secondary Action");
    private final By secondaryPageText = By.cssSelector("[class*=secondary-clicked]");

    @Test
    public void selectFromDropdownTest(){
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(firstDropdown)).moveToElement(driver.findElement(secondDropdown)).build().perform();
        driver.findElement(secondaryActionLink).click();

        Assert.assertTrue(driver.findElement(secondaryPageText).getText().contains("Secondary action in the menu was clicked successfully!"));
    }
}
