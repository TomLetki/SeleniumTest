import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
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
        driver.switchTo().frame(0);
        driver.findElement(By.id("newPage")).click();
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());



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


