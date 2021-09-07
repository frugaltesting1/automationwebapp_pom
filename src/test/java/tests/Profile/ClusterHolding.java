package tests.Profile;

import base.BaseTest;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProfilePage;
import utility.AllureReport;

public class ClusterHolding extends BaseTest {
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
    public void clickCluster(){
            profilePage.openClusterSection();
            profilePage.clickFirstCluster();
            profilePage.goBackCluster();

    }

    @Test
    public void downloadCluster(){
        profilePage.openClusterSection();
        profilePage.clickDownloadCluster();
    }

    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }
}
