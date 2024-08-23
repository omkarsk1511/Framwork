 package mocktest.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.dataprovider.Data;
import mocktest.base.BaseClass;
import mocktest.pageobjects.AddBatchPage;
import mocktest.pageobjects.BatchesPage;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.utility.Log;

public class AddBatchTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	private BatchesPage batchesPage;
	private AddBatchPage addBatchPage;
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
	public void addBatchTest() throws Throwable {
		Log.startTestCase("addBatchTest");
		homePage = loginPage.login(homePage);
		batchesPage = homePage.clickOnBatches();
		addBatchPage = batchesPage.clickOnAddBatch();
		addBatchPage.nameOfBatch("Batch12");
		addBatchPage.selectOffering(3);
		addBatchPage.selectSubject();
		addBatchPage.selectAcademicCycle(1);
		addBatchPage.startDate("08-05-2024");
		addBatchPage.endDate("08-05-2025");
		addBatchPage.clickOnSaveNext();
		addBatchPage.addTutor();
		addBatchPage.clickOnSaveNext();
		addBatchPage.addStudent();
		addBatchPage.clickOnSaveBatch();
		String flshMsgAct = addBatchPage.flshMsgAct();
		String batchsuccFlshMsg = data.batchsuccFlshMsg();
		Assert.assertEquals(flshMsgAct, batchsuccFlshMsg);
		Log.endTestCase("addBatchTest");

	}
}