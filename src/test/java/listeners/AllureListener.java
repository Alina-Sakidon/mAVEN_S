package listeners;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot("Failed: " + result.getName());
    }

    @Attachment(value = "{name}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
