package jakartaWebSolution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static jakartaWebSolution.mouseHouver.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class  chekout<actions> {



    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://magento.softwaretestingboard.com/");
        chromeDriver.manage().window().maximize();
        WebElement signIn = chromeDriver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]"));
        signIn.click();

        WebElement inputEmail = chromeDriver.findElement(By.xpath("//input[@id='email']"));
        inputEmail.sendKeys("beni.jws@mailinator.com");


        WebElement inputPasswrod = chromeDriver.findElement(By.xpath("//input[@title='Password']"));
        inputPasswrod.sendKeys("B3n!qajws");

        WebElement clickSignIn = chromeDriver.findElement(By.xpath("//button[@class='action login primary']"));
        clickSignIn.click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions actions = new Actions(chromeDriver);
        WebElement clickMen = chromeDriver.findElement(By.linkText("Men"));
        actions.moveToElement(clickMen).build().perform();

        WebElement clickTops = chromeDriver.findElement(By.linkText("Tops"));
        actions.moveToElement(clickTops).build().perform();

        WebElement jacketMen = chromeDriver.findElement(By.linkText("Jackets"));
        jacketMen.click();

        WebElement jacketsProteus = chromeDriver.findElement(By.linkText("Proteus Fitness Jackshirt"));
        jacketsProteus.click();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement jacketsSize = chromeDriver.findElement(By.xpath("//div[@id='option-label-size-143-item-169']"));
        jacketsSize.click();

        WebElement jacketsColor = chromeDriver.findElement(By.xpath("//div[@id='option-label-color-93-item-50']"));
        jacketsColor.click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement addToCart = chromeDriver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
        addToCart.click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement clickMen1 = chromeDriver.findElement(By.linkText("Men"));
        actions.moveToElement(clickMen1).build().perform();

        WebElement clickBottoms = chromeDriver.findElement(By.linkText("Bottoms"));
        actions.moveToElement(clickBottoms).build().perform();

        WebElement pantsMen = chromeDriver.findElement(By.linkText("Pants"));
        pantsMen.click();

        WebElement cronusYogaPant = chromeDriver.findElement(By.linkText("Cronus Yoga Pant"));
        cronusYogaPant.click();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement pantsSize = chromeDriver.findElement(By.xpath("//div[@option-label='34']"));
        pantsSize.click();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement pantsColor = chromeDriver.findElement(By.xpath("//div[@id='option-label-color-93-item-50']"));
        pantsColor.click();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement addToCarts = chromeDriver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        addToCarts.click();

        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement goToCart = chromeDriver.findElement(By.xpath("//header/div[2]/div[1]/a[1]"));
        goToCart.click();

        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement proceedToCheckout = chromeDriver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
        proceedToCheckout.click();

        driver.navigate().refresh();

        WebElement orderSummaryJacket = chromeDriver.findElement(By.xpath("//strong[contains(text(),'Proteus Fitness Jackshirt')]"));
        String verifyOrderSummaryJacket = orderSummaryJacket.getText();
        assertEquals("Proteus Fitness Jackshirt", verifyOrderSummaryJacket);

        WebElement orderSummaryJacketPrice = chromeDriver.findElement(By.xpath("//span[contains(text(),'$45.00')]"));
        String verifyOrderSummaryJacketPrice = orderSummaryJacketPrice.getText();
        assertEquals("$45.00", verifyOrderSummaryJacketPrice);

        WebElement orderSummaryPant = chromeDriver.findElement(By.xpath("//strong[contains(text(),'Cronus Yoga Pant')]"));
        String verifyOrderSummaryPant = orderSummaryPant.getText();
        assertEquals("Cronus Yoga Pant", verifyOrderSummaryPant);

        WebElement orderSummaryPantPrice = chromeDriver.findElement(By.xpath("//span[contains(text(),'$48.00')]"));
        String verifyOrderSummaryPantPrice = orderSummaryPantPrice.getText();
        assertEquals("$48.00", verifyOrderSummaryPantPrice);

        WebElement shippingMethod = chromeDriver.findElement((By.cssSelector("tbody tr:first-of-type input")));
        shippingMethod.click();

        WebElement clickButtonNext = chromeDriver.findElement(By.xpath("//span[contains(text(),'Next')]"));
        clickButtonNext.click();

        WebElement clickPlaceOrder = chromeDriver.findElement((By.xpath("//span[contains(text(),'Place Order')]")));
        clickPlaceOrder.click();

        WebElement textMyOrder = chromeDriver.findElement(By.cssSelector("button[class*='action primary checkout']"));
        String verifyMyorder = textMyOrder.getText();
        assertEquals("We'll email you an order confirmation with details and tracking info", verifyMyorder);

        Thread.sleep(3000);
        chromeDriver.quit();

    }
}
