package tests;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MessagePage;
import utility.AllureReport;

public class messaging extends BaseTest {

    private MessagePage messagePage;

    @BeforeMethod
    public void setupTests() {
        super.setup();
        LoginPage loginPage = new LoginPage(driver);
        driver.navigate().to(baseURL+"/login");
        loginPage.nativeLogin(userEmail, userPassword);
        driver.navigate().to(baseURL+"/squad/chat");
        messagePage = new MessagePage(driver);
    }

    public void reload(){
        driver.navigate().to(baseURL+"/squad/chat");
    }


    @Test(description="Test:Sending message")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the messaging flow")
    public void sendMessage(){
        messagePage.clickFirstChat();
        messagePage.enterMessage("Test Message");
        messagePage.clickSendMessage();
        reload();
    }

    @Test(description="Test:Sending message to fake user")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the messaging flow")
    public void sendMessageToFakeUser(){
        messagePage.clickAddNewMessage();
        messagePage.enterEmailID("fake@test.com");
        messagePage.clickAddButton();
        Assert.assertTrue(messagePage.isNoUserErrorShown());
        reload();
    }

    @Test(description="Test:Sending message to Myself")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the messaging flow")
    public void sendMessageToMySelf(){
        messagePage.clickAddNewMessage();
        messagePage.enterEmailID(userEmail);
        messagePage.clickAddButton();
        Assert.assertTrue(messagePage.isSelfInviteErrorShown());
        reload();
    }

    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }

}