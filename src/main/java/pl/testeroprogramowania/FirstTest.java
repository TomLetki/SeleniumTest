package pl.testeroprogramowania;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.testeroprogramowania.BaseTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FirstTest extends BaseTest {
    WebDriver driver;

    @Test
    public void firstTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElement(By.cssSelector("p"));

        WebElement para = driver.findElement(By.cssSelector("p"));
        Assert.assertTrue(para.isDisplayed(), "Element is not displayed");
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().startsWith("Pojawiłem"));
        //Assert.assertEquals(para.isDisplayed(), true);
        Assert.assertEquals(para.getText(), "Dopiero się pojawiłem!", "Teksty są jednakowe");

        //String paraText = driver.findElement(By.cssSelector("p")).getText();
        //Assert.assertEquals(paraText,"Dopiero się pojawiłem!");
        //Assert.assertEquals(paraText, "Dopiero", "Teksty są różne");
        driver.quit();
    }
    @Test
    public void secondTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElement(By.cssSelector("p"));
        WebElement para = driver.findElement(By.cssSelector("p"));
        SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(para.isDisplayed(), true);
            softAssert.assertTrue(para.isDisplayed(), "Element is not displayed");
            softAssert.assertEquals(para.getText(),"Dopiero", "Teksty są różne");
            softAssert.assertTrue(para.getText().startsWith("Dopiero"));
            softAssert.assertFalse(para.getText().startsWith("Pojawiłem"));
            softAssert.assertEquals(para.getText(), "Dopiero si!", "druga asercja");

        /*String paraText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paraText,"Dopiero się pojawiłem!");
        if(paraText.equals("Dopiero się pojawiłem!")) {
            int randomNumber = (int) (Math.random() * 1000);
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String fileName = "screen" + randomNumber + ".png";
            FileUtils.copyFile(srcFile, new File("src/test/resources/" + fileName));
        }*/


        driver.quit();
        softAssert.assertAll();
    }

    public void waitForElement(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until(driver1 ->  {
            List<WebElement> elements = driver.findElements(locator);
            if(elements.size()>0) {
                System.out.println("Element jest na stronie");
                return true;
            }else {
                System.out.println("Elementu nie ma ma stronie");
                return false;
            }



        });
    }
}