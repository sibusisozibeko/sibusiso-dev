import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class loginTondosWebSite {

    WebDriver driver;

    @Test
    public void LoginWithValidDetails(){

        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
        driver.findElement(By.id("login-email")).sendKeys("Sbuda@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Sbuda@155");
        driver.findElement(By.id("login-submit")).click();
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")).click();


    }
}
