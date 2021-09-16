package tests.Profile;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utility.AllureReport;
import Listeners.TestAllureListener;
@Listeners({TestAllureListener.class})
public class profile extends BaseTest {

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

    void reload() {
        driver.navigate().to(baseURL+"/user/profile");
    }

    @Test(description="Test:checking wether profile page is visible or not")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This story belongs to the profile flow")
    public void isProfilePageVisible() throws Exception {
        if(!profilePage.isProfilePage()){
            Assert.fail();
        };
    }

    @Test(description="Test:checking wether interest Section is visible or not")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This story belongs to the profile flow")
    public void checkInterestSection() throws Exception {
        profilePage.openInterestSection();
        if(!profilePage.isInterestSectionVisible()){
            Assert.fail();
        }
        reload();
    }

    @Test(description="Test:checking wether Activity Section is visible or not")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This story belongs to the profile flow")
    public void checkActivitySection() throws Exception {
        profilePage.openActivitySection();
        if(!profilePage.isActivitySectionVisible()){
            Assert.fail();
        }
        reload();
    }

    @Test(description="Test:checking cluster holding section holding or not")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This story belongs to the profile flow")
    public void checkClusterHoldingSection() throws Exception {
        profilePage.openClusterSection();
        if(!profilePage.isClusterHoldingSectionVisible()){
            Assert.fail();
        }
        reload();

    }

    @Test(description="Test:checking transaction section")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This story belongs to the profile flow")
    public void checkTransactionSection() throws Exception {
        profilePage.openTransactionSection();
        if(!profilePage.isTransactionSectionVisible()){
            Assert.fail();
        }
        reload();

    }

    @Test(description="Test:check email preference section")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This story belongs to the profile flow")
    public void checkEmailPrefSection() throws Exception {
        profilePage.openEmailPrefSection();
        if(!profilePage.isEmailPrefSectionVisible()){
            Assert.fail();
        }
        reload();

    }

    @Test(description="Test:check california section")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This story belongs to the profile flow")
    public void checkCaliforniaSection() throws Exception {
        profilePage.openCaliforniaSection();
        if(!profilePage.isCaliforniaSectionVisible()){
            Assert.fail();
        }
        reload();

    }

    @Test(description="Test:check Disclosure section")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This story belongs to the profile flow")
    public void checkDisclosureSection() throws Exception {
        profilePage.openDisclosureSection();
        if(!profilePage.isDisclosureSectionVisible()){
            Assert.fail();
        }
        reload();

    }


    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }
}