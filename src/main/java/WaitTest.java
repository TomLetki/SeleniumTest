import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitTest {
    WebDriver driver;

    @Test
    public void waitTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Timeout do całego kodu.
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();


      //  WebDriverWait wait = new WebDriverWait(driver, 10);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        //WebElement para = driver.findElement(By.cssSelector("p"));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p"))));
        //wait.until(ExpectedConditions.visibilityOf(para)));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("pa")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p")));
       // wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("checkbox")));

       // driver.findElement(By.cssSelector("p"));
        waitForElement(By.cssSelector("p"));
    }

    public void waitForElement(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(locator);
                if(elements.size()>0) {
                    System.out.println("Element jest na stronie");
                    return true;
                }else {
                    System.out.println("Elementu nie ma ma stronie");
                    return false;
                }


            }
        });
    }
}