package pl.gda.wsb.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pl.gda.wsb.PageFactory.DriverFactory;
import pl.gda.wsb.PageFactory.LoginPage;

public class LoginSteps {

    WebDriver driver = null;
    LoginPage loginPage;

    @Given("Open login page")
    public void open_login_page() {
        driver = DriverFactory.getChromeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin31231");
    }

    @When("Clics on login button")
    public void clics_on_login_button() {
        loginPage.clickOnLogin();
    }

    @Then("The validation message is displayed")
    public void the_validation_message_is_displayed() {
        Assert.assertEquals("Invalid credentials", loginPage.getValidationMessage());
        driver.close();
    }
}
