package mocktest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.pageobjects.OfferingsPage;
import mocktest.utility.Log;

public class OfferingsPageTest extends BaseClass {

	private LoginPage loginPage;
	private HomePage homePage;
	private OfferingsPage offeringsPage;
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
	public void offeringsPageUrlTest() throws Throwable {
		Log.startTestCase("offeringsPageUrlTest");
		homePage = loginPage.login(homePage);
		offeringsPage = homePage.clickOnOfferings();
		String currURL = offeringsPage.getCurrURL();
		String offeringsPageUrl = data.offeringsPageUrl();
		Assert.assertEquals(currURL, offeringsPageUrl);
		Log.endTestCase("offeringsPageUrlTest");
	}

	@Test(groups = { "Smoke" }, priority = 1)
	public void addOfferingsBtnTest() throws Throwable {
		Log.startTestCase("addOfferingsBtnTest");
		homePage = loginPage.login(homePage);
		offeringsPage = homePage.clickOnOfferings();
		offeringsPage.validateAddOfferingsBtn();
		boolean result = offeringsPage.validateAddOfferingsBtn();
		Assert.assertTrue(result);
		Log.endTestCase("addOfferingsBtnTest");
	}
}
