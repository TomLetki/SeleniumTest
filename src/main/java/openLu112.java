import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@Test
public class openLu112 {

    public void lublin112Pl() throws InterruptedException{
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.lublin112.pl/");
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        
        WebElement agreButton = driver.findElement(By.xpath("////span[contains(text(),'Zaakceptuj')]"));
        agreButton.click();

    }
    public WebDriver getDriver(String browser){
        return switch (browser){
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new InvalidArgumentException("Popraw nazwę lub brak przeglądarki");
        };
    }


    }

