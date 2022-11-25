package youtapPOS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class loginWithIncorrectPassword {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://portal.youtap.id/landing-page");
        chromeDriver.manage().window().maximize();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement clickLoginKePortal = chromeDriver.findElement(By.xpath("//a[@class='button-submit outline']"));
        clickLoginKePortal.click();

        WebElement inputIncorrectNoHp = chromeDriver.findElement(By.xpath("//input[@id='inputEmail']"));
        inputIncorrectNoHp.sendKeys("08121333123");

        WebElement inputPassword = chromeDriver.findElement(By.xpath("//input[@id='inputPassword']"));
        inputPassword.sendKeys("P@antatbau321");

        WebElement clickButtonLogin = chromeDriver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        clickButtonLogin.click();

        WebElement accountBelumAktif = chromeDriver.findElement(By.xpath("//div[contains(text(),'Username atau Password tidak sesuai')]"));
        String errorAccountBelumAktif = accountBelumAktif.getText();
        assertEquals("Username atau Password tidak sesuai", errorAccountBelumAktif);

        Thread.sleep(3000);
        chromeDriver.quit();
}
}