package mocktest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;
import mocktest.dataprovider.DataProviders;

public class TestProPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//li[@data-content='Class Performance']")
	private WebElement myPerformance;

	@FindBy(xpath = "//h3[normalize-space()='Class Performance']")
	private WebElement myPerformanceRight;

	@FindBy(xpath = "//div[@class='card-header bg-warning pointer']")
	private WebElement calenderRight;

	@FindBy(xpath = "//aside[@class='main-sidebar sidebar-dark-primary elevation-1']//i[@class='fas fa-bars']")
	private WebElement humBurger;

	@FindBy(xpath = "//img[@alt='BM Logo']")
	private WebElement bmLogo;

	@FindBy(xpath = "//ul[@class='navbar-nav ml-auto']//li[@class='nav-item']")
	private WebElement notiFication;

	@FindBy(xpath = "(//small[@class='d-block text-muted'][normalize-space()='Online Assessment'])[1]")
	public WebElement mockExam1;



	public TestProPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateMyPerformance() throws Throwable {
		return action.isDisplayed(getDriver(), myPerformance);
	}

	public boolean validateMyPerformanceRight() throws Throwable {
		return action.isDisplayed(getDriver(), myPerformanceRight);

	}

	public boolean validateCalenderRight() throws Throwable {
		return action.isDisplayed(getDriver(), calenderRight);

	}

	public boolean validateHumBurger() throws Throwable {
		return action.isDisplayed(getDriver(), humBurger);

	}

	public boolean validateBmLogo() throws Throwable {
		return action.isDisplayed(getDriver(), bmLogo);

	}

	public boolean validateNotiFication() throws Throwable {
		return action.isDisplayed(getDriver(), notiFication);

	}

	public String getCurrURL() throws Throwable {
		String testProURL = action.getCurrentURL(getDriver());
		return testProURL;
	}

	public boolean validateMockExam1() throws Throwable {
		return action.isDisplayed(getDriver(), mockExam1);
	}

	public OnlineAssessmentPage clickOnMockExam1() {
		action.JSClick(getDriver(), mockExam1);
		return new OnlineAssessmentPage();
	}
	
	

}
