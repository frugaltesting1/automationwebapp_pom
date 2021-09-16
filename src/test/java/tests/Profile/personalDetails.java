package tests.Profile;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProfilePage;
import utility.AllureReport;
import Listeners.TestAllureListener;
@Listeners({TestAllureListener.class})
public class personalDetails extends BaseTest {
    private ProfilePage profilePage;

    @BeforeMethod
    public void setupTests() {
        super.setup();
        LoginPage loginPage = new LoginPage(driver);
        driver.navigate().to(baseURL+"/login");
        loginPage.nativeLogin(userEmail, userPassword);
        driver.navigate().to(baseURL+"/user/profile");
        profilePage = new ProfilePage(driver);
    }

    void reload() {
        driver.navigate().to(baseURL+"/user/profile");
    }

    @Test(description="Test:Change first name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeFirstName(){
        profilePage.openProfileSection();
        profilePage.setFirstName("FirstNameTest");
        profilePage.clickSaveProfile();
        profilePage.clickOk();
    }

    @Test(description="Test:Change last name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeLastName(){
        profilePage.openProfileSection();
        profilePage.setLastName("LastNameTest");
        profilePage.clickSaveProfile();
        profilePage.clickOk();
    }

    @Test(description="Test:Change first name without last name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeFirstNameWithoutLastName(){
        profilePage.openProfileSection();
        profilePage.setFirstName("FirstNameTest");
        profilePage.setLastName("");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test(description="Test:Change last name without first name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeLastNameWithoutFirstName(){
        profilePage.openProfileSection();
        profilePage.setFirstName("");
        profilePage.setLastName("LastName Test");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test(description="Test:Change last name with special character")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeLastNameWithSymbol(){
        profilePage.openProfileSection();
        profilePage.setLastName("Last Name @");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test(description="Test:Change First Name With special character")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeFirstNameWithSymbol(){
        profilePage.openProfileSection();
        profilePage.setFirstName("First Name @");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test(description="Test:Change middle name")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeMiddleName(){
        profilePage.openProfileSection();
        profilePage.setMiddleName("MiddleNameTest");
        profilePage.clickSaveProfile();
        profilePage.clickOk();
    }

    @Test(description="Test:Change middle name with special character")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeMiddleNameWithSymbol(){
        profilePage.openProfileSection();
        profilePage.setMiddleName("Middle Name @");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test(description="Test:Uploading profile picture")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void uploadProfilePic(){
        profilePage.uploadProfilePicture("/home/ashwin/Documents/projects/Frugal Testing/automation_POM-main/resources/pexels_photo.jpeg");
        profilePage.clickSaveProfile();
        profilePage.clickOk();
    }

    @Test(description="Test:Uploading profile picture with text file")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void uploadProfilePicWithTextFile() {
        profilePage.uploadProfilePicture("/home/ashwin/Documents/projects/Frugal Testing/automation_POM-main/resources/TestCases.txt");
        profilePage.clickTryAgain();
    }

    @Test(description="Test:changing city")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeCity(){
        profilePage.openAddressSection();
        profilePage.setCity("City Test");
        profilePage.clickSaveAddress();
        profilePage.clickOk();
    }

    @Test(description="Test:changing state")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeState(){
        profilePage.openAddressSection();
        profilePage.setState("State Test");
        profilePage.clickSaveAddress();
        profilePage.clickOk();
    }

    @Test(description="Test:changing country")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeCountry(){
        profilePage.openAddressSection();
        profilePage.setCountry("Country Test");
        profilePage.clickSaveAddress();
        profilePage.clickOk();
    }

    @Test(description="Test:submit Password Without Old Password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the personal details flow")
    public void submitPasswordWithoutOldPassword() throws InterruptedException {
        profilePage.openPasswordSection();
        profilePage.enterNewPassword("Ashwin@321");
        profilePage.reEnterNewtPassword("Ashwin@321");
        profilePage.clickSavePassword();
        Thread.sleep(1000);
        profilePage.clickTryAgain();
        reload();
    }

    @Test(description="Test:submit Password Without new Password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the personal details flow")
    public void submitPasswordWithoutNewPassword() throws InterruptedException {
        profilePage.openPasswordSection();
        profilePage.enterCurrentPassword(userPassword);
        profilePage.reEnterNewtPassword("Ashwin@321");
        profilePage.clickSavePassword();
        Thread.sleep(1000);
        profilePage.clickTryAgain();
        reload();
    }

    @Test(description="Test:submit Password Without re enter Password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the personal details flow")
    public void submitPasswordWithoutReenterPassword() throws InterruptedException {
        profilePage.openPasswordSection();
        profilePage.enterCurrentPassword(userPassword);
        profilePage.enterNewPassword("Ashwin@321");
        profilePage.clickSavePassword();
        Thread.sleep(1000);
        profilePage.clickTryAgain();
        reload();
    }

    @Test(description="Test:check Password With Wrong Old Password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the personal details flow")
    public void checkPasswordWithWrongOldPassword() throws InterruptedException {
        profilePage.openPasswordSection();
        profilePage.enterCurrentPassword(userPassword+"@@@");
        profilePage.enterNewPassword("Ashwin@321");
        profilePage.reEnterNewtPassword("Ashwin@321");
        profilePage.clickSavePassword();
        Thread.sleep(1000);
        profilePage.clickTryAgain();
        reload();
    }

    @Test(description="Test:check Password With unmatched new Password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the personal details flow")
    public void checkPasswordWithUnmatchedNewPassword() throws InterruptedException {
        profilePage.openPasswordSection();
        profilePage.enterCurrentPassword(userPassword);
        profilePage.enterNewPassword("Ashwin@123");
        profilePage.reEnterNewtPassword("Ashwin@321");
        profilePage.clickSavePassword();
        Thread.sleep(1000);
        profilePage.clickTryAgain();
        reload();
    }

    @Test(description="Test:check Password Without special character")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the personal details flow")
    public void checkPasswordWithoutSpecialCharacter() throws InterruptedException {
        profilePage.openPasswordSection();
        profilePage.enterCurrentPassword(userPassword);
        profilePage.enterNewPassword("AshwinAshwin");
        profilePage.reEnterNewtPassword("AshwinAshwin");
        profilePage.clickSavePassword();
        Thread.sleep(1000);
        profilePage.clickTryAgain();
        reload();
    }

    @Test(description="Test:check Password Section")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the personal details flow")
    public void checkPasswordSection(){
        profilePage.openPasswordSection();
        profilePage.enterCurrentPassword(userPassword);
        profilePage.enterNewPassword("Ashwin@321");
        profilePage.reEnterNewtPassword("Ashwin@321");
        profilePage.clickSavePassword();
        profilePage.clickOk();
        reload();
        resetPassword();
    }

    public void resetPassword(){
        profilePage.openPasswordSection();
        profilePage.enterCurrentPassword("Ashwin@321");
        profilePage.enterNewPassword(userPassword);
        profilePage.reEnterNewtPassword(userPassword);
        profilePage.clickSavePassword();
        profilePage.clickOk();
        reload();
    }

    @Test(description="Test:change Address Without City")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeAddressWithoutCity(){
        profilePage.openAddressSection();
        profilePage.setCity("");
        profilePage.setState("State Test");
        profilePage.setCountry("Country Test");
        profilePage.clickSaveAddress();
        profilePage.clickTryAgain();
    }

    @Test(description="Test:change Address Without State")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeAddressWithoutState(){
        profilePage.openAddressSection();
        profilePage.setCity("City Test");
        profilePage.setState("");
        profilePage.setCountry("Country Test");
        profilePage.clickSaveAddress();
        profilePage.clickTryAgain();
    }

    @Test(description="Test:change Address Without Country")
    @Severity(SeverityLevel.NORMAL)
    @Story("This story belongs to the personal details flow")
    public void changeAddressWithoutCountry(){
        profilePage.openAddressSection();
        profilePage.setCity("City Test");
        profilePage.setState("State Test");
        profilePage.setCountry("");
        profilePage.clickSaveAddress();
        profilePage.clickTryAgain();
    }


    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }

}