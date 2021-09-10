import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Dialect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class seleniumTest {
    //   public static void main(String[] args) {
    //       WebDriver driver = new FirefoxDriver();
    //   }

    @Test
    public void openGooglePage() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.switchTo().frame(0);
        //przepięcie  do okna z cookie
        WebElement agreeButton = driver.findElement(By.xpath("//span[contains(text(),'Zgadzam')]"));
        //znalezienie przycisku
        agreeButton.click();
        //kliknięcie przycisku
        driver.switchTo().defaultContent(); // powrot do okna pierwotnego
        //znajdź pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        //wyszukiwana wartość
        searchField.sendKeys(Keys.ENTER);
        //zasymuluj naciśnięcie Enter
        WebElement result = driver.findElement(By.xpath("//a[contains(@chref,'selenium.dev')]//span"));
        //Znaleźć rezultat
        Assert.assertTrue(result.isDisplayed());

    }


    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new InvalidArgumentException("nieznana przeglądarka");
        }
    }
}