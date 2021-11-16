import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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


@AfterTest
public void afterTest() {
    System.out.println("running after test");
}

@AfterMethod
    public void afterMethod(){
    System.out.println("I'm running after method");
}
}



