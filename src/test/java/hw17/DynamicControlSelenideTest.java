package hw17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.selenidePages.DynamicControlsSelenidePage;

public class DynamicControlSelenideTest extends BaseSelenideTest {
    @Test
    public void dynamicControlTest() {
        DynamicControlsSelenidePage dynamicControlsSelenidePage = new DynamicControlsSelenidePage();
        openMainPage().goToDynamicPage().removeCheckbox(true);

        Assert.assertTrue(dynamicControlsSelenidePage.checkMessage().contains("It's gone!"));
    }
}
