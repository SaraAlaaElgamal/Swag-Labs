package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Utility.stringToFloat;

public class P05_CheckOutOverviewPage {
    //1- Define Web Driver
    WebDriver driver;
    //2- Define Constructor and Initialize the driver
    public P05_CheckOutOverviewPage(WebDriver driver){
        this.driver = driver;
    }
    //3- Define the Locators
    private final By overviewTitle = By.xpath("//div[@class=\"subheader\"]");
    private final By itemTotal = By.xpath("//div[@class=\"summary_info\"]/div[@class=\"summary_subtotal_label\"]");
    private final By tax = By.xpath("//div[@class=\"summary_info\"]/div[@class=\"summary_tax_label\"]");
    private final By total = By.xpath("//div[@class=\"summary_info\"]/div[@class=\"summary_total_label\"]");

    private final By finishBtn = By.xpath("//div[@class=\"cart_footer\"]/a[@class=\"btn_action cart_button\"]");
    //4- Define the Action Methods
    public float getItemTotal() {

        String stringItemTotal = driver.findElement(this.itemTotal).getText().substring(13);
        return stringToFloat(stringItemTotal);
    }
    public float getTax() {

        String stringTax = driver.findElement(this.tax).getText().substring(6);
        return stringToFloat(stringTax);
    }
    public float getTotal() {

        String stringTotal = driver.findElement(this.total).getText().substring(8);
        return stringToFloat(stringTotal);
    }
    public P05_CheckOutOverviewPage clickFinishBtn() {

        driver.findElement(this.finishBtn).click();
        return this;
    }
    public String verifyNavigateToOverviewPage(){
        return driver.findElement(this.overviewTitle).getText();
    }
}
