package mocktest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;
import mocktest.pageobjects.AcademicCyclePage;
import mocktest.pageobjects.AddAcademiccyclePage;
import mocktest.pageobjects.AddOfferingsPage;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.pageobjects.OfferingsPage;
import mocktest.utility.Log;

public class AddAcademiccyclePageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	private AcademicCyclePage academicCyclePage;
	private AddAcademiccyclePage addAcademiccyclePage;
	private Data data;

	Action action = new Action();

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
	public void addAcademiccycle() throws Throwable {
		Log.startTestCase("addAcademiccycle");
		homePage = loginPage.login(homePage);
		academicCyclePage = homePage.clickOnAcademicCycle();
		addAcademiccyclePage = academicCyclePage.clickOnAddAcademiccycle();
		addAcademiccyclePage.nameOfAcad("acad 28-29");
		addAcademiccyclePage.selectoffering(1);
		addAcademiccyclePage.clicOnSave();

		String flshMsgAct = addAcademiccyclePage.flshMsgAct();
		String acadExistFlash = data.acadExistFlash();
		String acadsuccFlshMsg = data.acadsuccFlshMsg();
		if (flshMsgAct.equals(acadExistFlash)) {
			Assert.assertEquals(flshMsgAct, acadExistFlash);
			System.out.println(flshMsgAct);

		} else if (flshMsgAct.equals(acadsuccFlshMsg)) {
			Assert.assertEquals(flshMsgAct, acadsuccFlshMsg);
			System.out.println(flshMsgAct);

		}
		Log.endTestCase("addAcademiccycle");
	}
}
