package mocktest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.utility.Log;
import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;
import mocktest.pageobjects.AcademicCyclePage;
import mocktest.pageobjects.BatchesPage;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;

public class AcademicCyclePageTest extends BaseClass {

    private LoginPage loginPage;
    private HomePage homePage;
    private AcademicCyclePage academicCyclePage;
    private Data data;
	private BatchesPage batchesPage;

    Action action = new Action();

    @Parameters("browser")
    @BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
    public void setup(String browser) throws InterruptedException {
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser parameter is not specified. Please check your test configuration.");
        }
        launchApp(browser);
        loginPage = new LoginPage();  
        homePage = new HomePage(); // Initialize here for use in tests
        academicCyclePage = new AcademicCyclePage(); // Initialize here for use in tests
    }

    @AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    @Test(groups = { "Smoke", "Sanity" }, priority = 0)
    public void academicCyclePageUrlTest() throws Throwable {
        Log.startTestCase("academicCyclePageUrlTest");
        homePage = loginPage.login(homePage);
        academicCyclePage = homePage.clickOnAcademicCycle();
        String currURL = academicCyclePage.getCurrURL();
        String academicCyclePageUrl = data.academicCyclePageUrl();
        Assert.assertEquals(currURL, academicCyclePageUrl);
        Log.endTestCase("academicCyclePageUrlTest");
    }

    @Test(groups = {"Smoke"}, priority = 1)
    public void addacademiccycleBtnTest() throws Throwable {
        Log.startTestCase("addacademiccycleBtnTest");
        homePage = loginPage.login(homePage);
        academicCyclePage = homePage.clickOnAcademicCycle();
        boolean result = academicCyclePage.validateAddacademiccycleBtn();
        Assert.assertTrue(result, "Add Academic Cycle button validation failed.");
        Log.endTestCase("addacademiccycleBtnTest");
    }
}
