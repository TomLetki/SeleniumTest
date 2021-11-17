package pl.testeroprogramowania;

import org.testng.annotations.Test;

public class ThirdTest {

    @Test(priority = 2) //idzie na końcu
    public void firstTest(){
        System.out.println("ThirdClass is running firstTest");
    }
    @Test(priority = 0) //idzie pierwszy
    public void secondTest(){
        System.out.println("ThirdClass is running secondTest");
    }
    @Test(priority = 1) //idzie drugi
    public void thirdTest(){
        System.out.println("ThirdClass is running thirdTest");
    }

}
