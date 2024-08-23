package mocktest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class OnlineAssessmentAttemptPage extends BaseClass{
	Action action= new Action();
	
	@FindBy(xpath ="//div[4]//span[1]//label[1]")
	public WebElement  selectOption;

	@FindBy(xpath ="//button[@id='next']")
	private WebElement  nextQuestion;
	
	@FindBy(xpath ="//button[@id='skip']")
	private WebElement  skipQuestion;
	
	@FindBy(xpath ="//button[normalize-space()='Finish']")
	private WebElement  finishExam;
	
	@FindBy(xpath ="//button[normalize-space()='Finish Now']")
	private WebElement  finishNowExam;
	
	@FindBy(xpath="//div[contains(@class,'pl-2 text-3')][normalize-space()='Total Percentage']")
	public WebElement percentage;
	
	public OnlineAssessmentAttemptPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnselectOption() {
		action.JSClick(getDriver(), selectOption);
	}
	
	public void clickOnnextQuestion() {
		action.JSClick(getDriver(), nextQuestion);
	}
	
	public void clickOnskipQuestion() {
		action.JSClick(getDriver(), skipQuestion);
	}
	
	public void clickOnfinishExam() {
		action.JSClick(getDriver(), finishExam);
	}
	
	public void clickOnfinishNowExam() {
		action.JSClick(getDriver(), finishNowExam);
	}
	public boolean validatePercentage() throws Throwable {
		action.fluentWait(getDriver(), percentage, 5);
		return action.isDisplayed(getDriver(), percentage);
	}
}
