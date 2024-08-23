package mocktest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;
import mocktest.pageobjects.BatchesPage;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.utility.Log;

public class BatchesPageTest extends BaseClass {

	private LoginPage loginPage;
	private HomePage homePage;
	private BatchesPage batchesPage;
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

	@Test(groups = { "Smoke", "Sanity" }, priority = 0)
	public void batchesPagePageUrlTest() throws Throwable {
		Log.startTestCase("batchesPagePageUrlTest");
		homePage = loginPage.login(homePage);
		batchesPage = homePage.clickOnBatches();
		String currURL = batchesPage.getCurrURL();
		String batchesPagePageUrl = data.batchesPagePageUrl();
		Assert.assertEquals(currURL, batchesPagePageUrl);
		Log.endTestCase("batchesPagePageUrlTest");
	}

	@Test(groups = { "Smoke" }, priority = 1)
	public void addBatchBtnTest() throws Throwable {
		Log.startTestCase("addBatchBtnTest");
		homePage = loginPage.login(homePage);
		batchesPage = homePage.clickOnBatches();
		batchesPage.validateAddBatchBtn();
		boolean result = batchesPage.validateAddBatchBtn();
		Assert.assertTrue(result);
		Log.endTestCase("addBatchBtnTest");
	}

}
