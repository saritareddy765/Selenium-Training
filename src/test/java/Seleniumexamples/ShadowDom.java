package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShadowDom extends BasePage {
    @Test
    public void handleShadowElement(){
        driver.get("https://books-pwakit.appspot.com/");
        SearchContext shadowRootElement = driver.findElement(By.cssSelector("[apptitle='BOOKS']")).getShadowRoot();
        shadowRootElement.findElement(By.cssSelector("[aria-label='Search Books']")).sendKeys("Selenium");

    }
    @Test
    public void shadowDomUsingJS(){
        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement shadowHost = driver.findElement(By.cssSelector("[apptitle='BOOKS']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext) jse.executeScript("return arguments[0].shadowRoot",shadowHost);
       WebElement shadowElement = shadowRoot.findElement(By.cssSelector("[aria-label='Search Books']"));
       shadowElement.sendKeys("Selenium");


    }
}
