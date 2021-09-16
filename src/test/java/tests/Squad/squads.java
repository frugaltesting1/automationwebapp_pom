package tests.Squad;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.SquadPage;
import utility.AllureReport;
import Listeners.TestAllureListener;
@Listeners({TestAllureListener.class})
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

    @Test(description="Test:checking squads")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This story belongs to the squad flow")
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