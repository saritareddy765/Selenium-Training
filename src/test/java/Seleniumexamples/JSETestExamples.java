package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSETestExamples extends BaseSelenium{
    @Test
    public void clickUsingJS(){
        driver.get("https://www.prettylittlething.com/dark-grey-marl-knit-distressed-detail-chunky-cable-jumper.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement acceptAllButton = driver.findElement(By.xpath("//button[text()='Accept All']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;//downCasting
        String eleClick = "arguments[0].click()";//"return.arguments[0].click();
        ((JavascriptExecutor) driver).executeScript(eleClick,acceptAllButton);
        WebElement addToBagButton = driver.findElement(By.id("add-to-bag-button"));
        boolean getStatusOfAddTOBagButton = addToBagButton.isEnabled();
        System.out.println("getStatusOfAddTOBagButton ::" + getStatusOfAddTOBagButton);

        WebElement size = driver.findElement(By.xpath("//span[text()='XS']"));
        ((JavascriptExecutor) driver).executeScript(eleClick,size);
        System.out.println("addToBagButton ::"+addToBagButton.isEnabled());

    }
    @Test
    public void typeValueUsingJS(){
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        driver.manage().window().maximize();
        WebElement firstName = driver.findElement(By.cssSelector("input[name='UserFirstName']"));
        firstName.clear();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String typeValueInElement = "arguments[0].value='sai'";
        jse.executeScript(typeValueInElement,firstName);
    }
    @Test
    public void changeAttributeValue(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        System.out.println(clickHereLink.getAttribute("target")); // deprecated in current version 4.27
        System.out.println(clickHereLink.getDomAttribute("target"));
        System.out.println(clickHereLink.getDomProperty("target"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String changeAttribute = "arguments[0].setAttribute('target','_self')";
        jse.executeScript(changeAttribute, clickHereLink);
        clickHereLink.click();

       Assert.assertEquals(driver.findElement(By.cssSelector(".example>h3")).getText(), "New Window");
    }

}
