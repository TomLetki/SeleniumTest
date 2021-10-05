import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class XpathTest {
@Test
public void findElements() throws InterruptedException {
    WebDriver driver = getDriver("chrome");
    driver.manage().window().maximize();
    driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

    By buttonId = By.xpath("//button[@id='clickOnMe']");
    WebElement clickOnMeButton = driver.findElement(buttonId);

    By firstName = By.xpath("//input[@name='fname']");
    WebElement firstNameInput = driver.findElement(firstName);
    //firstNameInput.sendKeys("EGON ");
    //firstNameInput.sendKeys(Keys.ENTER);

    By paraHidden = By.xpath("//p[@class='topSecret']");
    WebElement findClassName = driver.findElement(paraHidden);

    By inputLocator = By.xpath("//input");
    WebElement input = driver.findElement(inputLocator);
    input.sendKeys("pierwszy");
    List<WebElement> inputs = driver.findElements(inputLocator);
    System.out.println(inputs.size());

    By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
    WebElement schoolLink = driver.findElement(linkText);

    By partialLink = By.xpath("//a[contains(text(),'W3S')]");
    WebElement partW3 = driver.findElement(partialLink);

    By fullPath = By.xpath("/html/body/div/ul");
    driver.findElement(fullPath);

    By shortPath = By.xpath("//ul");
    driver.findElement(shortPath);

    By allXpath = By.xpath("//*");
    driver.findElement(allXpath);

    By secondElemnt = By.xpath("(//input)[2]");
    driver.findElement(secondElemnt);

    By lastElement = By.xpath("(//input)[last()]");
    driver.findElement(lastElement);

    By elementWithAttribute = By.xpath("//*[@name]");
    driver.findElement(elementWithAttribute);

    By attrEq = By.xpath("//button[@id='clickOnMe']");
    By attrNotEq = By.xpath("//button[@id!='clickOnMe']");
    By attrContains = By.xpath("//*[contains(@name, 'ame')]");
    By startsWith = By.xpath("//*[starts-with(@name, 'user')]");
    By endsWith = By.xpath("//*[substring(@name, string-length(@name)-string-length('name')+1)='name']");

    driver.findElement(attrEq);
    driver.findElement(attrNotEq);
    driver.findElement(attrContains);
    driver.findElement(startsWith);
    driver.findElement(endsWith);

    By child = By.xpath("//div/child::ul");
    By desc = By.xpath("//div/descendant::ul");
    By parrent = By.xpath("//div/../..");
    By asc = By.xpath("//div/ancestor::*");
    By foll = By.xpath("//img/following::*");
    By follsibl = By.xpath("//img/following-sibling::*");
    By prec = By.xpath("//img/preceding::*");
    By precSib = By.xpath("//img/preceding-sibling::*");

    driver.findElement(child);
    driver.findElement(desc);
    driver.findElement(parrent);
    driver.findElement(asc);
    driver.findElement(foll);
    driver.findElement(follsibl);
    driver.findElement(prec);
    driver.findElement(precSib);





    Thread.sleep(2000);
    driver.close();




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
