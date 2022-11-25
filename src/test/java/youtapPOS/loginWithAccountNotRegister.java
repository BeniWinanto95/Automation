package youtapPOS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class loginWithAccountNotRegister {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://portal.youtap.id/landing-page");
        chromeDriver.manage().window().maximize();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement clickLoginKePortal = chromeDriver.findElement(By.xpath("//a[@class='button-submit outline']"));
        clickLoginKePortal.click();

        WebElement inputNoHp = chromeDriver.findElement(By.xpath("//input[@id='inputEmail']"));
        inputNoHp.sendKeys("081213334852");

        WebElement inputPassword = chromeDriver.findElement(By.xpath("//input[@id='inputPassword']"));
        inputPassword.sendKeys("P@antatbau123");

        WebElement clickButtonLogin = chromeDriver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        clickButtonLogin.click();

        WebElement accountBelumAktif = chromeDriver.findElement(By.xpath("//div[contains(text(),'Akun Anda belum aktif, mohon hubungi customer serv')]"));
        String errorAccountBelumAktif = accountBelumAktif.getText();
        assertEquals("Akun Anda belum aktif, mohon hubungi customer service", errorAccountBelumAktif);

        Thread.sleep(3000);
        chromeDriver.quit();
    }
}
