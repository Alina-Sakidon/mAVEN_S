package hw17;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.selenidePages.MainPageSelenide;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileSelenideTest extends BaseSelenideTest {
    private List<String> oldText;

    @Test(description = "Download/upload file success result verification")
    public void fileCheckingTest() {

        Path filePath = openMainPage().goToDownloadPage().downloadFileByLinkText("some-file.txt");
        while (!filePath.toFile().exists()) {
            Selenide.sleep(1000);
        }
        try {
            oldText = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> newList = new ArrayList<>();
        newList = oldText.stream().map(s -> s.concat("word")).toList();
        try {
            Files.write(filePath, newList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String mes = openMainPage().goUploadPage()
                .uploadFile(filePath).getMessage();

        Assert.assertTrue(mes.contains("File Uploaded!"));
    }

}
