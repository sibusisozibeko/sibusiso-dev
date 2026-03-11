package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait; // Import WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions; // Import ExpectedConditions

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait; // Add this line

    public LoginPage(WebDriver driver, WebDriverWait wait) { // Modify constructor
        this.driver = driver;
        this.wait = wait; // Initialize it
    }

    By loginButton = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]");
    By email = By.id("login-email");
    By password = By.id("login-password");
    By submit = By.id("login-submit");

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click(); // Use wait here
    }

    public void login(String user, String pass) {
        // This wait is already handled in PurchaseDeviceTest, but adding it here
        // makes the method more robust if called directly elsewhere.
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();
    }
}