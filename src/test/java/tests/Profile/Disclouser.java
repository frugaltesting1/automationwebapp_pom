package tests.Profile;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProfilePage;
import utility.AllureReport;

public class Disclouser extends BaseTest {


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
    void openPrivacyPolicyLink(){
        profilePage.openDisclosureSection();
        profilePage.clickPrivacyPolicy();
        Assert.assertEquals(profilePage.getNextTabUrl(),"https://www.sacredgroves.earth/policy.php");
        profilePage.closeTab();
    }

    @Test
    void openCookiePolicy(){
        profilePage.openDisclosureSection();
        profilePage.clickCookiePolicy();
        Assert.assertEquals(profilePage.getNextTabUrl(),"https://www.sacredgroves.earth/terms-and-conditions.php#cookies");
        profilePage.closeTab();
    }

    @Test
    void openGuardianTermsAndConditions(){
        profilePage.openDisclosureSection();
        profilePage.clickGuardianTermsAndConditions();
        Assert.assertEquals(profilePage.getNextTabUrl(),"https://www.sacredgroves.earth/terms-and-conditions.php");
        profilePage.closeTab();
    }

    @Test
    void openDataSources(){
        profilePage.openDisclosureSection();
        profilePage.clickDataSources();
        Assert.assertEquals(profilePage.getNextTabUrl(),"https://www.sacredgroves.earth/assets/img/The%20Sacred%20Groves%20-%20Technology%20&%20Analytics.pdf");
        profilePage.closeTab();
    }

    @Test
    void openFinancialStatements(){
        profilePage.openDisclosureSection();
        profilePage.clickFinancialStatements();
        Assert.assertEquals(profilePage.getNextTabUrl(),"https://website.sacredgroves.earth/deeproots.php");
        profilePage.closeTab();
    }

    @Test
    void openCertificateIncorporation(){
        profilePage.openDisclosureSection();
        profilePage.clickCertificateIncorporation();
        Assert.assertEquals(profilePage.getNextTabUrl(),"https://www.sacredgroves.earth/assets/img/Certificate-of-Incorporation.pdf");
        profilePage.closeTab();
    }

    @Test
    void openIncorporationDocuments(){
        profilePage.openDisclosureSection();
        profilePage.clickIncorporationDocuments();
        Assert.assertEquals(profilePage.getNextTabUrl(),"https://www.sacredgroves.earth/assets/img/Incorporation-Documents.pdf");
        profilePage.closeTab();
    }

    @Test
    void openSurveyorReport(){
        profilePage.openDisclosureSection();
        profilePage.clickSurveyorReport();
        Assert.assertEquals(profilePage.getNextTabUrl(),"https://www.sacredgroves.earth/assets/img/Gigrin%20Prysg%20Report.pdf");
        profilePage.closeTab();
    }


    @Test
    void openSurveyorCoed(){
        profilePage.openDisclosureSection();
        profilePage.clickSurveyorCoed();
        Assert.assertEquals(profilePage.getNextTabUrl(),"https://www.sacredgroves.earth/assets/img/Coed%20Rhyal%20Report.pdf");
        profilePage.closeTab();
    }


    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }

}
