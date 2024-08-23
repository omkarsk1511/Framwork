package mocktest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;
import mocktest.dataprovider.DataProviders;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.utility.Log;

public class HomePageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
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

	@Test(groups = { "Smoke", "Sanity", "Regression" }, priority = 0)
	public void homePageUrlTest() throws Throwable {
		Log.startTestCase("homePageUrlTest");
		homePage = loginPage.login(homePage);
		String currURL = homePage.getCurrURL();
		String adminHomePageUrl = data.adminHomePageUrl();
		Assert.assertEquals(currURL, adminHomePageUrl);
		Log.endTestCase("homePageUrlTest");
	}

	@Test(groups = { "Smoke" }, priority = 1)
	public void userProfileTest() throws Throwable {
		Log.startTestCase("userProfileTest");
		homePage = loginPage.login(homePage);
		boolean result = homePage.validateUserProfile();
		Assert.assertTrue(result);
		Log.endTestCase("userProfileTest");
	}

	@Test(groups = { "Smoke" }, priority = 1)
	public void logoTest() throws Throwable {
		Log.startTestCase("logoTest");
		homePage = loginPage.login(homePage);
		boolean result = homePage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("logoTest");
	}

	@Test(groups = { "Smoke", "Sanity" }, priority = 1)
	public void testProLinkTest() throws Throwable {
		Log.startTestCase("testProLinkTest");
		homePage = loginPage.login(homePage);
		boolean result = homePage.validateTestProLink();
		Assert.assertTrue(result);
		Log.endTestCase("testProLinkTest");
	}

}
