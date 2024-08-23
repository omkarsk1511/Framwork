package mocktest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class EntranceInstructionPage  extends BaseClass{
	Action action= new Action();
	
	@FindBy(id = "proceed")
	private WebElement declarationCheck;
	
	@FindBy(id = "single_image")
	private WebElement checkSample;
	
	@FindBy(xpath ="//a[@title='Close']")
	private WebElement  closePopup;
	
	@FindBy(xpath ="//button[@class='button_outline proBut']")
	private WebElement  startExam;

	public EntranceInstructionPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void clickOndeclarationCheck() {
		action.scrollByVisibilityOfElement(getDriver(), declarationCheck);
		action.JSClick(getDriver(), declarationCheck);
	}
	
	public void clickOncheckSample() {
		action.JSClick(getDriver(), checkSample);
	}
	
	public void clickOnclosePopup() {
		action.JSClick(getDriver(), closePopup);
	}
	
	public OnlineAssessmentAttemptPage clickOnstartExam() {
		action.JSClick(getDriver(), startExam);
		return new OnlineAssessmentAttemptPage();
	}
	
}
