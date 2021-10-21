import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicsGeneralTest {


    @Test
    public void basicsTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.tagName("h1"));
        actions.moveToElement(heading).perform();
/*
        WebElement button1 = driver.findElement(By.id("clickOnMe"));
            button1.click();
            Thread.sleep(1000);
            driver.switchTo().alert().accept();

        WebElement firstInput = driver.findElement(By.id("fname"));
            firstInput.sendKeys("Nowa Wartość input");
            Thread.sleep(1000);
            firstInput.clear();

        WebElement firstLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
            System.out.println(firstLink.getText());
            firstLink.click();
            driver.navigate().back();
        WebElement secondLink = driver.findElement(By.linkText("IamWeirdLink"));
            System.out.println(secondLink.getText());
            secondLink.click();
            driver.navigate().back();

        WebElement tableTr = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]"));
            System.out.println(tableTr.getText());
        WebElement tableTd = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]"));
            System.out.println(tableTd.getText());

        //sprawdzanie listy select
        WebElement carSelectList = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(carSelectList);
            cars.selectByValue("mercedes");
                Thread.sleep(500); // pozwala zobaczyć wybór z listy select
            cars.selectByValue("audi");
                Thread.sleep(500);
            cars.selectByValue("saab");
                Thread.sleep(500);
            cars.selectByValue("volvo");

        //opcjonalne wyświeltlenie listy select
        List<WebElement> options = cars.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
*/
        WebElement checkBox = driver.findElement(By.cssSelector("[type=checkbox]"));
        checkBox.click();
        Thread.sleep(500);
        checkBox.click();//drugi click czyści checkboxa

        driver.findElement(By.cssSelector("[value=male]")).click();
        driver.findElement(By.cssSelector("[value=female]")).click();
        driver.findElement(By.cssSelector("[value=other]")).click();

        WebElement inputUser = driver.findElement(By.name("username"));
            inputUser.clear();
            inputUser.sendKeys("Testowy");
            System.out.println(inputUser.getAttribute("value"));
        WebElement inputPass = driver.findElement(By.name("password"));
            inputPass.clear();
            inputPass.sendKeys("haslo");
            System.out.println(inputPass.getAttribute("value"));
            //inputPass.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("[type=submit]")).click();
        //pierwszy alert
            Alert alert = driver.switchTo().alert();
            alert.accept();
        //drugi alert
            driver.switchTo().alert().accept();

        }
    }


