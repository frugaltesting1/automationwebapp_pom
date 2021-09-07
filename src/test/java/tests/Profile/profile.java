package tests.Profile;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utility.AllureReport;

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

    @Test
    public void isProfilePageVisible() throws Exception {
       if(!profilePage.isProfilePage()){
           Assert.fail();
       };
    }

    @Test
    public void checkInterestSection() throws Exception {
        profilePage.openInterestSection();
        if(!profilePage.isInterestSectionVisible()){
            Assert.fail();
        }
        reload();
    }

    @Test
    public void checkActivitySection() throws Exception {
        profilePage.openActivitySection();
        if(!profilePage.isActivitySectionVisible()){
            Assert.fail();
        }
        reload();
    }

    @Test
    public void checkClusterHoldingSection() throws Exception {
        profilePage.openClusterSection();
        if(!profilePage.isClusterHoldingSectionVisible()){
            Assert.fail();
        }
        reload();

    }

    @Test
    public void checkTransactionSection() throws Exception {
        profilePage.openTransactionSection();
        if(!profilePage.isTransactionSectionVisible()){
            Assert.fail();
        }
        reload();

    }

    @Test
    public void checkEmailPrefSection() throws Exception {
        profilePage.openEmailPrefSection();
        if(!profilePage.isEmailPrefSectionVisible()){
            Assert.fail();
        }
        reload();

    }

    @Test
    public void checkCaliforniaSection() throws Exception {
        profilePage.openCaliforniaSection();
        if(!profilePage.isCaliforniaSectionVisible()){
            Assert.fail();
        }
        reload();

    }

    @Test
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


