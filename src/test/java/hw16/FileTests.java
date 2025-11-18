package hw16;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileTests extends BaseTest {
   private List<String> words = List.of("Hello", "my", "name");
   private final Path path = new File("target/selenide-intro.txt").toPath();

    @Test(description = "Download and upload file test")
    public void fileChecking() {
        //((JavascriptExecutor)driver).executeScript("arguments[0].style(display,block)",fileInput );

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("selenide-intro.txt")).click();

        try {
            Files.write(path, words, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.get(" https://the-internet.herokuapp.com/upload");
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(path.toFile().getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        List<WebElement> uploadedElementsToCHeck = driver.findElements(By.xpath("//div[@class='example']/*"));
        List<String> valuesToCheck = uploadedElementsToCHeck.stream().map(WebElement::getText).toList();
        Assert.assertTrue(valuesToCheck.containsAll(List.of("File Uploaded!", "selenide-intro.txt")));
    }
}
