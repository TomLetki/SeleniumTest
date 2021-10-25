import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistTest {
    WebDriver driver

    @Test
    public void elementExistTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));


        driver.findElement(By.tagName("p"));
        driver.findElement(By.id("topSecret"));


    }

    public boolean elementExist(By locator){
        try {
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex) {
            return false;
        }
    }
}
