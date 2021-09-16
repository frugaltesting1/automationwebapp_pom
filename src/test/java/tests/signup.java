package tests;

import base.BaseTest;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MessagePage;
import pages.SignupPage;
import utility.AllureReport;
import utility.TwilioService;

public class signup extends BaseTest {

    private SignupPage signupPage;
    private TwilioService twilioService = new TwilioService();


    @BeforeMethod
    public void setupTests() {
        super.setup();
        signupPage = new SignupPage(driver);
        driver.navigate().to(baseURL+"/signup");
    }

    @Test(description="Test:click Submit Button With Empty Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithEmptyFields(){
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:click Submit Button Without email")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithoutEmail(){
        signupPage.addPhoneNumber("9551574355");
        signupPage.clickCountryCodeSelector();
        signupPage.clickIndiaOption();
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:click Submit Button Without phone number")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithoutPhoneNUmber(){
        signupPage.addGmailID("ashwin@frugaltesting.com");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:click Submit Button With invalid phone number")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithInvalidPhoneNumber(){
        signupPage.addPhoneNumber("1234567890");
        signupPage.addGmailID("test@frugaltesting.com");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:click Submit Button With invalid email")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithInvalidEmail(){
        signupPage.addPhoneNumber("9999999999");
        signupPage.clickCountryCodeSelector();
        signupPage.clickIndiaOption();
        signupPage.addGmailID("frugaltesting.com");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:click Submit Button With email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithEmailAndPassword(){
        signupPage.addPhoneNumber(twilioService.phoneNumber);
        signupPage.clickCountryCodeSelector();
        signupPage.clickUsaOption();
        signupPage.addGmailID("test@frugaltesting.com");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isOkPopUpShown());
        signupPage.clickOk();
        signupPage.enterOtp(twilioService.getOtp());
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.getUrl().contains("register"));
    }

    @Test(description="Test:creating Account Without First Name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatingAccountWithoutFirstName(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addMiddleName("Ashwin");
        signupPage.addLastName("R");
        signupPage.setDob("01/12/2000");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:creating Account Without Last Name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatingAccountWithoutLastName(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addFirstName("Ashwin");
        signupPage.setDob("01/12/2000");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:creating Account Without DOB")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatingAccountWithoutDob(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addFirstName("Ashwin");
        signupPage.addLastName("R");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:creating Account Without Invalid DOB")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatingAccountWithoutInvalidDob(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addFirstName("Ashwin");
        signupPage.addLastName("R");
        signupPage.setDob("Dob");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:creating Account by giving all inputs")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatingAccountByGivingAllInputs(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addFirstName("Ashwin");
        signupPage.addLastName("R");
        signupPage.setDob("01/12/2000");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.getUrl().contains("registeraddress"));
    }

    @Test(description="Test:creating without enter country name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatAccountWithoutEnterCountryName(){
        creatingAccountByGivingAllInputs();
        signupPage.setCity("Chennai");
        signupPage.setState("Tamil Nadu");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:creating Account without city name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatAccountWithoutEnterCityName(){
        creatingAccountByGivingAllInputs();
        signupPage.setCountry("India");
        signupPage.setState("Tamil Nadu");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:creating Account without enter state name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatAccountWithoutEnterStateName(){
        creatingAccountByGivingAllInputs();
        signupPage.setCity("Chennai");
        signupPage.setCountry("India");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test(description="Test:creating Account without re password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void creatAccountWithoutRePassword(){
        creatingAccountByGivingAllInputs();
        signupPage.setCity("Chennai");
        signupPage.setCountry("India");
        signupPage.setState("Tamil Nadu");
        signupPage.clickContinueButton();
        signupPage.setPassword("Ashwin@111");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
    }

    @Test(description="Test:creating Account correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void creatAccount(){
        creatingAccountByGivingAllInputs();
        signupPage.setCity("Chennai");
        signupPage.setCountry("India");
        signupPage.setState("Tamil Nadu");
        signupPage.clickContinueButton();
        signupPage.setPassword("Ashwin@111");
        signupPage.setRePassword("Ashwin@111");
        signupPage.clickUserAgreement();
        signupPage.clickContinueButton();
    }

    @Test(description="Test:clicking submit button with wrong OTP")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithWrongOtp(){
        signupPage.addPhoneNumber("9999999999");
        signupPage.clickIndiaOption();
        signupPage.addGmailID("test@frugaltesting.com");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isOkPopUpShown());
        signupPage.clickOk();
        signupPage.enterOtp("1234");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }



    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }

}