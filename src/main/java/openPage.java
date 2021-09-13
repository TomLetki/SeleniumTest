import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class openPage {

    @Test
    public void open(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement agreeButton = driver.findElement(By.xpath("//div[contains(text(),'Zgadzam')]"));
        agreeButton.click();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("nagi prokurator");
        searchField.sendKeys(Keys.ENTER);


    }
}
