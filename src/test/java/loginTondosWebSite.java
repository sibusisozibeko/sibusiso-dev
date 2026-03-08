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
        // 1. Initialize WebDriver and navigate
        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/#overview");
        driver.manage().window().maximize();

        // Initialize WebDriverWait for explicit waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased timeout for stability
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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Web Automation Advance')]"))).click();
        // Select Device Type: Phone
        WebElement deviceTypeDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deviceType")));
        new Select(deviceTypeDropdown).selectByVisibleText("Phone");
        System.out.println("Selected Device Type: Phone");
        // Select Brand: Apple
        WebElement brandDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("brand")));
        new Select(brandDropdown).selectByVisibleText("Apple");
        // Select Storage: 128GB
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='storage-128GB']"))).click();//new
        //Select Color
        new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("color")))).selectByVisibleText("Blue");
        // Enter Quantity: 2
        WebElement quantityField = wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity")));
        quantityField.clear();
        quantityField.sendKeys("2");
        // Enter Address: "Kuilsrivier"
        WebElement addressField = wait.until(ExpectedConditions.elementToBeClickable(By.id("address")));
        addressField.sendKeys("Kuilsrivier");
        // Click Next
        wait.until(ExpectedConditions.elementToBeClickable(By.id("inventory-next-btn"))).click();
        // Select Express Shipping
        wait.until(ExpectedConditions.elementToBeClickable(By.id("shipping-option-express"))).click();
        // Select 1yr Warranty
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("warranty-option-1yr")));
        // Apply discount code SAVE10
        WebElement discountCodeField = wait.until(ExpectedConditions.elementToBeClickable(By.id("discount-code")));
        discountCodeField.sendKeys("SAVE10");
        //Click Apply
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"apply-discount-btn\"]"))).click();
        // Click Confirm Purchase
        wait.until(ExpectedConditions.elementToBeClickable(By.id("purchase-device-btn"))).click();
        System.out.println("Clicked Confirm Purchase");
        //Click view invoice
        WebElement viewInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"view-history-btn\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewInvoiceButton);
        viewInvoiceButton.click();

    }
}