package pl.testeroprogramowania;

import org.testng.annotations.*;

public class BaseTest {

@BeforeSuite
    public void beforeSuite(){
        System.out.println("running beforeSuite");
    }

@BeforeClass
    public void beforeClass(){
        System.out.println("running beforeClass");
    }

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
    System.out.println("I'm running after method"); }


@AfterSuite
    public void afterSuite(){
        System.out.println("running afterSuite");
    }

@AfterClass
    public void afterClass(){
        System.out.println("running afterClass");
    }

}



