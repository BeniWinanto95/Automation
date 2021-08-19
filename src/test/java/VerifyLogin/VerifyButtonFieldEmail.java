package VerifyLogin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyButtonFieldEmail {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://analytics.tabsquare.com/");
        chromeDriver.manage().window().maximize();
        WebElement inputEmail = chromeDriver.findElement(By.cssSelector("input[placeholder*='Email']"));
        inputEmail.click();
        inputEmail.sendKeys("test@mailinator.com");

        Thread.sleep(3000);
        chromeDriver.quit();
    }
}
