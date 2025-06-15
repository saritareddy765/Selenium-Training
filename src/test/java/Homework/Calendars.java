package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Calendars{
    WebDriver driver;
    @Test
    public void launchApp(){
        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement closeButton = driver.findElement(By.cssSelector("[data-cy='closeModal']"));
        closeButton.click();
      //  JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement departureDate = driver.findElement(By.cssSelector("[for='departure']"));
        departureDate.click();
       // jse.executeScript("arguments[0].click()", departureDate);

    }

}
