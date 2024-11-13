package mocktest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;
import mocktest.pageobjects.AddMarkPage;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.utility.Log;

public class AddMarkTest extends BaseClass {
    private LoginPage loginPage;
    private HomePage homePage;
    private AddMarkPage addMarkPage;
    private Data data;

    @Parameters("browser")
    @BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
    public void setup(String browser) throws InterruptedException {
        launchApp(browser);
        loginPage = new LoginPage();
    }

    @AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
    public void tearDown() {
        getDriver().quit();
    }
//master
    @Test(groups = { "Smoke", "Sanity" }, priority = 0)
    public void addMarkTest() throws Throwable {
        Log.startTestCase("addMarkTest");
        homePage = loginPage.login(homePage);
        addMarkPage = homePage.clickOnMarkEntry();
        addMarkPage.examName("test");
        addMarkPage.selectOffering(1);
        addMarkPage.selectBatch();
        addMarkPage.selectSub();
        addMarkPage.totalMarks("100");
        addMarkPage.minMarks("35");
        addMarkPage.save();
        addMarkPage.allAbsent();
        addMarkPage.submit();
        Log.endTestCase("addMarkTest");
    }

    @Test(groups = { "Regression" }, priority = 1)
    public void TC_S_004() throws Throwable {
        Log.startTestCase("TC_S_004 - Exam Name Character Test");
        homePage = loginPage.login(homePage);
        addMarkPage = homePage.clickOnMarkEntry();

        String validExamName = "Test_Exam-2024";
        addMarkPage.examName(validExamName);
        
        Assert.assertTrue(addMarkPage.isExamNameValid(validExamName), "Exam name contains invalid characters.");
        Log.endTestCase("TC_S_004 - Exam Name Character Test");
    }

    @Test(groups = { "Regression" }, priority = 2)
    public void TC_S_005() throws Throwable {
        Log.startTestCase("TC_S_005 - Exam Name Length Test");
        homePage = loginPage.login(homePage);
        addMarkPage = homePage.clickOnMarkEntry();

        String validExamName = "A".repeat(255);  // Maximum length allowed
        addMarkPage.examName(validExamName);
        
        Assert.assertTrue(validExamName.length() <= 255, "Exam name length exceeds maximum allowed.");
        Log.endTestCase("TC_S_005 - Exam Name Length Test");
    }

    @Test(groups = { "Regression" }, priority = 3)
    public void examNameDisclaimerTest() throws Throwable {
        Log.startTestCase("examNameDisclaimerTest");
        homePage = loginPage.login(homePage);
        addMarkPage = homePage.clickOnMarkEntry();

        addMarkPage.examName("");  // Empty exam name
        addMarkPage.save();

        String expectedDisclaimer = "Please Enter Exam Name";
        Assert.assertEquals(addMarkPage.getExamNameDisclaimer(), expectedDisclaimer, "Disclaimer message is incorrect.");
        Log.endTestCase("examNameDisclaimerTest");
    }
}
