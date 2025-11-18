package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(css = "[class*='sign-in']")
    private WebElement signInBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
       // wait.until(ExpectedConditions.visibilityOf(name));
    }

    public LoginPage setUserName(String userName) {
        setValue(name, userName);
        return this;
    }

    public LoginPage setPass(String password) {
        setValue(pass, password);
        return this;
    }

    public SecurePage clickLogin() {
        signInBtn.click();
        return new SecurePage(driver);
    }
}
