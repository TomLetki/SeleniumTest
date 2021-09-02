import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class browserSelect {

    @Test
    public void openBrowser(){
WebDriver driver = getDriver("chrome");
    }

public WebDriver getDriver(String browser){
        

        if(browser == "firefox"){
            System.setProperty("webdriver.gecko.driver","D:\\Szkolenie_tester\\Firefoxdriver\\geckodriver.exe");
            WebDriver driverFirefox = new FirefoxDriver();
            driverFirefox.get("https://www.google.com");
        }else if(browser == "chrome"){
            System.setProperty("webdriver.chrome.driver","D:\\Szkolenie_tester\\Chromedriver93/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
        }else if(browser == "edge"){
            System.setProperty("webdriver.edge.driver","D:\\Szkolenie_tester\\Edgedriver\\msedgedriver.exe");
            WebDriver driverEdge = new EdgeDriver();
            driverEdge.get("https://www.google.com");
        }else{
            throw new InvalidArgumentException("Tomek say: Invalid browser name");
        }
    return null;
}

}

