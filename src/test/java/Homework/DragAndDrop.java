package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DragAndDrop {
    WebDriver driver;
    @Test
    public void verifyDragAndDrop(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement leftSide = driver.findElement(By.cssSelector("#column-a"));
        WebElement rightSide = driver.findElement(By.cssSelector("#column-b"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(leftSide,rightSide).build().perform();
        //actions.dragAndDrop(rightSide,leftSide).build().perform();
    }
    @AfterTest
    public void killsession(){
        driver.close();
    }
}
