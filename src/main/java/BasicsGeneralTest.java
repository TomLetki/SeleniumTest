import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class BasicsGeneralTest {


    @Test
    public void basicsTest() throws InterruptedException {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //Wyświetlenie adresu i tytułu strony
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.tagName("h1"));
        actions.moveToElement(heading).perform();

        WebElement button1 = driver.findElement(By.id("clickOnMe"));
            button1.click();
            Thread.sleep(1000);
            driver.switchTo().alert().accept();

        WebElement firstInput = driver.findElement(By.id("fname"));
            firstInput.sendKeys("Nowa wartość input");
            Thread.sleep(500);
            firstInput.clear();

        //Klikanie w linki i powrót do strony basics.html
        WebElement firstLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
            System.out.println(firstLink.getText());
            firstLink.click();
            driver.navigate().back();
        WebElement secondLink = driver.findElement(By.linkText("IamWeirdLink"));
            System.out.println(secondLink.getText());
            secondLink.click();
            driver.navigate().back();

        //WYświetlanie zawartości tabeli
        WebElement tableTr = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]"));
            System.out.println(tableTr.getText());
        WebElement tableTd = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]"));
            System.out.println(tableTd.getText());

        //sprawdzanie listy select
        WebElement carSelectList = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(carSelectList);
            cars.selectByValue("mercedes");
                Thread.sleep(500); // sleep jest tylko dla lepszego efektu wizualnego
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

        //Zaznaczenie i odznaczenie checkboxa
        WebElement checkBox = driver.findElement(By.cssSelector("[type=checkbox]"));
        checkBox.click();
        Thread.sleep(500);
        checkBox.click();//drugi click czyści checkboxa

        driver.findElement(By.cssSelector("[value=male]")).click();
        driver.findElement(By.cssSelector("[value=female]")).click();
        driver.findElement(By.cssSelector("[value=other]")).click();

        //uzupełnienie inputów: Nazwa użytkowanika i hasło
        WebElement inputUser = driver.findElement(By.name("username"));
            inputUser.clear();
            inputUser.sendKeys("Testowy");
            System.out.println(inputUser.getAttribute("value"));
        WebElement inputPass = driver.findElement(By.name("password"));
            inputPass.clear();
            inputPass.sendKeys("haslo");
            System.out.println(inputPass.getAttribute("value"));
            //inputPass.sendKeys(Keys.ENTER);

        //sprawdzenie działania przycisku "submit"
        driver.findElement(By.cssSelector("[type=submit]")).click();
            //pierwszy alert
            Alert alert = driver.switchTo().alert();
            alert.accept();
            //drugi alert
            driver.switchTo().alert().accept();

        //odnalezienie obrazka na stronie
        driver.findElement(By.xpath("//*[@id='smileImage']"));

        //Kliknięcie w przycisk ClickMe otwierający nowe okno
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        Set<String> windowNames = driver.getWindowHandles();
        for(String window : windowNames){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }
        Thread.sleep(500);
        driver.close(); //zamyka nowe okno
        driver.switchTo().window(currentWindow);

        //elementy ukryte
        WebElement paragraph = driver.findElement(By.className("topSecret")); // można też przez selector ".topSecret"
        System.out.println(paragraph.getAttribute("textContent"));

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By nthChild = By.cssSelector("li:nth-child(2)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(nthChild);


        }



    public WebDriver getDriver(String browser){
        return switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new InvalidArgumentException("Nieznana przegladarka lub błąd nazwy");
        };
    }
    }


