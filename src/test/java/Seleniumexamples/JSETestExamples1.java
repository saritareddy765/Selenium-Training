package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSETestExamples1 extends BaseSelenium{
    JavascriptExecutor jse;
    @BeforeTest
    public void initialize(){
        jse = (JavascriptExecutor) driver;
    }
    @Test
    public void scrollToElement(){
        driver.get("https://the-internet.herokuapp.com/");
        WebElement abtestLink = driver.findElement(By.cssSelector("[href*='abtest']"));
        WebElement forgotPasswordLink = driver.findElement(By.cssSelector("[href*='forgot_password']"));

        jse.executeScript("window.scrollBy(0,200)");//based on the pixel
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");//bottom of the page
        jse.executeScript("arguments[0].scrollIntoView(true)", abtestLink);//scroll to the element

    }
    @Test
    public void typeValueUsingJSId(){
        driver.get("https://www.saucedemo.com/");
        jse.executeScript("document.getElementById(\"user-name\").value='standard_user'");
        jse.executeScript("document.getElementById(\"password\").value='secret_sauce'");
        jse.executeScript("document.getElementById('login-button').click()");
    }
    @Test
    public void typeValueUsingQuerySelector(){
        driver.get("https://www.saucedemo.com/");
        jse.executeScript("document.querySelector('[name=\"user-name\"]').value='standard_user'");
        jse.executeScript("document.querySelector('[name=\"password\"]').value='secret_sauce'");
        jse.executeScript("document.querySelector('[name=\"login-button\"]').click()");
    }
    @Test
    public void getTextUsingJS()throws InterruptedException{
        driver.get("https://www.saucedemo.com/");
        String title = jse.executeScript("return document.querySelector(\".login_logo\").innerText").toString();
        System.out.println("title::"+title);

       jse.executeScript("alert('Welcome to SWAG LABS')");
    }
}
