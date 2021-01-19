package pl.gda.wsb.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "txtUsername")
    WebElement txt_username;

    @FindBy(id = "txtPassword")
    WebElement txt_password;

    @FindBy(id = "btnLogin")
    WebElement btn_Login;

    @FindBy(id = "spanMessage")
    WebElement validationMessage;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickOnLogin() {
        btn_Login.click();
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }

}
