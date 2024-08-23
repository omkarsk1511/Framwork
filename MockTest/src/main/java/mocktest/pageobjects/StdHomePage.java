package mocktest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class StdHomePage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//div[@class='user-toggle']")
	private WebElement userProfile;
	
	@FindBy(xpath = "//a[@class='logo-link nk-sidebar-logo']")
	private WebElement logo;
	
	@FindBy(xpath ="//span[normalize-space()='TestPro']")
	private WebElement testProLink;
	
	@FindBy(xpath = "//span[normalize-space()='My Institute']")
	private WebElement myInstitute;	
	
	@FindBy(xpath = "//li[@class='nk-menu-item has-sub active']//span[@class='nk-menu-text sub-menu'][normalize-space()='Offerings']")
	private WebElement offerings;	
	
	@FindBy(xpath = "//span[normalize-space()='Academic Cycle']")
	private WebElement academicCycle;	
	
	@FindBy(xpath = "//span[normalize-space()='Batches']")
	private WebElement batches;
	
	
	
	
	public StdHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public TestProPage clickOnTestProLink() throws Throwable {
		action.JSClick(getDriver(), testProLink);
		return new TestProPage();
	}	
	
	public boolean validateUserProfile() throws Throwable {
		return action.isDisplayed(getDriver(), userProfile);
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), logo);
	}
	
	public boolean validateTestProLink() throws Throwable {
		return action.isDisplayed(getDriver(), testProLink);
		
	}
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}
	
	public void clickOnMyInstitute() {
		action.JSClick(getDriver(), myInstitute);
	}
		
	public OfferingsPage clickOnOfferings() {
		action.JSClick(getDriver(), myInstitute);
		action.JSClick(getDriver(), offerings);
		return new OfferingsPage();
	}
	public AcademicCyclePage clickOnAcademicCycle() {
		action.JSClick(getDriver(), myInstitute);
		action.JSClick(getDriver(), academicCycle);
		return new AcademicCyclePage();
	}
	public BatchesPage clickOnBatches() {
		action.JSClick(getDriver(), myInstitute);
		action.JSClick(getDriver(), batches);
		return new BatchesPage();
	}

}
