package hw17;

import pages.selenidePages.MainPageSelenide;

import static com.codeborne.selenide.Selenide.open;

public class BaseSelenideTest {
    public MainPageSelenide openMainPage(){
        open("https://the-internet.herokuapp.com");
        return new MainPageSelenide();
    }
}
