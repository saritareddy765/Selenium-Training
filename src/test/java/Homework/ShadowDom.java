package Homework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShadowDom {
    WebDriver driver;
    JavascriptExecutor jse;
    @Test
    public void shadowDom(){
        driver = new ChromeDriver();
        jse = (JavascriptExecutor) driver;
        driver.get("https://www.salesforce.com/in/?ir=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement shadowHost = driver.findElement(By.cssSelector
                ("hgf-c360nav[origin*='sfdcdigital']"));
        SearchContext shadowRoot = (SearchContext) jse.executeScript
                ("return arguments[0].shadowRoot",shadowHost);
        WebElement shadowElement = shadowRoot.findElement(By.cssSelector("[data-tracking-type='cta-utility']"));
       try{
        shadowElement.click();

       }catch (ElementNotInteractableException enie){
           System.out.println("ElementNotInteractableException");
        }

    }
    @Test
    public void shadowElement(){
        driver= new ChromeDriver();
        driver.get("https://www.salesforce.com/in/?ir=1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement shadowRootElement = driver.findElement(By.cssSelector("hgf-c360nav[origin*='sfdcdigital']"));
        SearchContext showElement = shadowRootElement.getShadowRoot();
        showElement.findElement(By.cssSelector("[data-tracking-type='cta-utility']")).click();


    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
