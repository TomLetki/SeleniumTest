import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {


    @Test
    public void openBrowser() throws InterruptedException {
 //WebDriverManager.firefoxdriver().setup();
 //WebDriver driver = new FirefoxDriver();

WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);        //headless - praca w tle gry "true". Bez interfejsu użytkownika.
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("alert('error')");
        driver.manage().window().maximize();
        driver.get("https://google.com");


/*WebDriver driver = new ChromeDriver();
Dimension windowSize = new Dimension(640,480);
driver.manage().window().maximize();
driver.manage().window().setSize(windowSize);
driver.get("https://www.facebook.com");
JavascriptExecutor executor = (JavascriptExecutor) driver;
executor.executeScript("window.open('https://www.google.com','blank','height=300, width=300')");
driver.close();
//WebDriverManager.edgedriver().setup();
//WebDriver driverEd = new EdgeDriver();*/
    }
}
