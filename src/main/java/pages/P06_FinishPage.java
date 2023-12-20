package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_FinishPage {
    //1- Define Web Driver
    WebDriver driver;
    //2- Define Constructor and Initialize the driver
    public P06_FinishPage(WebDriver driver){
        this.driver = driver;
    }
    //3- Define the Locators
    private final By thankYouText = By.xpath("//h2[@class=\"complete-header\"]");
    //4- Define the Action Methods
    public Boolean verifyOrderCompletedSuccessfully (){
        return driver.findElement(this.thankYouText).getText().equals("THANK YOU FOR YOUR ORDER");
    }
}
