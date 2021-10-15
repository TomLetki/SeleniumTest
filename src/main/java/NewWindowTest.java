import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {

        @Test
        public void testNewWindow() throws InterruptedException {
            WebDriver driver = getDriver("chrome");
            driver.manage().window().maximize();
            driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
            String currentWinow = driver.getWindowHandle();
            driver.findElement(By.id("newPage")).click();
            Set<String> windowNames = driver.getWindowHandles();
            for (String window : windowNames){
                if(!window.equals(currentWinow)){
                    driver.switchTo().window(window);
                }
            }
            Thread.sleep(1000);
           driver.findElement(By.id("L2AGLb")).click();
           driver.findElement(By.name("q")).sendKeys("Selenium");
           driver.switchTo().window(currentWinow);
           driver.findElement(By.name("fname")).sendKeys("Tomato");


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

