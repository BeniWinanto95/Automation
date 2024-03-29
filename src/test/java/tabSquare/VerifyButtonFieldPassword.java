package tabSquare;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class VerifyButtonFieldPassword {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://analytics.tabsquare.com/");
        chromeDriver.manage().window().maximize();
        WebElement inputPassword = chromeDriver.findElement(By.cssSelector("input[placeholder*='Password']"));
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        inputPassword.click();
        inputPassword.sendKeys("testTabSquare");

        Thread.sleep(3000);
        chromeDriver.quit();
    }
}
