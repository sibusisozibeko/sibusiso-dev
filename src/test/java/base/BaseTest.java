package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait; // <-- Make sure this is imported
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration; // <-- Make sure this is imported

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait; // <--- THIS MUST BE 'protected' AND DECLARED HERE

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/#overview");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // <--- THIS MUST BE INITIALIZED HERE
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}