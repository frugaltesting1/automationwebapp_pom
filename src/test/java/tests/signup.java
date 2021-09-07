package tests;

import base.BaseTest;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    @Test
    public void clickSubmitButtonWithEmptyFields(){
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void clickSubmitButtonWithoutEmail(){
        signupPage.addPhoneNumber("9551574355");
        signupPage.clickCountryCodeSelector();
        signupPage.clickIndiaOption();
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void clickSubmitButtonWithoutPhoneNUmber(){
        signupPage.addGmailID("ashwin@frugaltesting.com");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void clickSubmitButtonWithInvalidPhoneNumber(){
        signupPage.addPhoneNumber("1234567890");
        signupPage.addGmailID("test@frugaltesting.com");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void clickSubmitButtonWithInvalidEmail(){
        signupPage.addPhoneNumber("9999999999");
        signupPage.clickCountryCodeSelector();
        signupPage.clickIndiaOption();
        signupPage.addGmailID("frugaltesting.com");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
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

    @Test
    public void creatingAccountWithoutFirstName(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addMiddleName("Ashwin");
        signupPage.addLastName("R");
        signupPage.setDob("01/12/2000");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void creatingAccountWithoutLastName(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addFirstName("Ashwin");
        signupPage.setDob("01/12/2000");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void creatingAccountWithoutDob(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addFirstName("Ashwin");
        signupPage.addLastName("R");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void creatingAccountWithoutInvalidDob(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addFirstName("Ashwin");
        signupPage.addLastName("R");
        signupPage.setDob("Dob");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void creatingAccountByGivingAllInputs(){
        clickSubmitButtonWithEmailAndPassword();
        signupPage.addFirstName("Ashwin");
        signupPage.addLastName("R");
        signupPage.setDob("01/12/2000");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.getUrl().contains("registeraddress"));
    }

    @Test
    public void creatAccountWithoutEnterCountryName(){
        creatingAccountByGivingAllInputs();
        signupPage.setCity("Chennai");
        signupPage.setState("Tamil Nadu");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void creatAccountWithoutEnterCityName(){
        creatingAccountByGivingAllInputs();
        signupPage.setCountry("India");
        signupPage.setState("Tamil Nadu");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
    public void creatAccountWithoutEnterStateName(){
        creatingAccountByGivingAllInputs();
        signupPage.setCity("Chennai");
        signupPage.setCountry("India");
        signupPage.clickContinueButton();
        Assert.assertTrue(signupPage.isTryAgainPopUpShown());
        signupPage.clickTryAgain();
    }

    @Test
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

    @Test
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

    @Test
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





