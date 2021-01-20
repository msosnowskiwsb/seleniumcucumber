package pl.gda.wsb.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pl.gda.wsb.PageFactory.DriverFactory;
import pl.gda.wsb.PageFactory.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver = DriverFactory.getChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("Open login page")
    public void open_login_page() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
    }

    @When("^User enters invalid credentials (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterCredentials(username,password);
    }

    @When("Clics on login button")
    public void clics_on_login_button() {
        loginPage.clickOnLogin();
    }

    @Then("^The validation (.*) is displayed$")
    public void the_validation_message_is_displayed(String message) {
        Assert.assertEquals(message, loginPage.getValidationMessage());
    }

    @When("The page is loaded")
    public void thePageIsLoaded() {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Then("Logo is visible on login page")
    public void logoIsVisibleOnLoginPage() {
        Assert.assertTrue(loginPage.isLogoDisplayed());
    }
}
