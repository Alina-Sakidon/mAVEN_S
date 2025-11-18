package pages.selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.nio.file.Path;

import static com.codeborne.selenide.Selenide.$;

public class UploadPageSelenide {
    private final SelenideElement uploadInput = $(By.id("file-upload"));
    private final SelenideElement submitBtn = $(By.id("file-submit"));

    public UploadPageSelenide uploadFile(Path path){
        uploadInput.shouldBe(Condition.visible).uploadFile(path.toFile());
        submitBtn.shouldBe(Condition.visible).click();
        return new UploadPageSelenide();
    }

    public String getMessage(){
       return  $(By.cssSelector("[class*='example']")).shouldBe(Condition.visible).getText();
    }
}
