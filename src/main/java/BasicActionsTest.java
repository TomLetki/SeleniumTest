import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    @Test
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/");


        WebElement basicPageLink = driver.findElement(By.linkText(("Podstawowa strona testowa")));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();
        driver.findElement(By.id("fname")).sendKeys("Passierte Tomaten");
        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("Administrator");
        System.out.println(userNameInput.getAttribute("value")); // pobranie wartości z pola
        userNameInput.sendKeys(Keys.ENTER);
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        driver.switchTo().alert().accept();

        //userNameInput.sendKeys(Keys.TAB);
       // driver.findElement(By.name("password")).sendKeys(Keys.TAB);

        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='other']")).click();

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        //cars.selectByIndex(1);
        //cars.selectByVisibleText("Saab"); //duża litera
        cars.selectByValue("mercedes"); //mała litera
        List<WebElement> options = cars.getOptions();
        for (WebElement option : options){
            System.out.println(option.getText());
        }

        SelectCheck selecktCheck = new SelectCheck();
        System.out.println(selecktCheck.findInSelect("Audi",selectCar));
        System.out.println(selecktCheck.findInSelect("Skoda", selectCar));

    WebElement paragraph = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By text :" +paragraph.getText());
        System.out.println("By atribute value :" +paragraph.getAttribute("value"));
        System.out.println("By atribute textContent :" +paragraph.getAttribute("textContent")); //ten działa z uktytym


    }
}
