package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.DashboardPage;
import pages.GiftingPage;
import pages.LoginPage;
import pages.SquadPage;
import utility.AllureReport;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class dashboard extends BaseTest {
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private GiftingPage giftingPage;
	private SquadPage squadPage;


	@BeforeMethod
	public void setupTests() {
		super.setup();
		loginPage = new LoginPage(driver);
		driver.navigate().to(baseURL + "/login");
		dashboardPage = loginPage.nativeLogin(userEmail, userPassword);
		//driver.navigate().refresh();
	}

	@AfterMethod
	public void clearTests() throws InterruptedException {
		AllureReport.Screenshot(driver, this.getClass().getName());
		driver.quit();
	}

	@Test(description = "Test:Purchase SGC through card")
	public void purchaseSGCThroughCard() throws InterruptedException {
		dashboardPage.clickLaterOnPendingGiftsPopup();
		Random rand = new Random();
		int maxSGC = 100;
		int n = rand.nextInt(maxSGC);
		String sgc = String.valueOf(n);
		dashboardPage.addAmount(sgc);
		dashboardPage.clickCalculate();
		dashboardPage.clickPurchaseAgreement();
		dashboardPage.clickCheckOut();
		Thread.sleep(10000);
		String url = driver.getCurrentUrl();
		if (!url.contains("checkout.stripe.com")) {
			System.out.println("Error : The payment page is not opening");
			Assert.fail();
		}
		dashboardPage.closeTab();
	}

	@Test(description = "Test:Calculate SGC details and verify calculation")
	public void verifySGCCalculation() {
		dashboardPage.clickLaterOnPendingGiftsPopup();
		Random rand = new Random();
		int maxSGC = 100;
		int n = rand.nextInt(maxSGC);
		String sgc = String.valueOf(n);
		dashboardPage.addAmount(sgc);
		dashboardPage.clickSelectCurrency();
		dashboardPage.clickGbd();
		dashboardPage.clickCalculate();
		String amount = dashboardPage.getResultAmount().replace(",", "");
		Assert.assertEquals(amount, String.valueOf(n * 40));
		dashboardPage.clickUSD();
		dashboardPage.clickCalculate();
		amount = dashboardPage.getResultAmount().replace(",", "");
		Assert.assertEquals(amount, String.valueOf(n * 50));
		dashboardPage.clickEURO();
		dashboardPage.clickCalculate();
		amount = dashboardPage.getResultAmount().replace(",", "");
		Assert.assertEquals(amount, String.valueOf(n * 45));
	}

	@Test(description = "Test:Click On blogs, verifying if it is taking to blogs page")
	public void verifyIfBlogLeadToBlogsPage() {
		dashboardPage.clickLaterOnPendingGiftsPopup();
		dashboardPage.clickFirstBlog();
		String url = dashboardPage.getNextTabUrl();
		if (!url.contains("blog")) {
			System.out.println("Error : Blogs page is not opening");
			Assert.fail();
		}
		dashboardPage.closeTab();
	}

	@Test(description = "Test:Click On find out how , verifying if it is taking to squads Create page")
	public void verifyIfClickOnFindOutHowLeadsToSquadsPage() {
		dashboardPage.clickLaterOnPendingGiftsPopup();
		squadPage = dashboardPage.clickOnFindOutHowButton();
		if (squadPage.isSquadCreatePage()) {
			System.out.println("Squad Create Page Opened");
		} else {
			System.out.println("ERROR: It should Open Squad Create Page, But Not opened now.");
			Assert.fail();
		}
	}

	@Test(description = "Test:Click On GiftCard, verifying if it is taking to gifting page")
	public void verifyIfClickOnGiftCardLeadsToGiftingPage() {
		dashboardPage.clickLaterOnPendingGiftsPopup();
		dashboardPage.clickFirstGiftCard();
		String url = dashboardPage.getCurrentUrl();
		if (!url.contains("gift")) {
			System.out.println("Error : Gifting card is not leading to gift page");
			Assert.fail();
		}
		dashboardPage.closeTab();
	}

	@Test(description = "Test:Click on Facebook Icon on Footer, verify if it is taking to facebook page or not.")
	public void verifyIfFacebookIconLeadsToFacebookPage() {
		dashboardPage.clickLaterOnPendingGiftsPopup();
		dashboardPage.clickOnFacebookIcon();
		String url = dashboardPage.getNextTabUrl();
		if (!url.contains("facebook")) {
			System.out.println("Error : Facebook icon is not leading to facebook page");
			Assert.fail();
		}
		dashboardPage.closeTab();
	}

	@Test(description = "Test:Click on Instagram Icon on Footer, verify if it is taking to instagram page or not.")
	public void verifyIfInstagramIconLeadsToInstagramPage() {
		dashboardPage.clickLaterOnPendingGiftsPopup();
		dashboardPage.clickOnInstagramIcon();
		String url = dashboardPage.getNextTabUrl();
		if (!url.contains("instagram")) {
			System.out.println("Error : Instagram icon is not leading to instagram page");
			Assert.fail();
		}
		dashboardPage.closeTab();
	}

	@Test(description = "Test:Click on youtube Icon on Footer, verify if it is taking to youtube page or not.")
	public void verifyIfYoutubeIconLeadsToYoutubePage() {
		dashboardPage.clickLaterOnPendingGiftsPopup();
		dashboardPage.clickOnYoutubeIcon();
		String url = dashboardPage.getNextTabUrl();
		if (!url.contains("youtube")) {
			System.out.println("Error : Youtube icon is not leading to youtube page");
			Assert.fail();
		}
		dashboardPage.closeTab();
	}

	@Test(description = "Test if sacred groves video is working")
	public void verifyIfSacredGrovesVideoWorking() {
		dashboardPage.clickLaterOnPendingGiftsPopup();
		try {
			dashboardPage.clickOnSacredGrovesVideo();
		} catch (Exception e) {
			System.out.println("Error : Video not playing");
		}
	}

	@Test(description = "Test:Popup of pending gifts is working")
	public void pendingGiftsPopupIsWorking() {
		if (dashboardPage.isPendingGiftsPopupPresent()){
			dashboardPage.clickShowOnPendingGiftsPopup();
			String url = dashboardPage.getCurrentUrl();
			if (!url.contains("gifting")) {
				System.out.println("Error : Pending gifts popup is not working");
				Assert.fail();
			}
		}
		else {
			System.out.println("Pending gifts popup is not present");
		}

	}
}

