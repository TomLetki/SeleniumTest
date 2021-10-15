import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewIframeTest {


    @Test
    public void testNewIFrame() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        //webelement jako argument
        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);
        // driver.switchTo().frame("nazwa iframe") - kiedy iframe ma nazwę!!
        driver.findElement(By.id("fname")).sendKeys("Tomasz");

        //driver.findElement(By.id("newPage")).click();
        //driver.switchTo().defaultContent();
        //System.out.println(driver.findElement(By.tagName("h1")).getText());



    }

    public WebDriver getDriver(String browser){
        return switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default-> throw new InvalidArgumentException("Wprowadź poprawną nazwę przeglądarki");
        };
    }
}


