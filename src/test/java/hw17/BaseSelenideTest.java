package hw17;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import listeners.AllureListener;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import pages.selenidePages.MainPageSelenide;

import static com.codeborne.selenide.Selenide.open;

@Listeners(AllureListener.class)
public class BaseSelenideTest {
    static {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if(!result.isSuccess()){
            attachScreenshot("Failure screenshot");
        }
    }
    @Attachment(value = "{name}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        // Возвращаем скриншот как массив байт для Allure
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Step("Open main page")
    public MainPageSelenide openMainPage() {
        open("https://the-internet.herokuapp.com");
        return new MainPageSelenide();
    }
}
