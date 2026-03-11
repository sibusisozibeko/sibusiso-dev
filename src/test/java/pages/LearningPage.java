package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; // Import WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions; // Import ExpectedConditions
import java.time.Duration; // Import Duration if not already there

public class LearningPage {

    WebDriver driver;
    WebDriverWait wait; // Add this line

    public LearningPage(WebDriver driver, WebDriverWait wait) { // Modify constructor
        this.driver = driver;
        this.wait = wait; // Initialize it
    }

    By learnDropdown = By.xpath("//button[contains(., 'Learn')]");
    By learningMaterials = By.xpath("//span[contains(., 'Learning Materials')]");
    By webAutomation = By.xpath("//*[contains(text(), 'Web Automation Advance')]");

    By deviceType = By.id("deviceType");
    By brand = By.id("brand");
    By storage = By.id("storage-128GB");
    By color = By.id("color");
    By quantity = By.id("quantity");
    By address = By.id("address");

    By nextBtn = By.id("inventory-next-btn");
    By expressShipping = By.id("shipping-option-express");
    By warranty = By.id("warranty-option-1yr");

    By discount = By.id("discount-code");
    By applyDiscount = By.id("apply-discount-btn");

    By purchaseBtn = By.id("purchase-device-btn");
    By viewHistory = By.id("view-history-btn");
    By viewButton = By.xpath("//button[contains(@id,'view-invoice') and contains(.,'View')]");


    public void navigateToCourse() {
        wait.until(ExpectedConditions.elementToBeClickable(learnDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(learningMaterials)).click();
        wait.until(ExpectedConditions.elementToBeClickable(webAutomation)).click();
    }

    public void selectDevice() {
        // Adding waits to these elements as well for robustness
        wait.until(ExpectedConditions.visibilityOfElementLocated(deviceType));
        new Select(driver.findElement(deviceType)).selectByVisibleText("Phone");
        wait.until(ExpectedConditions.visibilityOfElementLocated(brand));
        new Select(driver.findElement(brand)).selectByVisibleText("Apple");

        wait.until(ExpectedConditions.elementToBeClickable(storage)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(color));
        new Select(driver.findElement(color)).selectByVisibleText("Blue");

        wait.until(ExpectedConditions.visibilityOfElementLocated(quantity)).clear();
        driver.findElement(quantity).sendKeys("2");

        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys("24 Kuilsrivier");
    }

    public void checkout() {
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(expressShipping)).click();
        wait.until(ExpectedConditions.elementToBeClickable(warranty)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(discount)).sendKeys("SAVE10");
        wait.until(ExpectedConditions.elementToBeClickable(applyDiscount)).click();

        wait.until(ExpectedConditions.elementToBeClickable(purchaseBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewHistory)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewButton)).click();
    }
}