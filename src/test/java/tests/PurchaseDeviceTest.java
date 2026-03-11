package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
// !!! IMPORTANT: Make sure these two lines are commented out or deleted
// import org.openqa.selenium.support.ui.WebDriverWait;
// import java.time.Duration;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LearningPage;

public class PurchaseDeviceTest extends BaseTest { // Make sure it extends BaseTest

    @Test
    public void LoginWithValidDetails(){

        // Pass both driver and wait (which is inherited from BaseTest) to the page objects
        LoginPage login = new LoginPage(driver, wait); // 'wait' here refers to the protected field in BaseTest
        LearningPage purchase = new LearningPage(driver, wait); // 'wait' here refers to the protected field in BaseTest

        login.clickLogin();

        // This wait is still good here for the initial login email field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password"))); // 'wait' here should be accessible

        login.login("sibusiso@gmail.com","Sbuda@166");

        purchase.navigateToCourse();
        purchase.selectDevice();
        purchase.checkout();
    }
}