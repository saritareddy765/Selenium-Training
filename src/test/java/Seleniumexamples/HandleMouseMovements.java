package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class HandleMouseMovements extends BaseSelenium{
    SeleniumActions seleniumActions;
    @BeforeTest
    public void initializePages(){
        seleniumActions = new SeleniumActions();
    }
    @Test
    public void verifyDynamicDropDownIsHandle()throws IOException {
        driver.get("https://thesoftwarepractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement parentElement = driver.findElement(By.xpath("(//li/a[text()='Industries'])[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(parentElement);
        action.perform();
        action.click(driver.findElement(By.xpath("(//a[text()='Transportation'])[2]")));
        action.perform();
        action.release();

        wait.until(ExpectedConditions.textToBe(By.cssSelector(".title"), "TRANSPORTATION"));

        Assert.assertEquals(driver.getTitle(), "TSP : Industries - Transportation");

    }

    }
