import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class browserSelectCase {

    @Test
    public void openBrowser() {
        WebDriver driver = getDriver("edge");
    }

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
               // String pathC = "D:\\Szkolenie_tester\\Chromedriver93\\chromedriver.exe";
                //System.setProperty("webdriver.chrome.driver", pathC);
                //WebDriver driverChrome = new ChromeDriver();
                //driverChrome.get("https://www.google.com");
                return new ChromeDriver();
            case "firefox":
                //String pathF = "D:\\Szkolenie_tester\\Firefoxdriver\\geckodriver.exe";
                //System.setProperty("webdriver.gecko.driver", pathF);
                //WebDriver driverFirefox = new FirefoxDriver();
                //driverFirefox.get("https://www.google.com");
                return new FirefoxDriver();
            case "edge":
                //String pathE = "D:\\Szkolenie_tester\\Edgedriver\\msedgedriver.exe";
                //System.setProperty("webdriver.edge.driver", pathE);
                return new EdgeDriver();
                //WebDriver driverEdge = new EdgeDriver();
                //driverEdge.get("https://www.google.com");

            default:
                throw new InvalidArgumentException("Nieznana przeglądarka");
        }
    }
}
