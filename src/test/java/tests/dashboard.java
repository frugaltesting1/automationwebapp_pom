package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.DashboardPage;
import pages.GiftingPage;
import pages.LoginPage;
import pages.SquadPage;
import utility.AllureReport;

public class dashboard extends BaseTest {
	
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
		driver.navigate().refresh();
	}
	
	@AfterMethod
	public void clearTests() throws InterruptedException {
		AllureReport.Screenshot(driver,this.getClass().getName());
		driver.quit();
	}
	
	@Test(description="Test:Purchase SGC through card")
	public void purchaseSGCThroughCard() {
		dashboardPage.addAmount("10");
		dashboardPage.clickPurchaseAgreement();
		dashboardPage.clickCheckOut();
	}
	
	@Test(description="Test:Calculate SGC details and verify calculation")
	public void verifySGCCalculation() {
		dashboardPage.addAmount("10");
		dashboardPage.clickSelectCurrency();
		dashboardPage.clickGbd();
		dashboardPage.clickCalculate();

		Assert.assertEquals(dashboardPage.getResultAmount(),"400");

		dashboardPage.clickUSD();
		dashboardPage.clickCalculate();
		Assert.assertEquals(dashboardPage.getResultAmount(),"500");

		dashboardPage.clickEURO();
		dashboardPage.clickCalculate();
		Assert.assertEquals(dashboardPage.getResultAmount(),"450");

	}
	
	@Test(description="Test:Click On blogs, verifying if it is taking to blogs page")
	public void verifyIfBlogLeadToBlogsPage() {
		dashboardPage.clickFirstBlog();
		String url = dashboardPage.getNextTabUrl();
		if(!url.contains("blog")){
			Assert.fail();
		}
		dashboardPage.closeTab();
	}
	
	@Test(description="Test:Click On find out how , verifying if it is taking to squads Create page")
	public void verifyIfClickOnFindOutHowLeadsToSquadsPage() {
		
		squadPage = dashboardPage.clickOnFindOutHowButton();
		if(squadPage.isSquadCreatePage()) {
			System.out.println("Sqaud Create Page Opened");
		} else {
			System.out.println("ERROR: It should Open Squad Create Page, But Not opened now.");
			Assert.fail();
		}
	}
	
	@Test(description="Test:Click On GiftCard, verifying if it is taking to gifting page")
	public void verifyIfClickOnGiftCardLeadsToGiftingPage() {
		dashboardPage.clickFirstGiftCard();
		String url = dashboardPage.getCurrentUrl();
		if(!url.contains("gift")){
			Assert.fail();
		}
		dashboardPage.closeTab();
	}
	
	@Test(description="Test:Click on Facebook Icon on Footer, verify if it is taking to facebook page or not.")
	public void verifyIfFacebookIconLeadsToFacebookPage() {
		dashboardPage.clickOnFacebookIcon();
		String url = dashboardPage.getNextTabUrl();
		if(!url.contains("facebook")){
			Assert.fail();
		}
		dashboardPage.closeTab();
	}
	
	@Test(description="Test:Click on Instagram Icon on Footer, verify if it is taking to instagram page or not.")
	public void verifyIfInstagramIconLeadsToInstagramPage () {
		dashboardPage.clickOnInstagramIcon();
		String url = dashboardPage.getNextTabUrl();
		if(!url.contains("instagram")){
			Assert.fail();
		}
		dashboardPage.closeTab();
	}
	
	  
	
	@Test(description="Test:Click on youtube Icon on Footer, verify if it is taking to youtube page or not.")
	public void verifyIfYoutubeIconLeadsToYoutubePage() {
		dashboardPage.clickOnYoutubeIcon();
		String url = dashboardPage.getNextTabUrl();
		if(!url.contains("youtube")){
			Assert.fail();
		}
		dashboardPage.closeTab();
	}
}
