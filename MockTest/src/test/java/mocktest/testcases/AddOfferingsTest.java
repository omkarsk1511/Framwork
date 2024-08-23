package mocktest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.dataprovider.Data;
import mocktest.base.BaseClass;
import mocktest.pageobjects.AddOfferingsPage;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.pageobjects.OfferingsPage;
import mocktest.utility.Log;


public class AddOfferingsTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	private OfferingsPage offeringsPage;
	private AddOfferingsPage addOfferingsPage;
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

	@Test(groups = "Regression", priority = 0)
	public void addOfferingsTest() throws Throwable {
		Log.startTestCase("addOfferingsTest");
		homePage = loginPage.login(homePage);
		offeringsPage = homePage.clickOnOfferings();
		addOfferingsPage = offeringsPage.clickOnAddOfferings();
		addOfferingsPage.selectNameOfExam(1);
		addOfferingsPage.selectMedium(1);
		addOfferingsPage.selectStandard(1);
		addOfferingsPage.validateExistFlshMsgAct();
		boolean result = addOfferingsPage.validateExistFlshMsgAct();
		String existFlshMsgAct = addOfferingsPage.existFlshMsgAct();
		String offExistFlash = data.offExistFlash();
		
		if (result==true)
		{
			Assert.assertEquals(offExistFlash, existFlshMsgAct);
		}
		else if (result==false) 
		{
		addOfferingsPage.selectAllSubject();
		addOfferingsPage.clickOnSave();
		String succFlshMsgAct = addOfferingsPage.succFlshMsgAct();
		System.out.println(succFlshMsgAct);
		String succFlshMsg = data.succFlshMsg();
		Assert.assertEquals(succFlshMsgAct, succFlshMsg);
		Log.endTestCase("addOfferingsTest");
		}
	}

}
