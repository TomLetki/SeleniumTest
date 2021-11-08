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
        Thread.sleep(5000);
        //driver.switchTo().frame(0);
        
        //WebElement agreeButton = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[3]/div[2]/button/span[1]"));
        WebElement agreeButton = driver.findElement(By.cssSelector("#oa-360-1636117039110_x8gzyhsxv > div > div > div > div > div > div.ZeroLayer__light___1gMfV0.ZeroLayer__zeroLayer___2R20B_ > div:nth-child(2) > button > span.MuiButton-label"));
        agreeButton.click();

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

