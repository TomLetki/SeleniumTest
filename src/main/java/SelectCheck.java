import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectCheck {

    public boolean findInSelect(String optionText, WebElement elementName){
        Select listPosition = new Select(elementName);
        List<WebElement> options =listPosition.getOptions();
        for(WebElement option :options){
            if(option.getText().equals(optionText))
                return true;
        }
        return false;
    }
}
