import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicActionsTest {

    @Test
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicPageLink = driver.findElement(By.linkText(("Podstawowa strona testowa")));
        basicPageLink.click();
        driver.findElement(By.id("fname")).sendKeys("Passierte Tomaten");
        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("Admin");




    }
}
