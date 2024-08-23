package mocktest.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.actiondriver.Action;
import mocktest.actioninterface.ActionInterface;
import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;
import mocktest.dataprovider.DataProviders;
import mocktest.pageobjects.HomePage;
import mocktest.pageobjects.LoginPage;
import mocktest.pageobjects.OnlineAssessmentAttemptPage;
import mocktest.pageobjects.OnlineAssessmentPage;
import mocktest.pageobjects.StdHomePage;
import mocktest.pageobjects.TestProPage;
import mocktest.utility.Log;
import mocktest.pageobjects.EntranceInstructionPage;

public class Mocktest1 extends BaseClass {

	Action action = new Action();
	private LoginPage loginPage;
	private StdHomePage stdHomePage;
	private TestProPage testProPage;
	private OnlineAssessmentPage onlineAssessmentPage;
	private EntranceInstructionPage entranceInstructionPage;
	private OnlineAssessmentAttemptPage onlineAssessmentAttemptPage;
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
	public void mockExam1Test() throws Throwable {
		Log.startTestCase("mockExam1Test");
		stdHomePage = loginPage.login(stdHomePage);
		testProPage = stdHomePage.clickOnTestProLink();
		onlineAssessmentPage = testProPage.clickOnMockExam1();
		entranceInstructionPage = onlineAssessmentPage.clickOnJoinExam();
		entranceInstructionPage.clickOndeclarationCheck();
		onlineAssessmentAttemptPage = entranceInstructionPage.clickOnstartExam();

		for (int subject = 0; subject < 4; subject++) {
			for (int answeredQuestions = 0; answeredQuestions < 45; answeredQuestions++) {
				onlineAssessmentAttemptPage.clickOnselectOption();
				onlineAssessmentAttemptPage.clickOnnextQuestion();
			}
			System.out.println("Answer 45 questions");
			for (int skippedQuestions = 0; skippedQuestions < 5; skippedQuestions++) {
				onlineAssessmentAttemptPage.clickOnskipQuestion();
			}
			System.out.println("Skipped 5 questions");
		}
		onlineAssessmentAttemptPage.clickOnfinishExam();
		onlineAssessmentAttemptPage.clickOnfinishNowExam();
		boolean result = onlineAssessmentAttemptPage.validatePercentage();
		Assert.assertTrue(result);		
		
		//String actualURL = testProPage.getCurrURL();
		//String expectedURL = data.resultPageUrl();
		//Assert.assertEquals(actualURL, expectedURL);
		
	    Log.endTestCase("mockExam1Test");

	}

}
