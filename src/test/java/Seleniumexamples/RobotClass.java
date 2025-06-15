package Seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotClass extends BasePage{
    @Test
    public void uploadFileUsingRobotClass()throws AWTException,InterruptedException{
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton = driver.findElement(By.cssSelector("[id=\"drag-drop-upload\"]"));
        chooseFileButton.click();

        Robot robot = new Robot();
        StringSelection file = new StringSelection(System.getProperty("user.dir") + "\\downloads\\some-file.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(7000);
    }
}
