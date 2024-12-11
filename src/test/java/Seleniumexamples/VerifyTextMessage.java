package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTextMessage {
    WebDriver driver;
    String trendingHeading = "SELLING OUT";
    @Test
    public void verifySubTextUsingMainText() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://www.prettylittlething.com/multi-christmas-tree-bow-oversized-knitted-christmas-jumper.html");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[text()='Accept All']")).click();
        WebElement trendingCountMessage = driver.findElement(By.xpath("//strong[@class='font-brand-medium']/../following-sibling::div"));
        String trendCount = trendingCountMessage.getText();
        System.out.println("trendingCount :: " + trendCount);
        String[] trendingActual = trendCount.split(" ");
        Assert.assertEquals(Integer.parseInt(trendingActual[0]), 44);

    }
}
