package Seleniumexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseSelenium {
    WebDriver driver;
    @BeforeSuite
    public void launchBrowser(){
        driver = new ChromeDriver();
    }
    @AfterSuite
    public void killSection(){
        driver.close();
    }
    @BeforeTest
    public void verifyDeleteButtons(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }
}
