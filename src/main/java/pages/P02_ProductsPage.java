package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static util.Utility.*;

public class P02_ProductsPage {
    //1- Define Web Driver
    WebDriver driver;
    //2- Define Constructor and Initialize the driver
    public P02_ProductsPage(WebDriver driver){
        this.driver = driver;
    }
    //3- Define the Locators
    private final By addToCart = By.xpath("//div[@class=\"inventory_list\"]/div[1]/div[3]/button[@class=\"btn_primary btn_inventory\"]");
    private final By price = By.xpath ("//div[@class=\"inventory_list\"]/div[1]/div[3]/div[@class=\"inventory_item_price\"]");
    private final By cart = By.id("shopping_cart_container");
    private final By productTitle = By.xpath("//div[@class=\"product_label\"]");
    private final By removeBtn = By.xpath("//div[@class=\"inventory_list\"]/div[1]/div[3]/button[@class=\"btn_secondary btn_inventory\"]");
    private final By numOfProducts = By.xpath("//span[@class=\"fa-layers-counter shopping_cart_badge\"]");
    //4- Define the Action Methods
    public float addElementsToCart(int noOfItems) {
        float totalPrice = 0;
        for (int index = 1; index <= noOfItems ; index++) {
            driver.findElement(By.xpath("//div[@class=\"inventory_list\"]/div[" + index + "]/div[3]/button[@class=\"btn_primary btn_inventory\"]")).click();
            totalPrice += getPrice(index);
        }
        return totalPrice;
    }
    public float addRandomElementsToCart(List<Integer> index,int max,int noOfItems) {
        float totalPrice = 0;
        for (int i = 0 ; i < noOfItems; i++) {
            driver.findElement(By.xpath("//div[@class=\"inventory_list\"]/div[" + index.get(i) + "]/div[3]/button[@class=\"btn_primary btn_inventory\"]")).click();
            totalPrice += getPrice(index.get(i));
            System.out.println("Add Item No "+index.get(i));
        }
        return totalPrice;
    }
    public float removeRandomElements (List<Integer> index,float totalPrice,int randomIndex) {
            System.out.println("Delete Item No "+randomIndex);
            driver.findElement(By.xpath("//div[@class=\"inventory_list\"]/div[" + index.get(randomIndex-1) + "]/div[3]/button[@class=\"btn_secondary btn_inventory\"]")).click();
            totalPrice -= getPrice(index.get(randomIndex-1));
            System.out.println("After remove item the total price is "+totalPrice);
        return totalPrice;
    }
    public float getPrice(int index) {

        String stPrice = driver.findElement(By.xpath("//div[@class=\"inventory_list\"]/div[" + index + "]/div[3]/div[@class=\"inventory_item_price\"]")).getText();
        return stringToFloat(stPrice.substring(1));
    }
    public P02_ProductsPage clickCartIcon() {

        driver.findElement(this.cart).click();
        return this;
    }
    public Boolean validateLoginSuccessfully(){
        return driver.findElement(this.productTitle).getText().equals("Products");
    }
    public Boolean validateAddToCartSuccessfully(int max){
        return driver.findElement(this.numOfProducts).getText().equals(String.valueOf(max));
    }
}
