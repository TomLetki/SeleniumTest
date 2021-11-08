import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

@Test
public class OpenMeteo {


    public void meteoPl() throws InterruptedException {

        WebDriver driver = getdriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.meteo.pl");
            FluentWait <WebDriver> wait = new FluentWait<>(driver);
            wait.ignoring(NoSuchElementException.class);
            wait.withTimeout(Duration.ofSeconds(10));
            wait.pollingEvery(Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".css-1udxr57")));
        //Thread.sleep(1000);
        WebElement agreeButton = driver.findElement(By.cssSelector(".css-1udxr57"));
        agreeButton.click();
        WebElement umButton = driver.findElement(By.cssSelector("#tab_um"));
        umButton.click();
        Thread.sleep(3000);

        WebElement inputND = driver.findElement(By.name("N_DEG"));
        inputND.sendKeys("49");
        WebElement inputNM = driver.findElement(By.name("N_MIN"));
        inputNM.sendKeys("54");
        WebElement inputED = driver.findElement(By.name("E_DEG"));
        inputED.sendKeys("10");
        WebElement inputEM = driver.findElement(By.name("E_MIN"));
        inputEM.sendKeys("54");
        WebElement schowButton = driver.findElement(By.xpath("//*[@id=\"kon_3c_b\"]/div[2]/div/table/tbody/tr[2]/td/div/form/table/tbody/tr[2]/td[7]/div/a"));
        schowButton.click();
        driver.close();



    }

    public WebDriver getdriver(String browser){
        return switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new InvalidArgumentException("Nieznana przegladarka lub błąd nazwy");
        };
    }
}
