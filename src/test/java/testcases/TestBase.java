package testcases;

import com.github.javafaker.Faker;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.setDriver;

public class TestBase {
    WebDriver driver;
    static Faker faker = new Faker();
    @Parameters("browser")
    @BeforeTest
    public void setupDriver(String browser){
        driver = DriverFactory.getNewInstance(browser);
        setDriver(driver);
        //ToDo: Open the page
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void closeDriver() throws InterruptedException {
        driver.quit();
        Thread.currentThread().interrupt();
    }
}
