package hw13;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropTest extends BaseTest {
    private final By itemToDrag = By.cssSelector("[class*=ui-draggable]");
    private final By itemToDrop = By.cssSelector("[class*=ui-droppable]");


    @Test(description = "Drop item")
    public void dropItem(){
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(itemToDrag), driver.findElement(itemToDrop)).perform();
        Assert.assertTrue(driver.findElement(itemToDrop).getText().contains("Dropped!"));
    }
}
