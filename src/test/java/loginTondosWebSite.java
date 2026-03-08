import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class loginTondosWebSite {

    WebDriver driver;

    @Test
    public void LoginWithValidDetails() {
        // creation of a new instance of the Chrome web browser, tells the browser to navigate to Ndosi website, command browser to mximize the screen
        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/#overview");
        driver.manage().window().maximize();

        // Initialize WebDriverWait for explicit waits, don't grab a cookie right after you put it in the oven give the cookie time to bake
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // Increased timeout for stability
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();

        // Login with your test user
        driver.findElement(By.id("login-email")).sendKeys("sibusiso@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Sbuda@166");
        driver.findElement(By.id("login-submit")).click();

        // Verify that you logged in (check for an element that appears after login)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(., 'My Learning')]")));
        // First, click 'Learn' dropdown
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Learn')]"))).click();
        // Then click 'Learning Materials'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(., 'Learning Materials')]"))).click();
        // Then click 'Web Automation Advance'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Web Automation Advance')]"))).click();
        // Select Device Type: Phone
        new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deviceType")))).selectByVisibleText("Phone");
//        WebElement deviceTypeDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deviceType")));
//        new Select(deviceTypeDropdown).selectByVisibleText("Phone");
        // Select Brand: Apple,
        new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("brand")))).selectByVisibleText("Apple");
        // Select Storage: 128GB
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='storage-128GB']"))).click();//new
        //Select Color
        new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("color")))).selectByVisibleText("Blue");
        // Enter Quantity: 2
        WebElement quantityField = wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity")));
        quantityField.clear();
        quantityField.sendKeys("2");
        // Enter Address: "24 Kuilsrivier"
        WebElement addressField = wait.until(ExpectedConditions.elementToBeClickable(By.id("address")));
        addressField.sendKeys("24 Kuilsrivier");
        // Click Next
        wait.until(ExpectedConditions.elementToBeClickable(By.id("inventory-next-btn"))).click();
        // Select Express Shipping
        wait.until(ExpectedConditions.elementToBeClickable(By.id("shipping-option-express"))).click();
        // Select 1yr Warranty
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("warranty-option-1yr"))).click();
        // Apply discount code SAVE10
        wait.until(ExpectedConditions.elementToBeClickable(By.id("discount-code"))).sendKeys("SAVE10");
        //Click Apply
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"apply-discount-btn\"]"))).click();
        // Click Confirm Purchase
        wait.until(ExpectedConditions.elementToBeClickable(By.id("purchase-device-btn"))).click();
        //Click view invoice
        WebElement viewInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"view-history-btn\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewInvoiceButton);
        viewInvoiceButton.click();
        //Invoice viewed
        driver.findElement(By.xpath("//button[contains(@id,'view-invoice') and contains(.,'View')]")).click();

    }
}