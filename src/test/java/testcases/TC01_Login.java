package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_ProductsPage;


public class TC01_Login extends TestBase{
    //Declaration
    String email = "standard_user";
    String password = "secret_sauce";
    //Test Cases
    @Test(priority = 1, description = "Login with Valid Data")
    public void loginWithValidData_P() throws InterruptedException {
        new P01_LoginPage(driver).enterEmail(email).enterPassword(password).clickLoginBtn();
        Thread.sleep(3000);
        //ToDo: Check if Login successfully
        Assert.assertTrue(new P02_ProductsPage(driver).validateLoginSuccessfully());

    }
    @Test(priority = 2, description = "Login with Valid Email and Invalid Password")
    public void loginWithValidEmail_N() throws InterruptedException {
        password = "56788uhg";
        new P01_LoginPage(driver).enterEmail(email).enterPassword(password).clickLoginBtn();
        Thread.sleep(3000);
    }
    @Test(priority = 3, description = "Login with Invalid Email and Valid Password")
    public void loginWithValidPassword_N() throws InterruptedException {
        email = "wrong@mail.com";
        password = "Test@1234";
        new P01_LoginPage(driver).enterEmail(email).enterPassword(password).clickLoginBtn();
        Thread.sleep(3000);
    }

    @Test(priority = 1, description = "Login with Invalid Data")
    public void loginWithInvalidData_N() throws InterruptedException {
        email = "wrong@mail.com";
        password = "56788uhg";
        new P01_LoginPage(driver).enterEmail(email).enterPassword(password).clickLoginBtn();
        Thread.sleep(3000);
    }
}
