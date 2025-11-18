package pages.selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.io.File;
import java.nio.file.Path;

import static com.codeborne.selenide.Selenide.$;

public class FileDownloadPage {
    public static Path lastDownloadPath;

    public Path downloadFileByLinkText(String text){
       File file =   findLinkByText(text).shouldBe(Condition.visible).download();
      return    lastDownloadPath = file.toPath().toAbsolutePath();
    }

    private SelenideElement findLinkByText(String text){
       return  $(String.format("a[href*='%s']", text));
    }

}
