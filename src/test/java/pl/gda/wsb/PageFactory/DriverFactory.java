package pl.gda.wsb.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {
        // instancja
    }

    @BeforeSuite
    public static WebDriver getChromeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().fullscreen();
        }
        return driver;
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
    }
}
