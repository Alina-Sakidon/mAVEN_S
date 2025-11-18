package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {
    protected WebDriver driver;
    protected Actions action;
    protected ChromeOptions options;

    @BeforeClass
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();

        options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", Paths.get("target").toFile().getAbsolutePath()); // Use your desired absolute path
        prefs.put("safebrowsing.enabled", false);
        prefs.put("profile.default_content_settings.popups", 1);
        options.setExperimentalOption("prefs", prefs); // or options.addExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public MainPage openMainPage(){
        driver.get("https://the-internet.herokuapp.com");
        return new MainPage(driver);
    }
}
