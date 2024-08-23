package mocktest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class AddOfferingsPage extends BaseClass {

	Action action = new Action();

	@FindBy(id = "examName")
	private WebElement nameOfExam;

	@FindBy(id = "medium")
	private WebElement medium;

	@FindBy(id = "standard")
	private WebElement standard;

	@FindBy(id = "subject")
	private WebElement subject;

	@FindBy(xpath = "//div[@class='multiselect-dropdown-all-selector']")
	private WebElement ALL;

	@FindBy(id = "saveBtn")
	private WebElement save;

	@FindBy(id = "flash_message1")
	private WebElement succflshMsg;

	@FindBy(id = "flash_message2")
	private WebElement existFlshMsg;

	public AddOfferingsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void selectNameOfExam(String NEET) throws Throwable {
		action.selectByVisibleText(NEET, nameOfExam);
	}

	public void selectNameOfExam(int index) throws Throwable {
		action.selectByIndex(nameOfExam, index);
	}

	public void selectMedium(int index) throws Throwable {
		action.selectByIndex(medium, index);
	}

	public void selectStandard(int index) throws Throwable {
		action.selectByIndex(standard, index);
		action.fluentWait(getDriver(), standard, 3);

	}

	public boolean validateExistFlshMsgAct() throws Throwable {
		return action.isDisplayed(getDriver(), existFlshMsg);
	}

	public String existFlshMsgAct() throws Throwable {
		action.fluentWait(getDriver(), existFlshMsg, 3);
		String existFlshMsgAct = action.getText(existFlshMsg);
		return existFlshMsgAct;
	}

	public void selectAllSubject() {
		// action.fluentWait(getDriver(), subject, 2);
		action.JSClick(getDriver(), subject);
		// action.fluentWait(getDriver(), ALL, 3);
		action.JSClick(getDriver(), ALL);
	}

	public void clickOnSave() {
		action.JSClick(getDriver(), save);
	}

	public boolean validateSuccFlshMsgAct() throws Throwable {
		return action.isDisplayed(getDriver(), succflshMsg);
	}

	public String succFlshMsgAct() throws Throwable {
		//action.fluentWait(getDriver(), succflshMsg, 5);
		String succFlshMsgAct = action.getText(succflshMsg);
		return succFlshMsgAct;
	}

}
