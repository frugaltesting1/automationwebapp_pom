package tests.Squad;

import base.BaseTest;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.SquadPage;
import utility.AllureReport;

public class squads extends BaseTest {
    private SquadPage squadsPage;

    @BeforeMethod
    public void setupTests() {
        super.setup();
        LoginPage loginPage = new LoginPage(driver);
        driver.navigate().to(baseURL+"/login");
        loginPage.nativeLogin(userEmail, userPassword);
        driver.navigate().to(baseURL+"/squad");
        squadsPage = new SquadPage(driver);
    }

    @Test
    public void checkSquad(){
        squadsPage.clickFirstSquad();
        squadsPage.clickMembers();
    }


    @AfterMethod
    public void clearTests() {
        AllureReport.Screenshot(driver,this.getClass().getName());
        driver.quit();
    }
}
