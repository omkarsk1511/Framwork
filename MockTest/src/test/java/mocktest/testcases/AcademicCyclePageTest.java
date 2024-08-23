package mocktest.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;

public class AcademicCyclePageTest extends BaseClass {

	private LoginPage loginPage;
	private HomePage homePage;
	private AcademicCyclePage academicCyclePage;
	private Data data;
	
	Action action= new Action();


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
	
	
	@Test(groups = { "Smoke", "Sanity" }, priority = 0)
	public void academicCyclePageUrlTest() throws Throwable {
		Log.startTestCase("academicCyclePageUrlTest");
		homePage = loginPage.login(homePage);
		academicCyclePage=homePage.clickOnAcademicCycle();
		String currURL = academicCyclePage.getCurrURL();
		String academicCyclePageUrl = data.academicCyclePageUrl();
		Assert.assertEquals(currURL, academicCyclePageUrl);
	    Log.endTestCase("academicCyclePageUrlTest");

	}
	
	@Test(groups = {"Smoke"}, priority = 1)
	public void addacademiccycleBtnTest() throws Throwable {
		Log.startTestCase("addacademiccycleBtnTest");
		homePage = loginPage.login(homePage);
		academicCyclePage=homePage.clickOnAcademicCycle();
		academicCyclePage.validateAddacademiccycleBtn();
		boolean result = academicCyclePage.validateAddacademiccycleBtn();
		Assert.assertTrue(result);
	    Log.endTestCase("addacademiccycleBtnTest");
	}

}
