package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BrowserStack {
    public WebDriver driver;
    @Test
    public void launchApp(){
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement usernameInputBox = driver.findElement(By.cssSelector("#username"));
        usernameInputBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //number of options
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='react-select-2-group-0-heading']/following-sibling::div"));
        System.out.println(options.size());
        //get options name
        for (WebElement optionsText:options)
        {
            System.out.println(optionsText.getText());
        }
        //click on single option
        WebElement userName = driver.findElement(By.xpath("//div[text()='demouser']"));
       userName.click();
        WebElement passwordInputBox = driver.findElement(By.cssSelector("#password"));
        passwordInputBox.click();
        WebElement password = driver.findElement(By.xpath("//div[text()='testingisfun99']"));
        password.click();
        WebElement login = driver.findElement(By.cssSelector("#login-btn"));
        login.click();

    }
}
