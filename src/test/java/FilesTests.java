import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FilesTests extends BaseTest {
    @Test(description = "upload file")
    public void uploadFile() {
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement fileToUploadInput = driver.findElement(By.className("upload_txt"));
        fileToUploadInput.sendKeys(new File("C:\\Users\\PC\\IdeaProjects\\mAVEN_S\\temp1.txt").getAbsolutePath());
        driver.findElement(By.cssSelector("[name='send']")).click();
        String mes = driver.findElement(By.xpath("//h3[@id='res']")).getText();

        Assert.assertTrue(mes.replaceAll("\n", " ").trim().contains("1 file has been successfully uploaded."));
    }
}
