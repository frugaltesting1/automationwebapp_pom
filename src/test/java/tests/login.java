package tests;


import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.*;
import utility.AllureReport;
import utility.TwilioService;

public class login extends BaseTest {
	
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private TwilioService twilioService = new TwilioService();

	
	@BeforeMethod
	public void setupTests() {
		super.setup();
		loginPage = new LoginPage(driver);
		driver.navigate().to(baseURL+"/login");
	}
	
	@AfterMethod
	public void clearTests() {
		AllureReport.Screenshot(driver,this.getClass().getName());
		driver.quit();
	}

	
	
	@Test(description="Test:Login Test With Correct Details")
	public void loginWithCorrectDetails() {
		dashboardPage = loginPage.nativeLogin(userEmail,userPassword);
		if(dashboardPage.isDashboardPage()) {
			System.out.println("Successfully Logged In and Redirected to Dashboard Page");
		} else {
			System.out.println("Unable to Login or Not redirected to DashboardPage");
		}
	}
	
	
	@Test(description="Test:Login Test With Wrong Details")
	public void loginWithWrongDetails() {
		loginPage.nativeLogin("wrong@email.com","wrongpassword");
		if(!loginPage.verifyWrongUserNameOrPasswordPopup()) {
			System.out.println("Error: No Popup for Wrong Username and password");
		}
		
	}

	@Test
	public void forgotPassword(){
		loginPage.clickForgetPassword();
		loginPage.clickSelectCountryButton();
		loginPage.setPhoneNumber(twilioService.phoneNumber);
		loginPage.selectCountryCode(twilioService.countryCode);
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isOkPopUpShown());
		loginPage.clickOkPopUp();
		loginPage.enterOtp(twilioService.getOtp());
		loginPage.clickSubmitButton();

		loginPage.enterNewPassword("Ashwin@123");
		loginPage.enterRePassword("Ashwin@123");

		loginPage.clickSubmitButton();

		Assert.assertTrue(loginPage.isOkPopUpShown());
	}

	@Test
	public void forgotPasswordWithWrongRePassword(){
		loginPage.clickForgetPassword();
		loginPage.clickSelectCountryButton();
		loginPage.setPhoneNumber(twilioService.phoneNumber);
		loginPage.selectCountryCode(twilioService.countryCode);
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isOkPopUpShown());
		loginPage.clickOkPopUp();
		loginPage.enterOtp(twilioService.getOtp());
		loginPage.clickSubmitButton();

		loginPage.enterNewPassword("Ashwin@321");
		loginPage.enterRePassword("Ashwin@123");

		loginPage.clickSubmitButton();

		Assert.assertTrue(loginPage.isTryAgainShown());
	}

	@Test
	public void forgotPasswordWithOutSymbol(){
		loginPage.clickForgetPassword();
		loginPage.clickSelectCountryButton();
		loginPage.setPhoneNumber(twilioService.phoneNumber);
		loginPage.selectCountryCode(twilioService.countryCode);
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isOkPopUpShown());
		loginPage.clickOkPopUp();
		loginPage.enterOtp(twilioService.getOtp());
		loginPage.clickSubmitButton();

		loginPage.enterNewPassword("Ashwin321");
		loginPage.enterRePassword("Ashwin321");

		loginPage.clickSubmitButton();

		Assert.assertTrue(loginPage.isTryAgainShown());
	}

	@Test
	public void forgotPasswordWithOutNumber(){
		loginPage.clickForgetPassword();
		loginPage.clickSelectCountryButton();
		loginPage.setPhoneNumber(twilioService.phoneNumber);
		loginPage.selectCountryCode(twilioService.countryCode);
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isOkPopUpShown());
		loginPage.clickOkPopUp();
		loginPage.enterOtp(twilioService.getOtp());
		loginPage.clickSubmitButton();

		loginPage.enterNewPassword("AshwinAshwin");
		loginPage.enterRePassword("AshwinAshwin");

		loginPage.clickSubmitButton();

		Assert.assertTrue(loginPage.isTryAgainShown());
	}

	@Test
	public void forgotPasswordWithOutWords(){
		loginPage.clickForgetPassword();
		loginPage.clickSelectCountryButton();
		loginPage.setPhoneNumber(twilioService.phoneNumber);
		loginPage.selectCountryCode(twilioService.countryCode);
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isOkPopUpShown());
		loginPage.clickOkPopUp();
		loginPage.enterOtp(twilioService.getOtp());
		loginPage.clickSubmitButton();

		loginPage.enterNewPassword("12345678");
		loginPage.enterRePassword("12345678");

		loginPage.clickSubmitButton();

		Assert.assertTrue(loginPage.isTryAgainShown());
	}




	@Test
	public void forgotPasswordWithWrongUser(){
		loginPage.clickForgetPassword();
		loginPage.clickSelectCountryButton();
		loginPage.setPhoneNumber("9876543210");
		loginPage.selectCountryCode(twilioService.countryCode);
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isTryAgainShown());

	}
}

