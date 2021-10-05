import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {
@Test
public void findElements(){
    WebDriver driver = getDriver("chrome");
    driver.manage().window().maximize();
    driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

   // driver.findElement(By.id("clickOnMe"));
    By buttonId = By.id("clickOnMe");
    WebElement clickOnMeButton = driver.findElement(buttonId);

    By firstName = By.name("fname");
    WebElement firstNameInput = driver.findElement(firstName);

    By paraHidden = By.className("topSecret");
    WebElement findClassName = driver.findElement(paraHidden);

    By inputLocator = By.tagName("input");
    WebElement input = driver.findElement(inputLocator);
    input.sendKeys("pierwszy");
    List<WebElement> inputs = driver.findElements(inputLocator);
    System.out.println(inputs.size());

    By linkText = By.linkText("Visit W3Schools.com!");
    WebElement schoolLink = driver.findElement(linkText);

    By partialLink = By.partialLinkText("W3S");
    WebElement partW3 = driver.findElement(partialLink);



}




    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver","D:\\Szkolenie_tester\\Edgedriver\\msedgedriver.exe");
                return new EdgeDriver();
            default:
                throw new InvalidArgumentException("nieznana przeglądarka");
        }
    }
}
