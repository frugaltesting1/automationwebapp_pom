package tests.Squad;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SquadPage;
import utility.AllureReport;

public class squadsCreate extends BaseTest {

    private SquadPage squadsPage;

    @BeforeMethod
    public void setupTests() {
        super.setup();
        LoginPage loginPage = new LoginPage(driver);
        driver.navigate().to(baseURL+"/login");
        loginPage.nativeLogin(userEmail, userPassword);
        driver.navigate().to(baseURL+"/squad/create");
        squadsPage = new SquadPage(driver);
    }

    void reload(){
        driver.navigate().to(baseURL+"/squad/create");
    }

    @Test
    public void addFakeParticipant(){
        squadsPage.clickAddParticipant();
        squadsPage.addEmail("abc@test.com");
        squadsPage.clickAddButton();
        Assert.assertTrue(squadsPage.isShownFakeError());
        reload();
    }

    @Test
    public void addEmptyParticipant(){
        squadsPage.clickAddParticipant();
        squadsPage.addEmail("");
        squadsPage.clickAddButton();
        Assert.assertTrue(squadsPage.isShownEmptyError());
        reload();
    }

    @Test
    public void addInvalidEmail(){
        squadsPage.clickAddParticipant();
        squadsPage.addEmail("textxyz.com");
        squadsPage.clickAddButton();
        Assert.assertTrue(squadsPage.isShownEmptyError());
        reload();
    }

    @Test
    public void addRealParticipant() throws InterruptedException {
        squadsPage.clickAddParticipant();
        squadsPage.addEmail("ashwin@frugaltesting.com");
        squadsPage.clickAddButton();
        squadsPage.randomClick();
        squadsPage.enterName("Test Squad");
        squadsPage.clickAddIcon();
        squadsPage.clickFirstIcon();
        Thread.sleep(3000);
        squadsPage.clickRandomInterest();
        squadsPage.clickSubmit();
        squadsPage.clickOkPopUp();
        reload();
    }

    @Test
    public void addRealParticipantWithoutAddInterest() throws InterruptedException {
        squadsPage.clickAddParticipant();
        squadsPage.addEmail("ashwin@frugaltesting.com");
        squadsPage.clickAddButton();
        squadsPage.randomClick();
        squadsPage.enterName("Test Squad");
        squadsPage.clickAddIcon();
        squadsPage.clickFirstIcon();
        Thread.sleep(3000);
        squadsPage.clickSubmit();
        Assert.assertTrue(squadsPage.isInterestErrorShown());
        reload();
    }

    @Test
    public void addRealParticipantWithoutMember() throws InterruptedException {
        squadsPage.enterName("Test Squad");
        squadsPage.clickAddIcon();
        squadsPage.clickFirstIcon();
        Thread.sleep(3000);
        squadsPage.clickRandomInterest();
        squadsPage.clickSubmit();
        Assert.assertTrue(squadsPage.isMemberErrorShown());
        reload();
    }

    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }


}
