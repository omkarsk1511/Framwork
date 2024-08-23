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

public class LoginPageTest extends BaseClass {

	private LoginPage loginPage;
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
	public void loginUrlTest() throws Throwable {
		Log.startTestCase("loginUrlTest");
		String currURL = loginPage.getCurrURL();
		String loginPageUrl = data.loginPageUrl();
		Assert.assertEquals(currURL, loginPageUrl);
		Log.endTestCase("loginUrlTest");
	}

	@Test(groups = { "Smoke" }, priority = 1)
	public void userNameTest() throws Throwable {
		Log.startTestCase("userNameTest");
		loginPage.validateUserName();
		boolean result = loginPage.validateUserName();
		Assert.assertTrue(result);
		Log.endTestCase("userNameTest");
	}

	@Test(groups = { "Smoke" }, priority = 1)
	public void passwordTest() throws Throwable {
		Log.startTestCase("passwordTest");
		loginPage.validatePassword();
		boolean result = loginPage.validatePassword();
		Assert.assertTrue(result);
		Log.endTestCase("passwordTest");
	}

	@Test(groups = { "Smoke" }, priority = 1)
	public void forgotPasswordTest() throws Throwable {
		Log.startTestCase("forgotPasswordTest");
		loginPage.validateForgotPassword();
		boolean result = loginPage.validateForgotPassword();
		Assert.assertTrue(result);
		Log.endTestCase("forgotPasswordTest");
	}

	@Test(groups = { "Smoke" }, priority = 1)
	public void signInBtnTest() throws Throwable {
		Log.startTestCase("signInBtnTest");
		loginPage.validateSignInBtn();
		boolean result = loginPage.validateSignInBtn();
		Assert.assertTrue(result);
		Log.endTestCase("signInBtnTest");
	}

}
