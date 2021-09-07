package tests.Profile;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProfilePage;
import utility.AllureReport;

public class transaction extends BaseTest {

    private ProfilePage profilePage;

    @BeforeMethod
    public void setupTests() {
        super.setup();
        LoginPage loginPage = new LoginPage(driver);
        driver.navigate().to(baseURL+"/login");
        loginPage.nativeLogin(userEmail, userPassword);
        driver.navigate().to(baseURL+"/user/profile");
        profilePage = new ProfilePage(driver);
    }


    @Test
    public void clickTransaction(){
        profilePage.openTransactionSection();
        profilePage.clickFirstTransaction();
        profilePage.goBackTransaction();
    }

    @Test
    public void downloadTransaction(){
        profilePage.openTransactionSection();
        profilePage.clickDownloadTransactions();
    }


    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }
}
