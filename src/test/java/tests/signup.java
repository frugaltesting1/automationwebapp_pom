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
    public void continueWithEmptyFields(){
        signupPage.clickNext1Button();
        if(signupPage.isOkPopUpShown()){
            Assert.fail();
        }
    }

    @Test(description="Test:click Submit Button Without email")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithoutEmail(){
        signupPage.addFirstName("ABC");
        signupPage.addLastName("XYZ");
        signupPage.addPhoneNumber("9551574355");
        signupPage.clickCountryCodeSelector();
        signupPage.clickIndiaOption();
        signupPage.clickNext1Button();
        if(signupPage.isOkPopUpShown()){
            Assert.fail();
        }
    }

    @Test(description="Test:click Submit Button Without phone number")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithoutPhoneNUmber(){
        signupPage.addGmailID("ashwin@frugaltesting.com");
        signupPage.addFirstName("ABC");
        signupPage.addLastName("XYZ");
        signupPage.clickNext1Button();
        if(signupPage.isOkPopUpShown()){
            Assert.fail();

        }
    }


    @Test(description="Test:click Submit Button With invalid email")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void clickSubmitButtonWithInvalidEmail(){
        signupPage.addPhoneNumber("9999999999");
        signupPage.addFirstName("ABC");
        signupPage.addLastName("XYZ");
        signupPage.clickCountryCodeSelector();
        signupPage.clickIndiaOption();
        signupPage.addGmailID("frugaltesting.com");
        signupPage.clickNext1Button();
        if(signupPage.isOkPopUpShown()) {
            Assert.fail();
        }
    }



    @Test(description="Test:creating Account Without First Name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatingAccountWithoutFirstName(){

        signupPage.addLastName("XYZ");
        signupPage.clickCountryCodeSelector();
        signupPage.clickIndiaOption();
        signupPage.addPhoneNumber("9999999999");
        signupPage.addGmailID("frugal@testing.com");
        signupPage.clickNext1Button();
        if(signupPage.isOkPopUpShown()) {
            Assert.fail();
        }
    }

    @Test(description="Test:creating Account Without Last Name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the signup flow")
    public void creatingAccountWithoutLastName(){
        signupPage.addFirstName("XYZ");
        signupPage.clickCountryCodeSelector();
        signupPage.clickIndiaOption();
        signupPage.addPhoneNumber("9999999999");
        signupPage.addGmailID("frugal@testing.com");
        signupPage.clickNext1Button();
        if(signupPage.isOkPopUpShown()) {
            Assert.fail();
        }

       }

    @Test(description="Test:click Submit Button With email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the signup flow")
    public void signUpWithValidDetails() throws InterruptedException{
        signupPage.addFirstName("Frugal");
        signupPage.addLastName("Testing");
       signupPage.addGmailID("ilovefrugal@gmail.com");
        signupPage.clickCountryCodeSelector();
        signupPage.clickUsaOption();
        signupPage.addPhoneNumber(twilioService.phoneNumber);
       signupPage.clickNext1Button();
        Thread.sleep(5000);
        if(signupPage.isOkPopUpShown()){
            signupPage.clickOk();
        }else{
            Assert.fail();
        }
    }


    @Test(description = "clicking on next without entering the otp ")

    public void clickOnNextWithoutOtp() throws InterruptedException{

        signUpWithValidDetails();
        signupPage.clickNext2Button();
        Thread.sleep(5000);
       // System.out.println(twilioService.getOtp());
        if(!signupPage.isTryAgainPopUpShown()){
            Assert.fail();
        }
    }

    @Test(description = "entering correct otp ")

    public  void clickOnNextWithOtp() throws InterruptedException{
        signUpWithValidDetails();
        signupPage.enterOtp(twilioService.getOtp());
        signupPage.clickNext2Button();
        if(signupPage.isOkPopUpShown()){
            signupPage.clickOk();
        }else{
            Assert.fail();
        }


    }




    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }



}