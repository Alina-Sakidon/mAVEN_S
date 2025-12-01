package pages.selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DynamicControlsSelenidePage extends MainPageSelenide {
    private final SelenideElement removeAddCheckbox = $("input[type=checkbox]");
    private final SelenideElement removeBtn = $("[onclick='swapCheckbox()']");
    private final SelenideElement message = $("p[id*=message]");

   @Step("Click checkbox: {remove}")
    public void removeCheckbox(Boolean remove) {
        if (remove == true) {
            removeBtn.shouldBe(Condition.visible).click();
            removeAddCheckbox.shouldNotBe(Condition.visible);
        }
    }

    @Step("Check message")
    public String checkMessage() {
        return message.shouldBe(Condition.visible).getText();
    }
}
