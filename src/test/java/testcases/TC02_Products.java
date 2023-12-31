package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.List;

import static util.Utility.generateNonRepeatingRandomNumbers;
import static util.Utility.generateRandomInt;

public class TC02_Products extends TestBase{
    //Declaration
    String email = "standard_user";
    String password = "secret_sauce";
    int max = 6;
    int  noOfItems = generateRandomInt(max);
    List<Integer> index = generateNonRepeatingRandomNumbers(max,noOfItems);
    int randomIndex = generateRandomInt(noOfItems);
    //int index = 1;
    float totalPrice = 0;
    float updatedTotalPrice = 0;
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String zipCode = faker.number().digits(5);
    float itemTotal;
    float totalTax;
    float total;
    //Test Cases
    @Test(priority = 1, description = "Add Products To Cart")
    public void AddProductsToCart_P() throws InterruptedException {
        noOfItems = 6;
        new P01_LoginPage(driver).enterEmail(email).enterPassword(password).clickLoginBtn();
        //ToDo: Check if Login successfully
        Assert.assertTrue(new P02_ProductsPage(driver).validateLoginSuccessfully());
        totalPrice = new P02_ProductsPage(driver).addElementsToCart(max);
        System.out.println(totalPrice);
        //ToDo: Check items added to cart successfully
        Assert.assertTrue(new P02_ProductsPage(driver).validateAddToCartSuccessfully(noOfItems));
        new P02_ProductsPage(driver).clickCartIcon();
        //ToDo: Check navigate to My Cart Page Successfully
        Thread.sleep(3000);
        Assert.assertEquals(new P03_CartPage(driver).verifyNavigateToMyCartsPage(),"Your Cart");
        new P03_CartPage(driver).clickCheckOutBtn();
        //ToDo: Check navigate to Information Page Successfully
        Thread.sleep(3000);
        Assert.assertEquals(new P04_CheckOutInformationPage(driver).verifyNavigateToInformationPage(),"Checkout: Your Information");
        new P04_CheckOutInformationPage(driver).enterFirstName(firstName).enterLastName(lastName).enterZipCode(zipCode).clickContinueBtn();
        //ToDo: Check navigate to Overview Page Successfully
        Thread.sleep(3000);
        Assert.assertEquals(new P05_CheckOutOverviewPage(driver).verifyNavigateToOverviewPage(),"Checkout: Overview");
        itemTotal = new P05_CheckOutOverviewPage(driver).getItemTotal();
        System.out.println(itemTotal);
        totalTax = new P05_CheckOutOverviewPage(driver).getTax();
        System.out.println(totalTax);
        total = new P05_CheckOutOverviewPage(driver).getTotal();
        System.out.println(total);
        //ToDo: Check the Total value is the same as the total summed
        Assert.assertEquals((itemTotal+totalTax),total);
        Assert.assertEquals(itemTotal,totalPrice);
        new P05_CheckOutOverviewPage(driver).clickFinishBtn();
        //ToDo: Check the order has been completed successfully
        Thread.sleep(3000);
        Assert.assertTrue(new P06_FinishPage(driver).verifyOrderCompletedSuccessfully());
        Thread.sleep(3000);
        //SoftAssert softAssert = new SoftAssert();
        //softAssert.assertTrue(bool);
        //softAssert.assertAll();
    }
    @Test(priority = 2, description = "Add Random Products To Cart")
    public void AddRandomProductsToCart_P() throws InterruptedException {
        System.out.println("Number of Items is " +noOfItems);
        new P01_LoginPage(driver).enterEmail(email).enterPassword(password).clickLoginBtn();
        //ToDo: Check if Login successfully
        Assert.assertTrue(new P02_ProductsPage(driver).validateLoginSuccessfully());
        totalPrice = new P02_ProductsPage(driver).addRandomElementsToCart(index,max,noOfItems);
        System.out.println("Total Price calculated from products page = "+totalPrice);
        //ToDo: Check items added to cart successfully
        Assert.assertTrue(new P02_ProductsPage(driver).validateAddToCartSuccessfully(noOfItems));
        new P02_ProductsPage(driver).clickCartIcon();
        //ToDo: Check navigate to My Cart Page Successfully
        Thread.sleep(3000);
        Assert.assertEquals(new P03_CartPage(driver).verifyNavigateToMyCartsPage(), "Your Cart");
        //ToDo: Assert Total values
        Assert.assertEquals(new P03_CartPage(driver).getTotalPrice(noOfItems),totalPrice);
        //ToDo: Navigate back to the Products Page
        new P03_CartPage(driver).clickContinueShoppingBtn();
        //ToDo: Remove the first added item from products page
        updatedTotalPrice = new P02_ProductsPage(driver).removeRandomElements(index,totalPrice,randomIndex);
        Assert.assertEquals((updatedTotalPrice + new P02_ProductsPage(driver).getPrice(index.get(randomIndex-1))),totalPrice);
       /* new P03_CartPage(driver).clickCheckOutBtn();
       //ToDo: Check navigate to Information Page Successfully
        Thread.sleep(3000);
        Assert.assertEquals(new P04_CheckOutInformationPage(driver).verifyNavigateToInformationPage(), "Checkout: Your Information");
        new P04_CheckOutInformationPage(driver).enterFirstName(firstName).enterLastName(lastName).enterZipCode(zipCode).clickContinueBtn();
        //ToDo: Check navigate to Overview Page Successfully
        Thread.sleep(3000);
        Assert.assertEquals(new P05_CheckOutOverviewPage(driver).verifyNavigateToOverviewPage(), "Checkout: Overview");
        itemTotal = new P05_CheckOutOverviewPage(driver).getItemTotal();
        System.out.println("Total Price from checkout page = "+itemTotal);
        totalTax = new P05_CheckOutOverviewPage(driver).getTax();
        System.out.println("Total taxs from checkout page = "+totalTax);
        total = new P05_CheckOutOverviewPage(driver).getTotal();
        System.out.println(total);
        //ToDo: Check the Total value is the same as the total summed
        Assert.assertEquals((itemTotal + totalTax), total);
        Assert.assertEquals(itemTotal, totalPrice);

        new P05_CheckOutOverviewPage(driver).clickFinishBtn();
        //ToDo: Check the order has been completed successfully
        Thread.sleep(3000);
        Assert.assertTrue(new P06_FinishPage(driver).verifyOrderCompletedSuccessfully());*/
        Thread.sleep(3000);
        //SoftAssert softAssert = new SoftAssert();
        //softAssert.assertTrue(bool);
        //softAssert.assertAll();
    }
}
