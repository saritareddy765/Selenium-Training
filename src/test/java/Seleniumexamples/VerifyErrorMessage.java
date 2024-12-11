package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyErrorMessage {
    WebDriver driver;
    String lastNameErrorMessage = "Enter your last name";
    String jobTitleErrorMessage = "Select your job title";
    @Test
    public void verifyerrorMessage() {
        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement startMyFreeTrialButton = driver.findElement(By.cssSelector(".form_submit_button.submitButton"));
        startMyFreeTrialButton.click();

        WebElement errorMessageOfLastInputField = driver.findElement(By.xpath("//label[starts-with(@for,'UserLastName')]/following-sibling::span"));
        String actualErrorMessage = errorMessageOfLastInputField.getText();
        System.out.println("actualErrorMessage :: " + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, lastNameErrorMessage);

        WebElement jobTitleDropDownErrorMessage = driver.findElement(By.xpath("//span[text()='Select your title']"));
        Assert.assertTrue(jobTitleDropDownErrorMessage.isDisplayed());
    }

        @AfterClass
                public void killsection(){
        driver.quit();
        }
    }


