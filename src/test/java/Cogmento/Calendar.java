package Cogmento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Calendar {
    WebDriver driver;
    @Test
    public void calendarModule() {
        driver = new ChromeDriver();
        driver.get("https://ui.cogmento.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // login details
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("saritareddy3024@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("sarita123");
        WebElement loginButton = driver.findElement(By.xpath("//div[text()='Login']"));
        loginButton.click();
        //calendar module
        WebElement calendarButton = driver.findElement(By.xpath("//span[contains(text(),'Calendar')]"));
        calendarButton.click();
        WebElement createButton = driver.findElement(By.xpath("//button[@class='ui linkedin button']/i[@class='edit icon']"));
        createButton.click();
        //details of creating calendar
        WebElement Title = driver.findElement(By.cssSelector("[name='title']"));
        Title.sendKeys("Meeting");
        WebElement Calendar = driver.findElement(By.xpath("//div[@name='calendar']/i"));
        Calendar.click();
        //adding the  newcalendar name
        WebElement NewCalendar = driver.findElement(By.xpath("//span[text()='New Calendar']"));
        NewCalendar.click();
        WebElement AddNewCalendarName = driver.findElement(By.cssSelector("[name='calendarName']"));
        AddNewCalendarName.sendKeys("June Meeting");
        WebElement SaveButton = driver.findElement(By.xpath("//button[@class='ui button']/i[@class='checkmark icon']"));
        SaveButton.click();
        //selecting the calendar name in dropdown
        WebElement CalendarDropDownMenu = driver.findElement(By.xpath("//div[@name='calendar']/i"));
        CalendarDropDownMenu.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@class='visible menu transition']/div[@role='option']"));
        for (WebElement option : options) {
            String text = option.getText();
            if (text.equals(AddNewCalendarName)) {
                option.click();
            }
        }
    }
}
