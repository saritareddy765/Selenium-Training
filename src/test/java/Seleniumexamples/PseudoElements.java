package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PseudoElements extends BasePage{
    @Test
    public void handlePseudoElements(){
        driver.get("https://play1.automationcamp.ir/advanced.html");
        WebElement starRating = driver.findElement(By.cssSelector(".star-rating"));
        System.out.println("initialRating::"+starRating.getText());

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String pseudoElement = "window.getComputedStyle(document.querySelector('.star-rating'),'::after').getPropertyValue('content')";
        String stars = jse.executeScript("return "+pseudoElement+"").toString();
        System.out.println("stars::"+stars);
    }
}