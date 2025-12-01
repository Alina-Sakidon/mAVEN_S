package hw17;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import pages.selenidePages.MainPageSelenide;

import static com.codeborne.selenide.Selenide.open;

public class BaseSelenideTest {
    static {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Step("Open main page")
    public MainPageSelenide openMainPage() {
        open("https://the-internet.herokuapp.com");
        return new MainPageSelenide();
    }
}
