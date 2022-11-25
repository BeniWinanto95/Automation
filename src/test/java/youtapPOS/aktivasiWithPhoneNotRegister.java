package youtapPOS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class aktivasiWithPhoneNotRegister {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://portal.youtap.id/landing-page");
        chromeDriver.manage().window().maximize();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement clickButtonAktivasiAkunPortal = chromeDriver.findElement(By.cssSelector("div[class*='button-section'] [class*='button-submit primary']"));
        clickButtonAktivasiAkunPortal.click();

        WebElement inputPhoneNumber = chromeDriver.findElement(By.xpath("//input[@id='mid']"));
        inputPhoneNumber.sendKeys("81213331234");

        WebElement clickButtonLanjut = chromeDriver.findElement(By.xpath("//button[contains(text(),'Lanjut')]"));
        clickButtonLanjut.click();

        WebElement nomerBelumTerdaftar = chromeDriver.findElement(By.xpath("//div[contains(text(),'Nomer HP yang anda masukkan tidak terdaftar')]"));
        String errorNomerBelumTerdaftar = nomerBelumTerdaftar.getText();
        assertEquals("Nomer HP yang anda masukkan tidak terdaftar", errorNomerBelumTerdaftar);

        Thread.sleep(3000);
        chromeDriver.quit();
    }
}
