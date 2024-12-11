package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxSelected  {
    WebDriver driver;
    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
    }
    @Test
    public void VerifyCheckbox(){
       driver.navigate().to("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
       WebElement mainServicesAgreementCheckbox = driver.findElement(By.cssSelector("#SubscriptionAgreement"));
       boolean isSelectedMsAgreement = mainServicesAgreementCheckbox.isSelected();
        System.out.println("Before isSelectedMsAgreement :: " + isSelectedMsAgreement);

        WebElement uiCheckbox = driver.findElement(By.xpath("//input[@id ='SubscriptionAgreement']/following-sibling::div[@class='checkbox-ui']"));
        uiCheckbox.click();
        boolean isSelectedMsAgreementAfterClick = mainServicesAgreementCheckbox.isSelected();
        System.out.println("Before isSelectedMsAgreementAfterClick :: " + isSelectedMsAgreementAfterClick);
    }
    @AfterTest
    public void killSection() {
        driver.close();
    }


}
