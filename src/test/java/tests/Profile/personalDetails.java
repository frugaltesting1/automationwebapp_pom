package tests.Profile;

import base.BaseTest;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProfilePage;
import utility.AllureReport;

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

    @Test
    public void changeFirstName(){
        profilePage.openProfileSection();
        profilePage.setFirstName("FirstNameTest");
        profilePage.clickSaveProfile();
        profilePage.clickOk();
    }

    @Test
    public void changeLastName(){
        profilePage.openProfileSection();
        profilePage.setLastName("LastNameTest");
        profilePage.clickSaveProfile();
        profilePage.clickOk();
    }

    @Test
    public void changeFirstNameWithoutLastName(){
        profilePage.openProfileSection();
        profilePage.setFirstName("FirstNameTest");
        profilePage.setLastName("");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test
    public void changeLastNameWithoutFirstName(){
        profilePage.openProfileSection();
        profilePage.setFirstName("");
        profilePage.setLastName("LastName Test");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test
    public void changeLastNameWithSymbol(){
        profilePage.openProfileSection();
        profilePage.setLastName("Last Name @");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test
    public void changeFirstNameWithSymbol(){
        profilePage.openProfileSection();
        profilePage.setFirstName("First Name @");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test
    public void changeMiddleName(){
        profilePage.openProfileSection();
        profilePage.setMiddleName("MiddleNameTest");
        profilePage.clickSaveProfile();
        profilePage.clickOk();
    }

    @Test
    public void changeMiddleNameWithSymbol(){
        profilePage.openProfileSection();
        profilePage.setMiddleName("Middle Name @");
        profilePage.clickSaveProfile();
        profilePage.clickTryAgain();
    }

    @Test
    public void uploadProfilePic(){
         profilePage.uploadProfilePicture("/home/ashwin/Documents/projects/Frugal Testing/automation_POM-main/resources/pexels_photo.jpeg");
         profilePage.clickSaveProfile();
         profilePage.clickOk();
    }

    @Test
    public void uploadProfilePicWithTextFile() {
        profilePage.uploadProfilePicture("/home/ashwin/Documents/projects/Frugal Testing/automation_POM-main/resources/TestCases.txt");
        profilePage.clickTryAgain();
    }

    @Test
    public void changeCity(){
        profilePage.openAddressSection();
        profilePage.setCity("City Test");
        profilePage.clickSaveAddress();
        profilePage.clickOk();
    }

    @Test
    public void changeState(){
        profilePage.openAddressSection();
        profilePage.setState("State Test");
        profilePage.clickSaveAddress();
        profilePage.clickOk();
    }

    @Test
    public void changeCountry(){
        profilePage.openAddressSection();
        profilePage.setCountry("Country Test");
        profilePage.clickSaveAddress();
        profilePage.clickOk();
    }

    @Test
    public void submitPasswordWithoutOldPassword() throws InterruptedException {
        profilePage.openPasswordSection();
        profilePage.enterNewPassword("Ashwin@321");
        profilePage.reEnterNewtPassword("Ashwin@321");
        profilePage.clickSavePassword();
        Thread.sleep(1000);
        profilePage.clickTryAgain();
        reload();
    }

    @Test
    public void submitPasswordWithoutNewPassword() throws InterruptedException {
        profilePage.openPasswordSection();
        profilePage.enterCurrentPassword(userPassword);
        profilePage.reEnterNewtPassword("Ashwin@321");
        profilePage.clickSavePassword();
        Thread.sleep(1000);
        profilePage.clickTryAgain();
        reload();
    }

    @Test
    public void submitPasswordWithoutReenterPassword() throws InterruptedException {
        profilePage.openPasswordSection();
        profilePage.enterCurrentPassword(userPassword);
        profilePage.enterNewPassword("Ashwin@321");
        profilePage.clickSavePassword();
        Thread.sleep(1000);
        profilePage.clickTryAgain();
        reload();
    }

    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
    public void changeAddressWithoutCity(){
        profilePage.openAddressSection();
        profilePage.setCity("");
        profilePage.setState("State Test");
        profilePage.setCountry("Country Test");
        profilePage.clickSaveAddress();
        profilePage.clickTryAgain();
    }

    @Test
    public void changeAddressWithoutState(){
        profilePage.openAddressSection();
        profilePage.setCity("City Test");
        profilePage.setState("");
        profilePage.setCountry("Country Test");
        profilePage.clickSaveAddress();
        profilePage.clickTryAgain();
    }

    @Test
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
