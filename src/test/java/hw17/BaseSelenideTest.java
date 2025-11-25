package hw17;

import com.codeborne.selenide.Configuration;
import pages.selenidePages.MainPageSelenide;

import static com.codeborne.selenide.Selenide.open;

public class BaseSelenideTest {
    static {
        // Настройки Selenide
        Configuration.browser = "chrome";
        Configuration.headless = true;
    }

    public MainPageSelenide openMainPage() {
        open("https://the-internet.herokuapp.com");
        return new MainPageSelenide();
    }
}
