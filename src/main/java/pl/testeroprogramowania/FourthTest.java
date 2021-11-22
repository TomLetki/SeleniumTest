package pl.testeroprogramowania;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FourthTest {

    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest(){
        System.out.println("ThirdClass is running firstTest");
    }
    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest(){
        System.out.println("ThirdClass is running secondTest");
    }
    @Test
    public void thirdTest(){
        System.out.println("ThirdClass is running thirdTest");
    }

    @Test(dataProvider = "data")
    public void datProvTest(String value, String number){
        System.out.println(value);
        System.out.println(number);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider(){
        return new Object[][]{{"I am first test", "First"},{"I am second test","Second"},{"I am third Test","Third"}};
    }

}
