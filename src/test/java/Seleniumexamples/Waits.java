package Seleniumexamples;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v128.systeminfo.model.Size;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Waits extends BaseSelenium{
    @Test
    public void usageImplicitWait() throws InterruptedException{
        driver.get("https://www.prettylittlething.com/dark-grey-marl-knit-distressed-detail-chunky-cable-jumper.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Accept All']")).click();
        WebElement addToBagButton = driver.findElement(By.id("add-to-bag-button"));
        boolean getStatusOfAddToBagButton = addToBagButton.isEnabled();
        System.out.println("getStatusAddToBagButton :; "+ getStatusOfAddToBagButton);

        Thread.sleep(3000);
        WebElement size = driver.findElement(By.xpath("//span[text()='L']"));
        size.click();
        System.out.println("addToBagButton status ::"+ addToBagButton.isEnabled());
        Assert.assertTrue(addToBagButton.isEnabled());
    }
    @Test
    public void usageOfwebDriverWait()  {
        driver.get("https://www.prettylittlething.com/dark-grey-marl-knit-distressed-detail-chunky-cable-jumper.html");
        driver.manage().window().maximize();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept All']"))).click();
        WebElement addToBagButton = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-bag-button"))));
        boolean getStatusOfAddToButton = addToBagButton.isEnabled();
        System.out.println("getStatusOfAddToButton ::"+ getStatusOfAddToButton);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='L']"))).click();
        System.out.println("addToBagButton :: "+ addToBagButton.isEnabled());
        Assert.assertTrue(addToBagButton.isEnabled());
        }
        @Test
        public void usageOfFluentWait() {
            driver.get("https://www.prettylittlething.com/dark-grey-marl-knit-distressed-detail-chunky-cable-jumper.html");
            driver.manage().window().maximize();

            //Explicit wait or conditional wait
            FluentWait fluentWait = new FluentWait(driver);
            fluentWait.withTimeout(Duration.ofSeconds(10));
            fluentWait.pollingEvery(Duration.ofSeconds(2));
            fluentWait.withMessage("Element not found");
            fluentWait.ignoring(NoSuchElementException.class);
            fluentWait.ignoring(ElementClickInterceptedException.class);
            fluentWait.ignoring(StaleElementReferenceException.class);


            FluentWait fluentWait1 = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .withMessage("Element not found")
                    .ignoring(NoSuchElementException.class)
                    .ignoring(TimeoutException.class);


            fluentWait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept All']")));
            driver.findElement(By.xpath("//button[text()='Accept All']")).click();

            // driver.findElement(By.xpath("//button[text()='Accept All']")).click();
            WebElement addToBagButton = (WebElement) fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-bag-button"))));
            boolean getStatusOdAddToBagButton = addToBagButton.isEnabled();
            System.out.println("getStatusOfAddToBagButton :: " + getStatusOdAddToBagButton);

            WebElement element = (WebElement) fluentWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='L']"))));
//        WebElement size = driver.findElement(By.xpath("//span[text()='M']"));
//        size.click();
            element.click();

            System.out.println("addToBagButton status :: " + addToBagButton.isEnabled());
            Assert.assertTrue(addToBagButton.isEnabled());
        }

}
