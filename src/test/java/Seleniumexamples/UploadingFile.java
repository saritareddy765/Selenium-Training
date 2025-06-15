package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadingFile extends BasePage{
    @Test
    public void uploadFile(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
      // chooseFileButton.sendKeys("C:\\Users\\bharg\\Desktop\\demo.txt");
        chooseFileButton.sendKeys(System.getProperty("user.dir")+"\\src\\test\\locators.txt");
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".example>h3")).getText(), "File Uploaded!");
    }
}
