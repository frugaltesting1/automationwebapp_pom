package tests;

import org.testng.annotations.*;

import base.BaseTest;
import pages.DashboardPage;
import pages.GiftingPage;
import pages.LoginPage;
import pages.SquadPage;
import utility.AllureReport;

public class gifting extends BaseTest{
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private GiftingPage giftingPage;
	private SquadPage squadPage;

	
	@BeforeMethod
	public void setupTests() {
		super.setup();
		loginPage = new LoginPage(driver);
		driver.navigate().to(baseURL+"/login");
		dashboardPage = loginPage.nativeLogin(userEmail, userPassword);
		driver.navigate().to(baseURL+"/user/gifting");
		giftingPage = new GiftingPage(driver);
	}

	public void reLoad(){
		driver.navigate().to(baseURL+"/user/gifting");
	}
	
	@AfterMethod
	public void clearTests() {
		AllureReport.Screenshot(driver,this.getClass().getName());
		driver.quit();
	}
	
	@Test
	public void sendGiftThroughEmail() throws Exception {
		giftingPage.selectCard();
		giftingPage.enterInNameField("Ashwin");
		giftingPage.enterInEmailField("ashwin@frugalTesting.com");
		giftingPage.enterInMessageField("A random gift to ashwin");
		giftingPage.clickSendGiftButton();
		giftingPage.enterGiftAmount("1");
		giftingPage.clickSendGift();
		giftingPage.clickOk();
		reLoad();
	}
	
	@Test
	public void sendGiftThroughPhone() {
		giftingPage.selectCard();
		giftingPage.enterInNameField("Ashwin");
		giftingPage.enterInPhoneField("9551574355");
		giftingPage.enterInMessageField("A random gift to ashwin");
		giftingPage.clickSendGiftButton();
		giftingPage.enterGiftAmount("1");
		giftingPage.clickSendGift();
		giftingPage.clickOk();
		reLoad();
	}
	
	@Test
	public void sendGiftWithoutCardThroughPhone() {
		giftingPage.enterInNameField("Ashwin");
		giftingPage.enterInPhoneField("9551574355");
		giftingPage.enterInMessageField("A random gift to ashwin");
		giftingPage.clickSendGiftButton();
		giftingPage.enterGiftAmount("1");
		giftingPage.clickSendGift();
		giftingPage.clickOk();
		reLoad();

	}
//
	@Test
	public void sendGiftWithoutCardThroughEmail() throws Exception {
		giftingPage.enterInNameField("Ashwin");
		giftingPage.enterInEmailField("ashwin@frugalTesting.com");
		giftingPage.enterInMessageField("A random gift to ashwin");
		giftingPage.clickSendGiftButton();
		giftingPage.enterGiftAmount("1");
		giftingPage.clickSendGift();
		giftingPage.clickOk();
		reLoad();
	}

	@Test
	public void sendGiftWithoutMessageThroughPhone() throws Exception {
		giftingPage.selectCard();
		giftingPage.enterInNameField("Ashwin");
		giftingPage.enterInPhoneField("9551574355");
		giftingPage.clickSendGiftButton();
		giftingPage.enterGiftAmount("1");
		giftingPage.clickSendGift();
		giftingPage.clickTryAgain();
		reLoad();
	}

	@Test
	public void sendGiftWithoutMessageThroughEmail() throws Exception {
		giftingPage.selectCard();
		giftingPage.enterInNameField("Ashwin");
		giftingPage.enterInEmailField("ashwin@frugalTesting.com");
		giftingPage.clickSendGiftButton();
		giftingPage.enterGiftAmount("1");
		giftingPage.clickSendGift();
		giftingPage.clickTryAgain();
		reLoad();
	}

	@Test
	public void sendGiftsThroughEmailWithPayNow(){
		giftingPage.enterInNameField("Ashwin");
		giftingPage.enterInEmailField("ashwin@frugalTesting.com");
		giftingPage.enterInMessageField("A random gift to ashwin");
		giftingPage.addClusterAmount("100");
		giftingPage.clickCheckOutCheckBox();
		giftingPage.clickCheckOutButton();
		reLoad();
	}

	@Test
	public void sendGiftsThroughPhoneWithPayNow() {
		giftingPage.enterInNameField("Ashwin");
		giftingPage.enterInPhoneField("9551574355");
		giftingPage.enterInMessageField("A random gift to ashwin");
		giftingPage.addClusterAmount("100");
		giftingPage.clickCheckOutCheckBox();
		giftingPage.clickCheckOutButton();
		reLoad();
	}

}
