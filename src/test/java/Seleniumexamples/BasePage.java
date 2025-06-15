package Seleniumexamples;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class BasePage {
    public WebDriver driver;
    @BeforeSuite
    public void  launchBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        HashMap<String , String> map = new HashMap<>();
        map.put("download.default_directory",System.getProperty("user.dir")+ "\\Downloads");
        chromeOptions.setExperimentalOption("prefs",map);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    }
    @AfterSuite
    public void killSection(){
        driver.quit();
    }
    @AfterMethod
    public void takeScreenshotWhenFails(ITestResult iTestResult) throws IOException{
        if(ITestResult.FAILURE==2){
            getScreenShot();
        }
    }
    public void getScreenShot() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("Users.dir")+"/Screenshots/img.png");
        FileUtils.copyFile(source,destination);
    }
}
