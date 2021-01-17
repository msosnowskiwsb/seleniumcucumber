package pl.gda.wsb.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver = null;

    @Given("Open login page")
    public void open_login_page() {

        // Declaration and instantiation of driver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin321321");
    }

    @When("Clics on login button")
    public void clics_on_login_button() {
        driver.findElement(By.id("btnLogin")).click();
    }

    @Then("The validation message is displayed")
    public void the_validation_message_is_displayed() {
        String validation_message = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals("Invalid credentials", validation_message);
    }
}
