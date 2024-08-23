package mocktest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.dataprovider.Data;
import mocktest.dataprovider.DataProviders;
import mocktest.utility.Log;
import mocktest.utility.NewExcelLibrary;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.base.BaseClass;

public class LoginTest extends BaseClass {

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
	public void loginTest() throws Throwable {
		Log.startTestCase("loginTest");
		homePage = new HomePage();
		homePage = loginPage.login(homePage);
		String currURL = homePage.getCurrURL();
		String adminHomePageUrl = data.adminHomePageUrl();
		Assert.assertEquals(currURL, adminHomePageUrl);
		Log.endTestCase("loginTest");

	}

}
