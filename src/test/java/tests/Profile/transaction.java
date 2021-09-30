package tests.Profile;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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


    @Test(description="Test:opening Transaction")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This story belongs to the transaction flow")
    public void clickTransaction(){
        profilePage.openTransactionSection();
        profilePage.clickFirstTransaction();
        profilePage.goBackTransaction();
    }

    @Test(description="Test:downloading Transaction")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the transaction flow")
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