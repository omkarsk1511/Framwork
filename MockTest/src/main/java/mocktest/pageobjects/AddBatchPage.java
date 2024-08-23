package mocktest.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mocktest.actiondriver.Action;
import mocktest.base.BaseClass;

public class AddBatchPage extends BaseClass {

	Action action = new Action();

	@FindBy(id = "batch_name")
	private WebElement nameOfBatch;

	@FindBy(id = "offering_name")
	private WebElement offering;

	@FindBy(xpath = "//div[@class='css-1hwfws3']")
	private WebElement subjects;

	@FindBy(xpath = "//div[@class='css-xwjg1b']")
	private List<WebElement> totalSubjects;

	@FindBy(id = "react-select-2-option-0")
	private WebElement all;

	@FindBy(id = "academic_name")
	private WebElement academicCycle;

	@FindBy(xpath = "//body/div[@class='nk-app-root']/div[@id='read_scrp_default']/div[@class='nk-main']/div[@class='nk-wrap ']/div[@id='nk-content-genext']/div[@class='container-xl wide-lg']/div[@class='nk-content-body']/div[@id='content-wrapper']/div[@class='row']/div[@id='batch-root']/div/div[@class='multistep-layout']/div[@class='tab-body']/form[@id='step1']/div[@class='row mt-3']/div[1]/div[1]/input[1]")
	private WebElement startDate;

	@FindBy(xpath = "//body/div[@class='nk-app-root']/div[@id='read_scrp_default']/div[@class='nk-main']/div[contains(@class,'nk-wrap')]/div[@id='nk-content-genext']/div[@class='container-xl wide-lg']/div[@class='nk-content-body']/div[@id='content-wrapper']/div[@class='row']/div[@id='batch-root']/div/div[@class='multistep-layout']/div[@class='tab-body']/form[@id='step1']/div[@class='row mt-3']/div[2]/div[1]/input[1]")
	private WebElement endDate;

	@FindBy(xpath = "//button[normalize-space()='Save & Next']")
	private WebElement saveNext;

	@FindBy(xpath = "(//p[contains(@class,'text-center')][normalize-space()='Add Tutors'])[1]")
	private WebElement addTutor;

	// input[@class='ms-2 me-1']
	@FindBy(xpath = "//input[@class='ms-2 me-1']")
	private WebElement allTutors;

	// button[contains(@fdprocessedid,'qbsihe')]
	@FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='Save'])[1]")
	private WebElement saveTutors;
	
	@FindBy(xpath = "//button[normalize-space()='Previous']")
	private WebElement previous;
	

	@FindBy(xpath = "//button[normalize-space()='Add Student']")
	private WebElement addStudent;

	@FindBy(xpath = "//input[@class='ms-2']")
	private WebElement allStudent;

	@FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='Save'])[3]")
	private WebElement saveStudnet;

	@FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='Save'])[1]")
	private WebElement saveBatch;

	@FindBy(id = "flash_message")
	private WebElement flshMsg;

	@FindBy(xpath = "//span[normalize-space()='Batch name is already exits']")
	private WebElement batchExist;

	public AddBatchPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void nameOfBatch(String BatchName) throws Throwable {
		action.type(nameOfBatch, BatchName);
	}

	public void selectOffering(int index) throws Throwable {
		action.selectByIndex(offering, index);
	}

	public void selectSubject() {
		action.fluentWait(getDriver(), subjects, 3);
		action.JSClick(getDriver(), subjects);
		action.JSClick(getDriver(), all);
		action.scrollByVisibilityOfElement(getDriver(), academicCycle);
	}

	public void selectAcademicCycle(int index) throws Throwable {
		action.selectByIndex(academicCycle, index);
	}

	public void startDate(String Date) throws Throwable {
		action.type(startDate, Date);
	}

	public void endDate(String Date) throws Throwable {
		action.type(endDate, Date);
	}

	public void clickOnSaveNext() throws Exception {
		action.fluentWait(getDriver(), saveNext, 1);
		action.scrollByVisibilityOfElement(getDriver(), saveNext);
		action.JSClick(getDriver(), saveNext);
	}
	
	
	public void clickOnPrevious() throws Exception {
		action.fluentWait(getDriver(), previous, 1);
		action.scrollByVisibilityOfElement(getDriver(), previous);
		action.JSClick(getDriver(), previous);
	}

	public boolean validateAddTutor() throws Exception {
		return action.isDisplayed(getDriver(), addTutor);
	}

	public void addTutor() {
		int TotalSubjects = totalSubjects.size();
		for (int i = 1; i <= TotalSubjects; i++) {
			action.JSClick(getDriver(), addTutor);
			action.JSClick(getDriver(), allTutors);
			action.JSClick(getDriver(), saveTutors);
		}
	}

	public void addStudent() {
		action.scrollByVisibilityOfElement(getDriver(), addStudent);
		action.JSClick(getDriver(), addStudent);
		action.JSClick(getDriver(), allStudent);
		action.JSClick(getDriver(), saveStudnet);
	}

	public void clickOnSaveBatch() {
		action.scrollByVisibilityOfElement(getDriver(), saveBatch);
		action.JSClick(getDriver(), saveBatch);

	}

	public String flshMsgAct() throws Throwable {
		// action.fluentWait(getDriver(), flshMsg, 1/2);
		String flshMsgAct = action.getText(flshMsg);
		return flshMsgAct;
	}

	public boolean validateBatchExistError() throws Throwable {
		action.fluentWait(getDriver(), flshMsg, 1);
		return action.isDisplayed(getDriver(), batchExist);

	}

	public String batchExistErrorText() throws Throwable {

		String batchExistErrorText = action.getText(batchExist);
		return batchExistErrorText;

	}

}
