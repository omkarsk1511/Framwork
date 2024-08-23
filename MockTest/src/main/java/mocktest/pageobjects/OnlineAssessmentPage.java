package mocktest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class OnlineAssessmentPage extends BaseClass {
	Action action= new Action();
					
	@FindBy(xpath = "//button[@class='btn btn-success-dark py-2 btn-block mt-5 button_outline nonpopup']")
	private WebElement joinExam;
	
	public OnlineAssessmentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public EntranceInstructionPage clickOnJoinExam() {
		action.JSClick(getDriver(), joinExam);
		return new EntranceInstructionPage();
	}
}
	