package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class VerificationMethod {
    WebDriver driver;
    @Test
    public void verificationsInSelenium(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver);
        WebElement headerOfTheHomePage = driver.findElement(By.cssSelector(".login_logo"));
        System.out.println(headerOfTheHomePage);
        boolean isDisplayedHeadingOfTheHomePage = headerOfTheHomePage.isDisplayed();
        System.out.println(isDisplayedHeadingOfTheHomePage);

        driver.navigate().to("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        WebElement mainServicesAgreementCheckBox = driver.findElement(By.cssSelector("#SubscriptionAgreement"));

        boolean isSelectedMSAgreement = mainServicesAgreementCheckBox.isSelected();
        System.out.println("Before isSelectedMSAgreement :: " + isSelectedMSAgreement);

        WebElement uiCheckBox = driver.findElement(By.xpath("//a[text()='Main Services Agreement']/../preceding-sibling::div"));
        uiCheckBox.click();
        boolean isSelectedMSAgreementAfterClick = mainServicesAgreementCheckBox.isSelected();
        System.out.println("Before isSelectedMSAgreementAfterClick :: " + isSelectedMSAgreementAfterClick);
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
