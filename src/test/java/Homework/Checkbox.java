package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Checkbox {
    WebDriver driver;
    @Test
    public void launchapp() throws Exception{
        driver = new ChromeDriver();
        driver.navigate().to("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        WebElement Checkbox = driver.findElement(By.xpath("//div[starts-with(@id,'SubscriptionAgreement')]/preceding-sibling::div"));
        ////input[@id='SubscriptionAgreement']/following-sibling::div[@class='checkbox-ui']
        System.out.println(driver.findElement(By.cssSelector("#SubscriptionAgreement")).isSelected());
        WebElement Checkbox1 = driver.findElement(By.xpath("//div[starts-with(@id,'SubscriptionAgreement')]/preceding-sibling::div"));
        Checkbox1.click();
        System.out.println(driver.findElement(By.cssSelector("#SubscriptionAgreement")).isSelected());

    }
}
