package Seleniumexamples;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DownloadingFile extends BasePage{
    @Test
    public void downloadFile() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.cssSelector("[href='download/LambdaTest.txt']")).click();
        Thread.sleep(3000);
        File file = new File(System.getProperty("user.dir")+"\\Downloads");
        Assert.assertTrue(file.exists());
    }
}
