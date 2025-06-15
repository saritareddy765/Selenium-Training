package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElementException extends BaseSelenium {
    @Test
    public void staleWithPageFactory(){
        driver.get("https://www.saucedemo.com/");
        StaleWithPageFactory staleWithPageFactory = new StaleWithPageFactory(driver);
        staleWithPageFactory.typeValue();
        driver.navigate().refresh();
        staleWithPageFactory.typeValue();
    }
    @Test
    public void handleStale(){
        driver.get("https://www.saucedemo.com/");
        WebElement userId = driver.findElement(By.id("user-name"));
        userId.clear();
        userId.sendKeys("Selenium");

        driver.navigate().refresh();
        try {
            userId.sendKeys("standard-user");
        }catch (StaleElementReferenceException ste){
            System.out.println("Stale handled");
            driver.findElement(By.id("user-name")).sendKeys("frameWork");
        }
    }
}
