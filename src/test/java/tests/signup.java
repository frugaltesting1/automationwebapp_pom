package tests;

import base.BaseTest;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
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
            System.out.println("Failed to click on next with empty fields");
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
            System.out.println("Failed to click on next without email");
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
            System.out.println("Failed to click on submit without phone number");
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
            System.out.println("Failed to click on next with invalid email");
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
            System.out.println("Failed while leaving first name empty");
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
            System.out.println("Failed while leaving last name empty");
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
            System.out.println("Failed to sign in with valid details");
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
            System.out.println("Failed to click on next without otp");
            Assert.fail();
        }
    }

    @Test(description = "entering wrong otp")
    public void clickOnNextWithWrongOtp() throws InterruptedException{
        signUpWithValidDetails();
        signupPage.enterOtp("0000");
        signupPage.clickNext2Button();
        Thread.sleep(5000);
        if(!signupPage.isTryAgainPopUpShown()){
            System.out.println("Failed to click on next with wrong otp");
            Assert.fail();
        }else{

            signupPage.clickTryAgain();
        }
    }

    @Test(description = "entering correct otp ")

    public  void clickOnNextWithValidOtp() throws InterruptedException{
        signUpWithValidDetails();
        signupPage.enterOtp(twilioService.getOtp());
        signupPage.clickNext2Button();
        Thread.sleep(5000);
        if(signupPage.isOkPopUpShown()){

            signupPage.clickOk();
        }else{
            System.out.println("Failed to click on next after entering valid otp");
            Assert.fail();
        }


    }


@Test(description = "signing up with empty password fields")
    public void clickOmSignUpWithEmptyPasswordFields() throws InterruptedException{
        String before= driver.getCurrentUrl();
        clickOnNextWithValidOtp();
        signupPage.clickUserAgreement();
        signupPage.clickOnFinalSignUp();
        Thread.sleep(20000);
        String after= driver.getCurrentUrl();
        if(before.equals(after)){
            System.out.println("Test passed!");
        }else{
            System.out.println("Failed in clicking on sign up with empty password fields ");
            Assert.fail();
        }

    }

    @Test(description = "entering different passwords in create password and retype password")
    public  void clickOnSignUpWithDifferentPasswords() throws InterruptedException{
        clickOnNextWithValidOtp();
        Thread.sleep(5000);
        String before= driver.getCurrentUrl();
        signupPage.setPassword("Frugal@123");
        signupPage.setRePassword("Frugal@234");
        signupPage.clickOnFinalSignUp();
        Thread.sleep(2000);
        String after= driver.getCurrentUrl();
        if(before.equals(after)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Failed in clicking on signup with different passwords");
            Assert.fail();
        }


    }

    @Test(description = "creating passwords which doesn't meet the required criteria")
public void clickOnSignUpWithInvalidPassword() throws InterruptedException{
        clickOnNextWithValidOtp();
        Thread.sleep(5000);
        String before= driver.getCurrentUrl();
        signupPage.setPassword("frugal testing");
        signupPage.setRePassword("frugal testing");
        signupPage.clickUserAgreement();
        signupPage.clickOnFinalSignUp();
        Thread.sleep(2000);
        String after= driver.getCurrentUrl();
        if(before.equals(after)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Failed in clicking on signup with invalid password");
            Assert.fail();
        }


    }

    @Test(description = "signing up without checking terms and conditions")

    public void clickOnSignUpWithoutUserAgreement() throws InterruptedException{
        clickOnNextWithValidOtp();
        Thread.sleep(3000);
        String before= driver.getCurrentUrl();
        signupPage.setPassword("Frugal@123");
        signupPage.setRePassword("Frugal@123");
        signupPage.clickOnFinalSignUp();
        Thread.sleep(5000);
        String after= driver.getCurrentUrl();
        if(!before.equals(after)){
            System.out.println("Failed in clicking on sign up without checking user agreement");
            Assert.fail();
        }

    }

    @Test(description = "creating an account successfully with all valid details")

    public void createAnAccountSuccessfully() throws InterruptedException{
        clickOnNextWithValidOtp();
        Thread.sleep(3000);
        String before= driver.getCurrentUrl();
        signupPage.setPassword("Frugal@123");
        signupPage.setRePassword("Frugal@123");
        signupPage.clickUserAgreement();
        signupPage.clickOnFinalSignUp();
        Thread.sleep(20000);
        String after= driver.getCurrentUrl();
        if(before.equals(after)){
            System.out.println("Failed in creating an account successfully");
            Assert.fail();
        }


    }




    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }



}