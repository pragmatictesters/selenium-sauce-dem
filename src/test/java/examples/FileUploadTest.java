package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest {

    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/upload");
    }

    @AfterMethod
    public void afterMethod() {
        if (webDriver!=null){
            webDriver.quit();
        }
    }

    @Test
    public void testFileUpload(){

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/upload");

        // Get the absolute path of the image located under resources/images
        String filePath = new File("src/test/resources/images/Selenium_Logo.png").getAbsolutePath();
        // Send the file path to the file input field
        webDriver.findElement(By.id("file-upload")).sendKeys(filePath);
        webDriver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(webDriver.findElement(By.cssSelector("#content h3")).getText(), "File Uploaded!");
    }
}
