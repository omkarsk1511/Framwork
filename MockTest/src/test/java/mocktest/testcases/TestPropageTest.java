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
import mocktest.pageobjects.TestProPage;
import mocktest.utility.Log;

public class TestPropageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	private TestProPage testProPage;
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
	public void testProPageTest() throws Throwable {
		Log.startTestCase("testProPageTest");
		homePage = loginPage.login(homePage);
		testProPage = homePage.clickOnTestProLink();
		String actualURL = testProPage.getCurrURL();
		String expectedURL = data.testProPageUrl();
		Assert.assertEquals(actualURL, expectedURL);
		Log.endTestCase("testProPageTest");
	}

	@Test(groups = { "Smoke", "Sanity", "Regression" }, priority = 0)
	public void myPerformanceTest() throws Throwable {
		Log.startTestCase("myPerformanceTest");
		homePage = loginPage.login(homePage);
		testProPage = homePage.clickOnTestProLink();
		boolean result = testProPage.validateMyPerformance();
		Assert.assertTrue(result);
		Log.endTestCase("myPerformanceTest");
	}

	@Test(groups = { "Smoke", "Sanity", "Regression" }, priority = 1)
	public void myPerformanceRightTest() throws Throwable {
		Log.startTestCase("myPerformanceRightTest");
		homePage = loginPage.login(homePage);
		testProPage = homePage.clickOnTestProLink();
		boolean result = testProPage.validateMyPerformanceRight();
		Assert.assertTrue(result);
		Log.endTestCase("myPerformanceRightTest");
	}

	@Test(groups = { "Smoke", "Sanity", "Regression" }, priority = 1)
	public void calenderRightTest() throws Throwable {
		Log.startTestCase("calenderRightTest");
		homePage = loginPage.login(homePage);
		testProPage = homePage.clickOnTestProLink();
		boolean result = testProPage.validateCalenderRight();
		Assert.assertTrue(result);
		Log.endTestCase("calenderRightTest");
	}

	@Test(groups = { "Smoke", "Sanity", "Regression" }, priority = 0)
	public void humBurgerTest() throws Throwable {
		Log.startTestCase("humBurgerTest");
		homePage = loginPage.login(homePage);
		testProPage = homePage.clickOnTestProLink();
		boolean result = testProPage.validateHumBurger();
		Assert.assertTrue(result);
		Log.endTestCase("humBurgerTest");
	}

	@Test(groups = { "Smoke", "Sanity", "Regression" }, priority = 0)
	public void bmLogoTest() throws Throwable {
		Log.startTestCase("bmLogoTest");
		homePage = loginPage.login(homePage);
		testProPage = homePage.clickOnTestProLink();
		boolean result = testProPage.validateBmLogo();
		Assert.assertTrue(result);
		Log.endTestCase("bmLogoTest");
	}

	@Test(groups = { "Smoke", "Sanity", "Regression" }, priority = 0)
	public void notiFicationTest() throws Throwable {
		Log.startTestCase("notiFicationTest");
		homePage = loginPage.login(homePage);
		testProPage = homePage.clickOnTestProLink();
		boolean result = testProPage.validateNotiFication();
		Assert.assertTrue(result);
		Log.endTestCase("notiFicationTest");
	}

	@Test(groups = { "Smoke", "Sanity", "Regression" }, priority = 0)
	public void mockExam1Test() throws Throwable {
		Log.startTestCase("mockExam1Test");
		homePage = loginPage.login(homePage);
		testProPage = homePage.clickOnTestProLink();
		boolean result = testProPage.validateMockExam1();
		Assert.assertTrue(result);
		Log.endTestCase("mockExam1Test");
	}

}
