package hw17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.selenidePages.DynamicControlsSelenidePage;

public class DynamicControlSelenideTest extends BaseSelenideTest {
    @Test(description = "Dynamic Controls check message invalid data")
    public void dynamicControlInvalidTest() {
        DynamicControlsSelenidePage dynamicControlsSelenidePage = new DynamicControlsSelenidePage();
        openMainPage().goToDynamicPage().removeCheckbox(true);

        Assert.assertTrue(dynamicControlsSelenidePage.checkMessage().contains("123"));
    }

    @Test(description = "Dynamic Controls check message invalid data")
    public void dynamicControlValidTest() {
        DynamicControlsSelenidePage dynamicControlsSelenidePage = new DynamicControlsSelenidePage();
        openMainPage().goToDynamicPage().removeCheckbox(true);

        Assert.assertTrue(dynamicControlsSelenidePage.checkMessage().contains("It's gone!"));
    }
}
