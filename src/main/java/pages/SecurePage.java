package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage {

    @FindBy(className = "flash")
    private WebElement secureMess;

    @FindBy(css = "[class*='signout']")
    private WebElement logoutBtn;


    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSecureMessage() {
        return secureMess.getText();
    }

    public void logout() {
        logoutBtn.click();
    }
}
