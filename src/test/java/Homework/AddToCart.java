package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCart {
    WebDriver driver;
    @Test
    public void addToCart() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement MegaMenu = driver.findElement(By.xpath("//span[normalize-space()='Mega Menu']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(MegaMenu);
        actions.perform();
        WebElement apple = driver.findElement(By.xpath("//h3[text()='Mobiles']/../descendant::li/a[@title='Apple']"));
        apple.click();
        String ipodText = driver.findElement(By.xpath("//a[text()='iPod Touch']")).getText();
        System.out.println(ipodText);
        String ipodPrice = driver.findElement(By.xpath("//a[text()='iPod Touch']/../following-sibling::div/span")).getText();
        System.out.println(ipodPrice);
        Thread.sleep(2000);
        WebElement ipodTouch = driver.findElement(By.xpath
                ("//a[text()='iPod Touch']/../../../div/div[@class='product-action']/button/i[contains(@class,'shopping-cart')]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",ipodTouch);
        WebElement viewCart = driver.findElement(By.xpath("//div[@class='form-row']/div"));
        viewCart.click();
        String cartProductName = driver.findElement(By.xpath("//td[@class='text-left']/a")).getText();
        System.out.println(cartProductName);
        String cartProductPrice = driver.findElement(By.xpath
                ("//table[@class='table']/tbody/tr/td[@class='text-right']")).getText();
                //(//table[@class='table']/tbody/tr/td[text()='$194.00']")).getText();
        System.out.println(cartProductPrice);

        Assert.assertEquals(ipodText,cartProductName);
        //Assert.assertEquals(ipodPrice,cartProductPrice);
    }
}
