package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(linkText = "Form Authentication")
    WebElement loginPageLinc;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public LoginPage goToLoginPage(){
        loginPageLinc.click();
        return new LoginPage(driver);
    }

    public MainPage openMainPage(){
        driver.get("https://the-internet.herokuapp.com");
        return new MainPage(driver);
    }

}
