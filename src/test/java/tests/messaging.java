package tests;

import base.BaseTest;
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


    @Test
    public void sendMessage(){
        messagePage.clickFirstChat();
        messagePage.enterMessage("Test Message");
        messagePage.clickSendMessage();
        reload();
    }

    @Test
    public void sendMessageToFakeUser(){
         messagePage.clickAddNewMessage();
         messagePage.enterEmailID("fake@test.com");
         messagePage.clickAddButton();
         Assert.assertTrue(messagePage.isNoUserErrorShown());
         reload();
    }

    @Test
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
