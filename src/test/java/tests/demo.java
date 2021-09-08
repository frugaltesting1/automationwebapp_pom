package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.AllureReport;

public class demo  extends BaseTest {


    @BeforeMethod
    public void setup() {
        System.out.println("Before Test");
    }

    @Test
    public void demoTest1() {
        System.out.println("Running Test");
    }

    @Test
    public void demoTest2() {
        System.out.println("Running Test");
        Assert.fail();
    }

    @AfterMethod
    public void close() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        System.out.println("After Test");
    }


}
