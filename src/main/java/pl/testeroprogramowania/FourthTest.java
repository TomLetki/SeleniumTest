package pl.testeroprogramowania;

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

}
