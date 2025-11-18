package pages.selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPageSelenide {
    private final SelenideElement fileDownloadLink = $(By.linkText("File Download"));
    private final SelenideElement uploadFileLink = $(By.linkText("File Upload"));
    private final SelenideElement dynamicControlLink = $(By.linkText("Dynamic Controls"));

    public FileDownloadPage goToDownloadPage(){
        fileDownloadLink.shouldBe(Condition.visible).click();
        return new FileDownloadPage();
    }
    public UploadPageSelenide goUploadPage(){
        uploadFileLink.shouldBe(Condition.visible).click();
        return new UploadPageSelenide();
    }

    public DynamicControlsSelenidePage goToDynamicPage(){
        dynamicControlLink.shouldBe(Condition.visible).click();
        return new DynamicControlsSelenidePage();
    }
}
