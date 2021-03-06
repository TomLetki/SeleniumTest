import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class UploadTest {

    @Test
    public void uploadFile() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
      //  driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Tomasz\\Downloads\\chlockenstein-rundweg.gpx");
        //robienie screenshotów
        int randomNumber = (int) (Math.random()*1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "screen"+randomNumber+".png";
        FileUtils.copyFile(srcFile, new File("src/test/resources/"+fileName));
    // klikanie prawym przyciskiem myszy na stronie.
        Actions actions = new Actions(driver);
        //actions.contextClick().perform(); //klika w dowolnym miejscu
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();// konkretny webelement


    }
}