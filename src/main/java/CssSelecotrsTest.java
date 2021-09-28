import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelecotrsTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe"); //# id
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret"); // .klasa
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("pierwszy_1");

        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        By cssClass2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);

        By all = By.cssSelector("*");
        driver.findElement(all);

        By ulInDiv = By.cssSelector("div ul");
        By trInTab = By.cssSelector("table tr");
        By trInBody = By.cssSelector("body tr");
        driver.findElements(ulInDiv);
        driver.findElements(trInTab);
        driver.findElements(trInBody);

        By firstChildUlInDiv = By.cssSelector("div>ul");
        By firstChildTrInTbody = By.cssSelector("tbody > tr");

        driver.findElement(firstChildUlInDiv);
        driver.findElement(firstChildTrInTbody);

         By firstFormAfterLabel = By.cssSelector("label + form");
         By allFormAfterLabel = By.cssSelector("label ~ form");

         driver.findElement(firstFormAfterLabel);
         driver.findElement(allFormAfterLabel);

         By attrTag = By.cssSelector("input[name = 'fname']");
         By attrCont = By.cssSelector("[name*='name']"); //zawiera ciąg name
         By attrStarts = By.cssSelector("[name^='f']"); //zaczyna się od f
         By attrEnds = By.cssSelector("[name$='name']"); //kończy się na name

        driver.findElement(attrTag);
        driver.findElement(attrCont);
        driver.findElement(attrStarts);
        driver.findElement(attrEnds);

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By nthChild = By.cssSelector("li:nth-child(3)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(nthChild);





    }
}
