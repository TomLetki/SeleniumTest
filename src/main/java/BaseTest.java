import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {


@BeforeTest
    public void beforeTest(){
        System.out.println("running beforeTest");
    }

@BeforeMethod
    public void beforeMethod(){
        System.out.println("running beforeMethod");
    }
}
