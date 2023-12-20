package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    //1- Define Web Driver
    WebDriver driver;
    //2- Define Constructor and Initialize the driver
    public P01_LoginPage(WebDriver driver){
        this.driver = driver;
    }
    //3- Define the Locators
    private final By email = By.id("user-name");
    private final By password = By.id ("password");
    private final By loginBtn = By.id("login-button");
    //4- Define the Action Methods
    public P01_LoginPage enterEmail(String email) {

        driver.findElement(this.email).sendKeys(email);
        return this;
    }
    public P01_LoginPage enterPassword(String password) {

        driver.findElement(this.password).sendKeys(password);
        return this;
    }
    public P01_LoginPage clickLoginBtn() {

        driver.findElement(this.loginBtn).click();
        return this;
    }
}
